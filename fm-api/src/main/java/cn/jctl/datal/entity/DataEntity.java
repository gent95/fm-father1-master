package cn.jctl.datal.entity;

import java.util.Date;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public class DataEntity {
    private String data;
    private Date createTime;
    private String paramName;
    private String unit;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        return "DataEntity{" +
                "data='" + data + '\'' +
                ", createTime=" + createTime +
                ", paramName='" + paramName + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
