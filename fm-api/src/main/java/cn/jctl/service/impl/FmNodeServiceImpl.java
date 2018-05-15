package cn.jctl.service.impl;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.Query;
import cn.jctl.dao.FmNodeDao;
import cn.jctl.entity.FmNodeEntity;
import cn.jctl.service.FmNodeService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("fmNodeService")
public class FmNodeServiceImpl extends ServiceImpl<FmNodeDao, FmNodeEntity> implements FmNodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FmNodeEntity> page = this.selectPage(
                new Query<FmNodeEntity>(params).getPage(),
                new EntityWrapper<FmNodeEntity>()
        );

        return new PageUtils(page);
    }

}
