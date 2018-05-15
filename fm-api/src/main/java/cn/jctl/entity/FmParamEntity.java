package cn.jctl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @date 2018-05-02 16:16:46
 */
@TableName("fm_param")
public class FmParamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String paramName;
	/**
	 * 参数单位
	 */
	private String unit;
	/**
	 * 创建时间
	 */
	private Date createTime;

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
	 * 设置：
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	/**
	 * 获取：
	 */
	public String getParamName() {
		return paramName;
	}
	/**
	 * 设置：参数单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：参数单位
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "FmParamEntity{" +
				"id=" + id +
				", paramName='" + paramName + '\'' +
				", unit='" + unit + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
