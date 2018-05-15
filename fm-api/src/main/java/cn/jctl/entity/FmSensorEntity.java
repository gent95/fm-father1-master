package cn.jctl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @String 2018-05-02 13:39:02
 */
@TableName("fm_sensor")
public class FmSensorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 传感器编号
	 */
	private String sensorMac;
	/**
	 * 传感器类型（1.物理参数2.化学参数3.水文参数4.气象参数）
	 */
	private Integer type;
	/**
	 * 节点id
	 */
	private Long nodeId;
	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：传感器编号
	 */
	public void setSensorMac(String sensorMac) {
		this.sensorMac = sensorMac;
	}
	/**
	 * 获取：传感器编号
	 */
	public String getSensorMac() {
		return sensorMac;
	}
	/**
	 * 设置：传感器类型（1.物理参数2.化学参数3.水文参数4.气象参数）
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：传感器类型（1.物理参数2.化学参数3.水文参数4.气象参数）
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：节点id
	 */
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
	/**
	 * 获取：节点id
	 */
	public Long getNodeId() {
		return nodeId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "FmSensorEntity{" +
				"id=" + id +
				", sensorMac='" + sensorMac + '\'' +
				", type=" + type +
				", nodeId=" + nodeId +
				", createTime='" + createTime + '\'' +
				'}';
	}
}
