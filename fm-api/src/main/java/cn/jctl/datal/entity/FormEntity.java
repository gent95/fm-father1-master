package cn.jctl.datal.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public class FormEntity {
    private Long riverId;
    private Long paramId;
    private Integer type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Date endTime;
    private String createTimel;
    private String endTimel;

    public Long getRiverId() {
        return riverId;
    }

    public void setRiverId(Long riverId) {
        this.riverId = riverId;
    }

    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreateTimel() {
        return createTimel;
    }

    public void setCreateTimel(String createTimel) {
        this.createTimel = createTimel;
    }

    public String getEndTimel() {
        return endTimel;
    }

    public void setEndTimel(String endTimel) {
        this.endTimel = endTimel;
    }

    @Override
    public String toString() {
        return "FormEntity{" +
                "riverId=" + riverId +
                ", paramId=" + paramId +
                ", type=" + type +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                '}';
    }
}
