package cn.jctl.modules.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.Query;

import cn.jctl.modules.test.dao.FmTestDao;
import cn.jctl.modules.test.entity.FmTestEntity;
import cn.jctl.modules.test.service.FmTestService;


@Service("fmTestService")
public class FmTestServiceImpl extends ServiceImpl<FmTestDao, FmTestEntity> implements FmTestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FmTestEntity> page = this.selectPage(
                new Query<FmTestEntity>(params).getPage(),
                new EntityWrapper<FmTestEntity>()
        );

        return new PageUtils(page);
    }

}
