package cn.jctl.netty.util;

import cn.jctl.entity.FmCollectEntity;
import cn.jctl.entity.FmNodeEntity;
import cn.jctl.entity.FmRelayEntity;
import cn.jctl.netty.entity.ClientDataResult;
import cn.jctl.netty.entity.Head;
import cn.jctl.netty.entity.Sensor;
import cn.jctl.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by majiangtao on 2018/5/10.
 */
public class TimeDecodeUtil {

    private static final Logger log = LoggerFactory.getLogger(TimeDecodeUtil.class);

    /**
     * 解释消息头
     *
     * @param headStr AA004C918A0Cxxxxxxxxxxxxxxxxxxxxxxxx0Cyyyyyyyyyyyyyyyyyyyyyyyy02
     * @return
     */
    public ClientDataResult decodeHead(ClientDataResult result, String headStr) {
        if (headStr == null) {
            return null;
        }
        Head head = Head.getInstance();
        String[] headArray = headStr.split("0C");
        head.setStart(headArray[0].substring(0, 2));
        head.setLength(tenCastSixteen(headArray[0].substring(2, 6)));
        head.setSender(tenCastSixteen(headArray[0].substring(6, 8)));
        head.setOrientation(tenCastSixteen(headArray[0].substring(8, 10)));

        //得到中继信息
        FmRelayEntity relay = new FmRelayEntity();
        relay.setRelayMaclen(tenCastSixteen("0C") + "");
        relay.setRelayMac(headArray[1]);
        //得到节点信息
        FmNodeEntity node = new FmNodeEntity();
        node.setNodemaclen(tenCastSixteen("0C") + "");
        node.setNodemac(headArray[2].substring(0, headArray[2].length() - 2));
        log.debug("headArray:" + headArray[2]);
        //得到传感器个数
        head.setSensorNum(tenCastSixteen(headArray[2].substring(headArray[2].length() - 2, headArray[2].length())));
        log.debug(head.toString() + relay.toString() + node.toString());
        result.setHead(head);
        result.setRelay(relay);
        result.setNode(node);
        return result;
    }

    /**
     * 解释消息体
     *
     * @return
     */
    public ClientDataResult decodeBody(String bodyStr, ClientDataResult clientDataResult, int sensorNum) {
        if (bodyStr == null) {
            return null;
        }
        //根据传感器个数，截取得到传感器数据字符串数组
        String[] bodys = new String[sensorNum];
        for (int i = 0; i < sensorNum && sensorNum > 0; i++) {
            if (i != 0) {
                //一个以上传感器时
                bodys[i] = bodyStr.substring(i * (bodys[i - 1].length()), (i + 1) * Constant.Sensor_Len.AUTO.getValue());
            } else {
                //只有一个传感器时
                bodys[i] = bodyStr.substring(i, Constant.Sensor_Len.AUTO.getValue());
            }
            log.info("sensor" + i + ":" + bodys[i]);
        }
        String[] bodyChilds = bodys;
        List<FmCollectEntity> collects = new ArrayList<>();
        String data;
        Sensor sensor;
        FmCollectEntity collect;
        for (int i = 0; i < bodyChilds.length; i++) {
            List<Sensor> sensors = new ArrayList<>();
            sensor = new Sensor();
            sensor.setId(tenCastSixteen(bodyChilds[i].substring(0, 2)));
            String bodyData = bodyChilds[i].substring(2, bodyChilds[i].length());
            int start;
            for (int j = 0; j < 4; j++) {
                collect = new FmCollectEntity();
                if (j == 0) {
                    data = bodyData.substring(0, 10);
                    log.info("bodyData:[data:" + data + "\tstart:" + 0 + "\tend:" + (j + 1) * 10 + "]");
                } else {
                    start = j * 10;
                    data = bodyData.substring(start, (j + 1) * 10);
                    log.info("bodyData:[data:" + data + "\tstart:" + start + "\tend:" + (j + 1) * 10 + "]");
                }
                collect.setCollectId(tenCastSixteen(data.substring(0, 2)));
                collect.setData(tenCastSixteen(data.substring(2, 6)) + "." + tenCastSixteen(data.substring(6, 10)));
                collects.add(collect);
            }
            sensors.add(sensor);
            sensor.setCollects(collects);
            clientDataResult.setSensors(sensors);
        }
        return clientDataResult;
    }

    /**
     * 十六进制字符串转十进制整数
     *
     * @param sixteenNum
     * @return
     */
    public int tenCastSixteen(String sixteenNum) {
        return Integer.parseInt(sixteenNum, 16);
    }
}
