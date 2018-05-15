package cn.jctl.river.entity;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public class FmWaterareaEntity {
    private Long riverId;
    private Long nodeId;
    private String riverNumber;
    private String riverName;
    private String riverAddress;
    private String riverArea;
    private String riverManager;
    private String riverUrl;
    private String nodeLon;
    private String nodeLat;
    private Integer nodeNum;
    private String nodeNumber;

    public Long getRiverId() {
        return riverId;
    }

    public void setRiverId(Long riverId) {
        this.riverId = riverId;
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

    public String getRiverManager() {
        return riverManager;
    }

    public void setRiverManager(String riverManager) {
        this.riverManager = riverManager;
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

    public Integer getNodeNum() {
        return nodeNum;
    }

    public void setNodeNum(Integer nodeNum) {
        this.nodeNum = nodeNum;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getRiverNumber() {
        return riverNumber;
    }

    public void setRiverNumber(String riverNumber) {
        this.riverNumber = riverNumber;
    }

    public String getRiverUrl() {
        return riverUrl;
    }

    public void setRiverUrl(String riverUrl) {
        this.riverUrl = riverUrl;
    }

    public String getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(String nodeNumber) {
        this.nodeNumber = nodeNumber;
    }
}
