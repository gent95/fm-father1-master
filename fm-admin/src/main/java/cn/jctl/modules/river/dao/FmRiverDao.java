package cn.jctl.modules.river.dao;

import cn.jctl.modules.node.entity.FmNodeEntity;
import cn.jctl.modules.river.entity.FmRiverEntity;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface FmRiverDao {
    List<FmRiverEntity> getRiverList();
    List<FmNodeEntity> getNodeListById(Integer riverId);
    void addRiver(FmRiverEntity fmRiverEntity);
    void deleteRiver(Integer riverId);
}
