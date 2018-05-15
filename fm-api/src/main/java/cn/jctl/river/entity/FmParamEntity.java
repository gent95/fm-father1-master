package cn.jctl.river.entity;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public class FmParamEntity {
    private String riverName;
    private String riverArea;
    private String riverUrl;
    private String nodeName;
    private String nodeLat;
    private String nodeLon;
    private Integer type;
    private String paramName;
    private String unit;
    private String data;

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getRiverArea() {
        return riverArea;
    }

    public void setRiverArea(String riverArea) {
        this.riverArea = riverArea;
    }

    public String getRiverUrl() {
        return riverUrl;
    }

    public void setRiverUrl(String riverUrl) {
        this.riverUrl = riverUrl;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeLat() {
        return nodeLat;
    }

    public void setNodeLat(String nodeLat) {
        this.nodeLat = nodeLat;
    }

    public String getNodeLon() {
        return nodeLon;
    }

    public void setNodeLon(String nodeLon) {
        this.nodeLon = nodeLon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
