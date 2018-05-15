package cn.jctl.modules.param.service;

import cn.jctl.modules.param.entity.FmParamEntity;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface FmParamService {
    List<FmParamEntity> getParamById(Integer riverId, Integer nodeId);
}
