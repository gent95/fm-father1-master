package cn.jctl.modules.param.service.impl;

import cn.jctl.modules.param.dao.FmParamDao;
import cn.jctl.modules.param.entity.FmParamEntity;
import cn.jctl.modules.param.service.FmParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class FmParamServiceImpl implements FmParamService {
    @Autowired
    private FmParamDao fmParamDao;
    @Override
    public List<FmParamEntity> getParamById(Integer riverId, Integer nodeId) {
        System.out.println(riverId);
        return fmParamDao.getParamById(riverId,nodeId);
    }
}
