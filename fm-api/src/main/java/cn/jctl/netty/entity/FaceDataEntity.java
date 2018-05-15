package cn.jctl.netty.entity;

/**
 * Created by majiangtao on 2018/5/7.
 */
public class FaceDataEntity {
    private String data;
    private String param_name;
    private String unit;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getParam_name() {
        return param_name;
    }

    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "FaceDataEntity{" +
                "data='" + data + '\'' +
                ", param_name='" + param_name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
