package cn.jctl.modules.river.service;

import cn.jctl.modules.node.entity.FmNodeEntity;
import cn.jctl.modules.river.entity.FmRiverEntity;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface FmRiverService {
    public List<FmRiverEntity> getRiverList();
    public List<FmNodeEntity> getNodeListById(Integer riverId);
    public void addRiver(FmRiverEntity fmRiverEntity);
    public void deleteRiver(Integer riverId);
}
