package cn.jctl.netty;

/**
 * Created by majiangtao on 2018/5/7.
 */

import cn.jctl.common.utils.DateUtils;
import cn.jctl.common.utils.MapUtils;
import cn.jctl.common.utils.RedisUtils;
import cn.jctl.entity.*;
import cn.jctl.netty.entity.ClientDataResult;
import cn.jctl.netty.entity.FaceDataEntity;
import cn.jctl.netty.entity.Sensor;
import cn.jctl.netty.util.TimeDecodeUtil;
import cn.jctl.service.*;
import cn.jctl.utils.Constant;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by majiangtao on 2018/5/7.
 */
@Component
@Qualifier("serverHandler")
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<String> {
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private FmRelayService relayService;
    @Autowired
    private FmNodeService nodeService;
    @Autowired
    private FmSensorService sensorService;
    @Autowired
    private FmCollectService collectService;
    @Autowired
    private FmParamService paramService;

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String requestMsg)
            throws Exception {
        /**
         * 解析接收到的消息
         */
        ClientDataResult result = new ClientDataResult();
        TimeDecodeUtil timeDecodeUtil = new TimeDecodeUtil();
        //解析并封装消息头到ClientResult
        String headStr = requestMsg.toString().substring(0, Constant.Order.AUTO.getValue());
        result = timeDecodeUtil.decodeHead(result, headStr);
        //解析并封装消息体到ClientResult
        String bodyStr = requestMsg.toString().substring(Constant.Order.AUTO.getValue(), Constant.Order.AUTO.getValue() + (2 + 10 * Constant.Collect_Num.AUTO.getValue()) * result.getHead().getSensorNum() + 2);
        String bodyStr1 = bodyStr.substring(0, bodyStr.length());
        result = timeDecodeUtil.decodeBody(bodyStr1, timeDecodeUtil.decodeHead(result, headStr), result.getHead().getSensorNum());
        System.out.println("Result:"+result.toString());
        //从数据库获得实施插入的采集点数据与采集单位及采集量名称，并放入redis缓存
        List<FaceDataEntity> datas = new ArrayList();
        List<FmCollectEntity> collects = saveDecodeData(result);
        FmParamEntity paramEntity;
        //循环封装返回信息
        for (FmCollectEntity c : collects) {
            log.debug(c.toString());
            FaceDataEntity faceDataEntity = new FaceDataEntity();
            if (c.getParamId() != null){
                paramEntity = JSON.parseObject(redisUtils.get("param_" + c.getParamId()), FmParamEntity.class);
                faceDataEntity.setUnit(paramEntity.getUnit());
                faceDataEntity.setParam_name(paramEntity.getParamName());
            }
            faceDataEntity.setData(c.getData());
            datas.add(faceDataEntity);
        }
        //将分装的相应信息保存到redis缓存
        redisUtils.set(result.getNode().getNodemac(), datas);
        log.info("redis-save:" + redisUtils.get(result.getNode().getNodemac()));
    }

    /**
     * 将解码后的数据保存到数据库
     *
     * @param result
     */
    public List<FmCollectEntity> saveDecodeData(ClientDataResult result) {
        List<FmRelayEntity> relays = relayService.selectByMap(new MapUtils().put("relay_mac", result.getRelay().getRelayMac()));

        //保存中继信息
        if (relays.size() == 0) {
            FmRelayEntity fmRelayEntity = result.getRelay();
            fmRelayEntity.setCreateTime(DateUtils.format_datetime(new Date()));
            relayService.insert(fmRelayEntity);
        }

        //保存节点信息
        List<FmNodeEntity> nodes = nodeService.selectByMap(new MapUtils().put("nodeMac", result.getNode().getNodemac()));
        if (nodes.size() == 0) {
            relays = relayService.selectByMap(new MapUtils().put("relay_mac", result.getRelay().getRelayMac()));
            FmNodeEntity fmNodeEntity = result.getNode();
            fmNodeEntity.setRelayId(relays.get(relays.size() - 1).getId());
            fmNodeEntity.setCreateTime(DateUtils.format_datetime(new Date()));
            nodeService.insert(fmNodeEntity);
        }

        //保存传感器信息
        nodes = nodeService.selectByMap(new MapUtils().put("nodeMac", result.getNode().getNodemac()));
        List<FmSensorEntity> sensors = sensorService.selectByMap(new MapUtils().put("node_id", nodes.get(nodes.size() - 1).getId()));
        if (sensors.size() == 0) {
            for (Sensor s : result.getSensors()) {
                FmSensorEntity fmSensorEntity = new FmSensorEntity();
                fmSensorEntity.setSensorMac(s.getId() + "");
                fmSensorEntity.setNodeId(nodes.get(nodes.size() - 1).getId());
                fmSensorEntity.setCreateTime(DateUtils.format_datetime(new Date()));
                sensorService.insert(fmSensorEntity);
            }
        }
        sensors = sensorService.selectByMap(new MapUtils().put("node_id", nodes.get(nodes.size() - 1).getId()));
        for (FmSensorEntity s: sensors) {
            for (Sensor rs: result.getSensors()) {
                rs.setId(Integer.parseInt(s.getSensorMac()));
            }
        }
        System.out.println("-------------"+nodes.get(nodes.size()-1).getId());
        return saveCollect(result, nodes);
    }

    /**
     * 保存采集点数据到数据库
     *
     * @param nodes
     */
    public List<FmCollectEntity> saveCollect(ClientDataResult result, List<FmNodeEntity> nodes) {
        List<FmCollectEntity> collects = new ArrayList<>();
        for (Sensor s : result.getSensors()) {
            log.info("---------s----------"+s.toString());
            for (FmCollectEntity c : s.getCollects()) {
                List<FmSensorEntity> sensors = sensorService.selectByMap(new MapUtils().put("sensor_mac", s.getId()).put("node_id", nodes.get(nodes.size() - 1).getId()));
                log.debug("collect_id" + c.getCollectId() + "\nsensor_id:" + sensors.get(sensors.size() - 1).getId());
                List<FmCollectEntity> collectList = collectService.selectByMap(new MapUtils().put("collect_id", c.getCollectId()).put("sensor_id", sensors.get(sensors.size() - 1).getId()));
                if (collectList.size() != 0) {
                    Long paramId = collectList.get(collectList.size() - 1).getParamId();
                    c.setParamId(paramId);
                }
                c.setCreateTime(DateUtils.format_datetime(new Date()));
                c.setSensorId(sensors.get(sensors.size() - 1).getId());
                collects.add(c);
                //判断当前时间是否是整点
//                if (Integer.parseInt(DateUtils.get_Now_Date().split(":")[2].replace(" ", "")) == 00) {
                    collectService.insert(c);
//                }
            }
        }
        return collects;
    }

    /**
     * 项目启动时初始化采集点参数信息到redis缓存
     */
    @PostConstruct
    public void initParam() {
        for (FmParamEntity p : paramService.selectAll()) {
            redisUtils.set("param_" + p.getId(), p, RedisUtils.DEFAULT_EXPIRE * 7);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        log.info("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
        super.channelActive(ctx);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("\nChannel is disconnected");
        super.channelInactive(ctx);
    }
}
