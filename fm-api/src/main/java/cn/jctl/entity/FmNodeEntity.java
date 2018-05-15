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
 * @date 2018-05-02 13:39:02
 */
@TableName("fm_node")
public class FmNodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 节点id
	 */
	@TableId
	private Long id;
	/**
	 * 节点名称
	 */
	private String nodeName;
	/**
	 * 经度
	 */
	private String nodeLon;
	/**
	 * 纬度
	 */
	private String nodeLat;
	/**
	 * 河流id
	 */
	private Long riverId;
	/**
	 * 
	 */
	private Long relayId;
	/**
	 * 节点编号
	 */
	private String nodemac;
	/**
	 * 节点编号长度
	 */
	private String nodemaclen;
	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 设置：节点id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：节点id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：节点名称
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/**
	 * 获取：节点名称
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * 设置：经度
	 */
	public void setNodeLon(String nodeLon) {
		this.nodeLon = nodeLon;
	}
	/**
	 * 获取：经度
	 */
	public String getNodeLon() {
		return nodeLon;
	}
	/**
	 * 设置：纬度
	 */
	public void setNodeLat(String nodeLat) {
		this.nodeLat = nodeLat;
	}
	/**
	 * 获取：纬度
	 */
	public String getNodeLat() {
		return nodeLat;
	}
	/**
	 * 设置：河流id
	 */
	public void setRiverId(Long riverId) {
		this.riverId = riverId;
	}
	/**
	 * 获取：河流id
	 */
	public Long getRiverId() {
		return riverId;
	}
	/**
	 * 设置：
	 */
	public void setRelayId(Long relayId) {
		this.relayId = relayId;
	}
	/**
	 * 获取：
	 */
	public Long getRelayId() {
		return relayId;
	}
	/**
	 * 设置：节点编号
	 */
	public void setNodemac(String nodemac) {
		this.nodemac = nodemac;
	}
	/**
	 * 获取：节点编号
	 */
	public String getNodemac() {
		return nodemac;
	}
	/**
	 * 设置：节点编号长度
	 */
	public void setNodemaclen(String nodemaclen) {
		this.nodemaclen = nodemaclen;
	}
	/**
	 * 获取：节点编号长度
	 */
	public String getNodemaclen() {
		return nodemaclen;
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
		return "FmNodeEntity{" +
				"id=" + id +
				", nodeName='" + nodeName + '\'' +
				", nodeLon='" + nodeLon + '\'' +
				", nodeLat='" + nodeLat + '\'' +
				", riverId=" + riverId +
				", relayId=" + relayId +
				", nodemac='" + nodemac + '\'' +
				", nodemaclen='" + nodemaclen + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
