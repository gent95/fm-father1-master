package cn.jctl.river.service.impl;

import cn.jctl.dao.FmRiverDao;
import cn.jctl.river.entity.FmNodeEntity;
import cn.jctl.river.entity.FmRiverEntity;
import cn.jctl.river.entity.FmRiverNodeEntity;
import cn.jctl.river.entity.FmWaterareaEntity;
import cn.jctl.river.service.FmRiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public void addRiver(FmRiverNodeEntity fmRiverNodeEntity) {
        fmRiverNodeEntity.setCreateTime(new Date());
        fmRiverDao.addRiver(fmRiverNodeEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRiver(Long riverId) {
        fmRiverDao.deleteRiver(riverId);
    }

    @Override
    public List<FmWaterareaEntity> getWaterareaInfo() {
        return fmRiverDao.getWaterareaInfo();
    }

    @Override
    public Long getRiverId() {
        return fmRiverDao.getRiverId();
    }

    @Override
    public void addNode(FmNodeEntity fmNodeEntity) {
        fmNodeEntity.setCreateTime(new Date());
        fmRiverDao.addNode(fmNodeEntity);
    }

    @Override
    public void updateRiver(FmRiverNodeEntity fmRiverNodeEntity) {
        fmRiverDao.updateRiver(fmRiverNodeEntity);
    }

    @Override
    public void updateNode(FmNodeEntity fmNodeEntity) {
        fmRiverDao.updateNode(fmNodeEntity);
    }

    @Override
    public void deleteNode(Long nodeId) {
        fmRiverDao.deleteNode(nodeId);
    }

    @Override
    public FmWaterareaEntity getRiverOne(Long riverId) {
        return fmRiverDao.getRiverOne(riverId);
    }
}
