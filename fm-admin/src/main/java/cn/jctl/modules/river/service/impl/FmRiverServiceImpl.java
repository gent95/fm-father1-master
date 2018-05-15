package cn.jctl.modules.river.service.impl;

import cn.jctl.modules.river.dao.FmRiverDao;
import cn.jctl.modules.node.entity.FmNodeEntity;
import cn.jctl.modules.river.entity.FmRiverEntity;
import cn.jctl.modules.river.service.FmRiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class FmRiverServiceImpl implements FmRiverService {
    @Autowired
    private FmRiverDao fmRiverDao;

    @Override
    public List<FmRiverEntity> getRiverList() {
        return fmRiverDao.getRiverList();
    }

    @Override
    public List<FmNodeEntity> getNodeListById(Integer riverId) {
        return fmRiverDao.getNodeListById(riverId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRiver(FmRiverEntity fmRiverEntity) {
        fmRiverDao.addRiver(fmRiverEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRiver(Integer riverId) {
        fmRiverDao.deleteRiver(riverId);
    }
}
