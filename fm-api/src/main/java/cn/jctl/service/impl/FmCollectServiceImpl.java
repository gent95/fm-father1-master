package cn.jctl.service.impl;

import cn.jctl.common.utils.PageUtils;

import cn.jctl.common.utils.Query;
import cn.jctl.dao.FmCollectDao;
import cn.jctl.entity.FmCollectEntity;
import cn.jctl.service.FmCollectService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("fmCollectService")
public class FmCollectServiceImpl extends ServiceImpl<FmCollectDao, FmCollectEntity> implements FmCollectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FmCollectEntity> page = this.selectPage(
                new Query<FmCollectEntity>(params).getPage(),
                new EntityWrapper<FmCollectEntity>()
        );

        return new PageUtils(page);
    }

}
