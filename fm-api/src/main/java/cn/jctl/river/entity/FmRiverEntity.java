package cn.jctl.river.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-04-24 14:30:05
 */
@TableName("fm_river")
public class FmRiverEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 河流id
	 */
	@TableId
	private Long riverId;
	/**
	 * 河流名称
	 */
	private String riverName;
	/**
	 * 河流面积
	 */
	private String riverArea;
	/**
	 * 河流图片URL
	 */
	private String riverUrl;
	/**
     * 河流管理者
     */
    private String riverManager;
    /**
     * 河流地址
     */
    private String riverAddress;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 创建时间
	 */
	private Date createTime;

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
	 * 设置：河流名称
	 */
	public void setRiverName(String riverName) {
		this.riverName = riverName;
	}
	/**
	 * 获取：河流名称
	 */
	public String getRiverName() {
		return riverName;
	}
	/**
	 * 设置：河流面积
	 */
	public void setRiverArea(String riverArea) {
		this.riverArea = riverArea;
	}
	/**
	 * 获取：河流面积
	 */
	public String getRiverArea() {
		return riverArea;
	}
    /**
     * 设置：河流图片URL
     */
    public void setRiverUrl(String riverUrl) {
        this.riverUrl = riverUrl;
    }
    /**
     * 获取：河流图片URL
     */
    public String getRiverUrl() {
        return riverUrl;
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

    public String getRiverManager() {
        return riverManager;
    }

    public void setRiverManager(String riverManager) {
        this.riverManager = riverManager;
    }

    public String getRiverAddress() {
        return riverAddress;
    }

    public void setRiverAddress(String riverAddress) {
        this.riverAddress = riverAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
