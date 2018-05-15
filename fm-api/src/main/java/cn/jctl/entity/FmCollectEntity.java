package cn.jctl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @String 2018-05-02 13:39:02
 */
@TableName("fm_collect")
public class FmCollectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 参数id
	 */
	@TableId
	private Long id;
	/**
	 * 采集点id
	 */
	private Integer collectId;
	/**
	 * 
	 */
	private String data;
	/**
	 * 
	 */
	private Long sensorId;
	/**
	 * 参数id
	 */
	private Long paramId;
	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 设置：参数id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：参数id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：采集点id
	 */
	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}
	/**
	 * 获取：采集点id
	 */
	public Integer getCollectId() {
		return collectId;
	}
	/**
	 * 设置：
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**
	 * 获取：
	 */
	public String getData() {
		return data;
	}
	/**
	 * 设置：
	 */
	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}
	/**
	 * 获取：
	 */
	public Long getSensorId() {
		return sensorId;
	}
	/**
	 * 设置：参数id
	 */
	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}
	/**
	 * 获取：参数id
	 */
	public Long getParamId() {
		return paramId;
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
		return "FmCollectEntity{" +
				"id=" + id +
				", collectId=" + collectId +
				", data='" + data + '\'' +
				", sensorId=" + sensorId +
				", paramId=" + paramId +
				", createTime=" + createTime +
				'}';
	}
}
