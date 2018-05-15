package cn.jctl.datal.service;

import cn.jctl.datal.entity.DataEntity;
import cn.jctl.datal.entity.FormEntity;
import cn.jctl.datal.entity.ParamEntity;

import java.text.ParseException;
import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface AnalysisService {
    public List<DataEntity> getParam(FormEntity form) throws ParseException;
    public List<ParamEntity> getParamList(Long riverId,Integer type);
}
