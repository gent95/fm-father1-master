package cn.jctl.dao;

import cn.jctl.river.entity.FmNodeEntity;
import cn.jctl.river.entity.FmRiverEntity;
import cn.jctl.river.entity.FmRiverNodeEntity;
import cn.jctl.river.entity.FmWaterareaEntity;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface FmRiverDao {
    public List<FmRiverEntity> getRiverList();
    public List<FmNodeEntity> getNodeListById(Integer riverId);
    public void addRiver(FmRiverNodeEntity fmRiverNodeEntity);
    public void deleteRiver(Long riverId);
    public List<FmWaterareaEntity> getWaterareaInfo();
    public Long getRiverId();
    public void addNode(FmNodeEntity fmNodeEntity);
    public void updateRiver(FmRiverNodeEntity fmRiverNodeEntity);
    public void updateNode(FmNodeEntity fmNodeEntity);
    public void deleteNode(Long nodeId);
    public FmWaterareaEntity getRiverOne(Long riverId);
}
