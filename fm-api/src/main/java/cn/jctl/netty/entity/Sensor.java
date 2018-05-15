package cn.jctl.netty.entity;

/**
 * Created by majiangtao on 2018/4/19.
 */

import cn.jctl.entity.FmCollectEntity;

import java.util.List;

/**
 * 传感器
 */
public class Sensor {
    private int id;
    private List<FmCollectEntity> collects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FmCollectEntity> getCollects() {
        return collects;
    }

    public void setCollects(List<FmCollectEntity> collects) {
        this.collects = collects;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", collects=" + collects +
                '}';
    }


}
