package cn.jctl.netty.entity;

/**
 * Created by majiangtao on 2018/4/17.
 */

/**
 * 中继
 */
public class Relay {
    private int relayMacLen; //中继编号长度
    private String relayMac; //中继编号

    public int getRelayMacLen() {
        return relayMacLen;
    }

    public void setRelayMacLen(int relayMacLen) {
        this.relayMacLen = relayMacLen;
    }

    public String getRelayMac() {
        return relayMac;
    }

    public void setRelayMac(String relayMac) {
        this.relayMac = relayMac;
    }

    @Override
    public String toString() {
        return "Relay{" +
                "relayMacLen=" + relayMacLen +
                ", relayMac='" + relayMac + '\'' +
                '}';
    }

    public Relay() {
    }
}
