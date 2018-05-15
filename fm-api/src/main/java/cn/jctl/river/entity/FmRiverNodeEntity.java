package cn.jctl.river.entity;

import java.util.Date;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public class FmRiverNodeEntity {
    private Long riverId;
    private Long nodeId;
    private String riverNumber;
    private String riverName;
    private String riverAddress;
    private String riverArea;
    private String nodeLon;
    private String nodeLat;
    private String riverManager;
    private String nodeNumber;
    private String riverUrl;
    private Date createTime;
    private Long userId;

    public String getRiverNumber() {
        return riverNumber;
    }

    public void setRiverNumber(String riverNumber) {
        this.riverNumber = riverNumber;
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getRiverAddress() {
        return riverAddress;
    }

    public void setRiverAddress(String riverAddress) {
        this.riverAddress = riverAddress;
    }

    public String getRiverArea() {
        return riverArea;
    }

    public void setRiverArea(String riverArea) {
        this.riverArea = riverArea;
    }

    public String getNodeLon() {
        return nodeLon;
    }

    public void setNodeLon(String nodeLon) {
        this.nodeLon = nodeLon;
    }

    public String getNodeLat() {
        return nodeLat;
    }

    public void setNodeLat(String nodeLat) {
        this.nodeLat = nodeLat;
    }

    public String getRiverManager() {
        return riverManager;
    }

    public void setRiverManager(String riverManager) {
        this.riverManager = riverManager;
    }

    public String getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(String nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public String getRiverUrl() {
        return riverUrl;
    }

    public void setRiverUrl(String riverUrl) {
        this.riverUrl = riverUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRiverId() {
        return riverId;
    }

    public void setRiverId(Long riverId) {
        this.riverId = riverId;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }
}
