package cn.jctl.netty.entity;

/**
 * Created by majiangtao on 2018/4/17.
 */

import cn.jctl.entity.FmNodeEntity;
import cn.jctl.entity.FmRelayEntity;

import java.util.List;

/**
 * 周期上传报文对象
 */
public class ClientDataResult {
    private Head head;
    private FmRelayEntity relay; //中继
    private FmNodeEntity node;//节点
    private List<Sensor> sensors; //传感器
    private String checkNum; //校验码
    private String end;

    public ClientDataResult(Head head, FmRelayEntity relay, FmNodeEntity node) {
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public FmRelayEntity getRelay() {
        return relay;
    }

    public void setRelay(FmRelayEntity relay) {
        this.relay = relay;
    }

    public FmNodeEntity getNode() {
        return node;
    }

    public void setNode(FmNodeEntity node) {
        this.node = node;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "ClientDataResult{" +
                "head=" + head +
                ", relay=" + relay +
                ", node=" + node +
                ", sensors=" + sensors +
                ", checkNum='" + checkNum + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    public ClientDataResult() {
    }
}
