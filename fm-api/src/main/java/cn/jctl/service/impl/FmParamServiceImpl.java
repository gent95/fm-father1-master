package cn.jctl.service.impl;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.Query;
import cn.jctl.dao.FmParamDao;
import cn.jctl.entity.FmParamEntity;
import cn.jctl.service.FmParamService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("fmParamService")
public class FmParamServiceImpl extends ServiceImpl<FmParamDao, FmParamEntity> implements FmParamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FmParamEntity> page = this.selectPage(
                new Query<FmParamEntity>(params).getPage(),
                new EntityWrapper<FmParamEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<FmParamEntity> selectAll() {
        return baseMapper.selectAll();
    }

}
