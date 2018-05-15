package cn.jctl.datal.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public class NewFormEntity {
    private Long riverId;
    private Long paramId;
    private Integer type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

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
}
