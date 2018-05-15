package cn.jctl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @date 2018-05-02 13:39:02
 */
@TableName("fm_relay")
public class FmRelayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 中继编号
	 */
	@TableId
	private Long id;
	/**
	 * 中继编号长度
	 */
	private String relayMaclen;
	/**
	 * 中继编号
	 */
	private String relayMac;
	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 设置：中继编号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：中继编号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：中继编号长度
	 */
	public void setRelayMaclen(String relayMaclen) {
		this.relayMaclen = relayMaclen;
	}
	/**
	 * 获取：中继编号长度
	 */
	public String getRelayMaclen() {
		return relayMaclen;
	}
	/**
	 * 设置：中继编号
	 */
	public void setRelayMac(String relayMac) {
		this.relayMac = relayMac;
	}
	/**
	 * 获取：中继编号
	 */
	public String getRelayMac() {
		return relayMac;
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
		return "FmRelayEntity{" +
				"id=" + id +
				", relayMaclen='" + relayMaclen + '\'' +
				", relayMac='" + relayMac + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
