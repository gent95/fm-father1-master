package cn.jctl.datal.entity;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public class ParamEntity {
    private Long id;
    private String paramName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
