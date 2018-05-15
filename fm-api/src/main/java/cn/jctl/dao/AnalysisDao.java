package cn.jctl.dao;

import cn.jctl.datal.entity.DataEntity;
import cn.jctl.datal.entity.FormEntity;
import cn.jctl.datal.entity.ParamEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface AnalysisDao {
    public List<DataEntity> getParam(FormEntity form);
    public List<ParamEntity> getParamList(@Param("riverId") Long riverId, @Param("type") Integer type);
}
