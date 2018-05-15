package cn.jctl.netty.entity;

/**
 * Created by majiangtao on 2018/4/17.
 */

/**
 * 节点
 */
public class Node {
    private int nodeMacLen; //节点编号长度
    private String nodeMac; //节点编号

    public int getNodeMacLen() {
        return nodeMacLen;
    }

    public void setNodeMacLen(int nodeMacLen) {
        this.nodeMacLen = nodeMacLen;
    }

    public String getNodeMac() {
        return nodeMac;
    }

    public void setNodeMac(String nodeMac) {
        this.nodeMac = nodeMac;
    }

    public Node(int nodeMacLen, String nodeMac) {
        this.nodeMacLen = nodeMacLen;
        this.nodeMac = nodeMac;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeMacLen=" + nodeMacLen +
                ", nodeMac='" + nodeMac + '\'' +
                '}';
    }
}
