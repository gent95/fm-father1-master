//package cn.jctl.service.netty;
//
///**
// * Created by majiangtao on 2018/4/17.
// */
//
//import cn.jctl.common.utils.DateUtils;
//import cn.jctl.common.utils.MapUtils;
//import cn.jctl.common.utils.RedisUtils;
//import cn.jctl.entity.FmCollectEntity;
//import cn.jctl.entity.FmNodeEntity;
//import cn.jctl.entity.FmRelayEntity;
//import cn.jctl.entity.FmSensorEntity;
//import cn.jctl.service.netty.entity.*;
//import cn.jctl.service.FmCollectService;
//import cn.jctl.service.FmNodeService;
//import cn.jctl.service.FmRelayService;
//import cn.jctl.service.FmSensorService;
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.ByteToMessageDecoder;
//import io.netty.util.CharsetUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 解码
// */
//@Component
//public class Decode extends ByteToMessageDecoder {
//    private static final Logger log = LoggerFactory.getLogger(Decode.class);
//    private ClientDataResult result;
//
//    @Resource(name = "fmRelayService")
//    private FmRelayService relayService;
//    @Resource(name = "fmNodeService")
//    private FmNodeService nodeService;
//    @Resource(name = "fmSensorService")
//    private FmSensorService sensorService;
//    @Resource(name = "fmCollectService")
//    private FmCollectService collectService;
//
////    private Jedis jedis = new Jedis("localhost",6379);
////    @Resource(name = "redisUtils")
////    private RedisUtils redisUtils;
//
//    @Override
//    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
//
//        /**
//         * 对接收到的数据进行解码
//         */
//        if (byteBuf == null){
//            return;
//        }
//        String resultByteBuf = byteBuf.toString(CharsetUtil.UTF_8);
//        String headStr = resultByteBuf.substring(0,62);
//        String bodyStr = resultByteBuf.substring(62,62+(2+10*4)*2+2);
//        result = decodeHead(headStr);
//        result.setSensorNum(tenCastSixteen(bodyStr.substring(0,2)));
//        String bodyStr1 = bodyStr.substring(2,bodyStr.length());
//        result = decodeBody(bodyStr1,decodeHead(headStr));
//        log.info(result.toString());
////        jedis.set("result",result.toString());
////        redisUtils.set("result",result.toString());
//
//        /**
//         * 将解码后的数据保存到数据库
//         */
//        List<FmRelayEntity> relays = relayService.selectByMap(new MapUtils().put("relay_mac",result.getRelay().getRelayMac()));
//        if (relays != null){
//            for (FmRelayEntity r: relays) {
//                if (r.getRelayMac() != null){
//                    FmNodeEntity node = new FmNodeEntity();
//                    node.setNodemaclen(Long.parseLong(result.getNode().getNodeMacLen()+""));
//                    node.setNodemac(result.getNode().getNodeMac());
//                    node.setRelayId(r.getId());
//                    log.debug("\n封装node"+node.toString());
//                    nodeService.insert(node);
//                }
//            }
//        }else{
//            FmRelayEntity relay = new FmRelayEntity();
//            relay.setRelayMaclen(result.getRelay().getRelayMacLen()+"");
//            relay.setRelayMac(result.getRelay().getRelayMac());
//            log.debug("\n封装relay"+relay.toString());
//            relayService.insert(relay);
//        }
//
//
//        for (Sensor s:result.getSensors()) {
//            FmSensorEntity sensor = new FmSensorEntity();
//            sensor.setSensorMac(s.getId()+"");
//            for (Collect c:s.getCollects()) {
//                FmCollectEntity collect = new FmCollectEntity();
//                collect.setCollectId(c.getId());
//                collect.setData(c.getData());
//                collect.setData(DateUtils.DATE_TIME_PATTERN);
//                collectService.insert(collect);
//            }
//            sensorService.insert(sensor);
//        }
//
//
//    }
//
//    /**
//     * 解释消息体
//     * @return
//     */
//    public ClientDataResult decodeBody(String bodyStr,ClientDataResult clientDataResult){
//        if (bodyStr == null){
//            return null;
//        }
//        String bodyChild1 = bodyStr.substring(0,bodyStr.length()/2);
//        String bodyChild2 = bodyStr.substring(bodyStr.length()/2,bodyStr.length());
//        String[] bodyChilds = new String[]{bodyChild1,bodyChild2};
//        List<Sensor> sensors = new ArrayList<>();
//        List<Collect> collects = new ArrayList<>();
//        String data;
//        Sensor sensor;
//        Collect collect;
//        for (int i = 0; i < bodyChilds.length; i ++){
//            sensor = new Sensor();
//            sensor.setId(tenCastSixteen(bodyChilds[i].substring(0,2)));
//            String  bodyData = bodyChilds[i].substring(2,bodyChilds[i].length());
//            int start;
//            for (int j = 0; j < 4; j++){
//                collect = new Collect();
//                if (j == 0){
//                    data = bodyData.substring(0,10);
//                }else {
//                    start = j*10;
//                    data = bodyData.substring(start,(j+1)*10);
//                    log.info("bodyData:[data:"+data+"\tstart:" + start+"\tend:"+(j+1)*10+"]");
//                }
//                collect.setId(tenCastSixteen(data.substring(0,2)));
//                collect.setData(tenCastSixteen(data.substring(2,6))+"."+tenCastSixteen(data.substring(6,10)));
//                collects.add(collect);
//                sensors.add(sensor);
//            }
//            sensor.setCollects(collects);
//            clientDataResult.setSensors(sensors);
//        }
//        return clientDataResult;
//    }
//
//    /**
//     * 解释消息头
//     * @param headStr  AA004C918A0Cxxxxxxxxxxxxxxxxxxxxxxxx0Cyyyyyyyyyyyyyyyyyyyyyyyy02
//     * @return
//     */
//    public ClientDataResult decodeHead(String headStr){
//        if (headStr == null){
//            return null;
//        }
//        Head head = Head.getInstance();
//        String[] headArray = headStr.split("0C");
//
//        head.setStart(headArray[0].substring(0,2));
//        head.setLength(tenCastSixteen(headArray[0].substring(2,6)));
//        head.setSender(tenCastSixteen(headArray[0].substring(6,8)));
//        head.setOrientation(tenCastSixteen(headArray[0].substring(8,10)));
//
//        Relay relay = new Relay();
//        relay.setRelayMacLen(tenCastSixteen("0C"));
//        relay.setRelayMac(headArray[1]);
//        Node node = new Node();
//        node.setNodeMacLen(tenCastSixteen("0C"));
//        node.setNodeMac(headArray[2]);
//        return new ClientDataResult(head,relay,node);
//    }
//
//    public int tenCastSixteen(String sixteenNum){
//        return Integer.parseInt(sixteenNum,16);
//    }
//}
