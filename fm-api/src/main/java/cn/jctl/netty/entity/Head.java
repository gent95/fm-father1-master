package cn.jctl.netty.entity;

/**
 * Created by majiangtao on 2018/4/17.
 */

/**
 * 消息头
 */
public class Head {
    private String start; //启始 AA
    private int length; //命令总长度
    private int sender; //发送方向 91:Client --> Server
    private int orientation; //定向 8A:上行
    private int sensorNum;

    public int getSensorNum() {
        return sensorNum;
    }

    public void setSensorNum(int sensorNum) {
        this.sensorNum = sensorNum;
    }

    private static Head head;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Head() {
    }

    public Head(String start, int length, int sender, int orientation) {
        this.start = start;
        this.length = length;
        this.sender = sender;
        this.orientation = orientation;
    }

    public static Head getInstance(){
        if (head == null){
            return new Head();
        }
        return head;
    }

    @Override
    public String toString() {
        return "Head{" +
                "start='" + start + '\'' +
                ", length=" + length +
                ", sender=" + sender +
                ", orientation=" + orientation +
                ", sensorNum=" + sensorNum +
                '}';
    }
}
