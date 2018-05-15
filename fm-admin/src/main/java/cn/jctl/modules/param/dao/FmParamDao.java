package cn.jctl.modules.param.dao;


import cn.jctl.modules.param.entity.FmParamEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface FmParamDao {
    public List<FmParamEntity> getParamById(@Param("riverId") Integer riverId, @Param("nodeId") Integer nodeId);
}
