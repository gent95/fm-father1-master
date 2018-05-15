package cn.jctl.netty.entity;

/**
 * Created by majiangtao on 2018/4/17.
 */

/**
 * 传感器
 */
public class Collect {
   private int id;
   private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Collect(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public Collect() {
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
