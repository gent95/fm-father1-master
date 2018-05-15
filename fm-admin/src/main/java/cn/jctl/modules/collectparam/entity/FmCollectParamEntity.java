package cn.jctl.modules.collectparam.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-05-02 13:39:02
 */
@TableName("fm_collect_param")
public class FmCollectParamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long collectId;
	/**
	 * 
	 */
	private Long paramId;
	/**
	 * 
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
	public void setCollectId(Long collectId) {
		this.collectId = collectId;
	}
	/**
	 * 获取：
	 */
	public Long getCollectId() {
		return collectId;
	}
	/**
	 * 设置：
	 */
	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}
	/**
	 * 获取：
	 */
	public Long getParamId() {
		return paramId;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
