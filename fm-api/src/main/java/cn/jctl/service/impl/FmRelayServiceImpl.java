package cn.jctl.service.impl;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.Query;
import cn.jctl.dao.FmRelayDao;
import cn.jctl.entity.FmRelayEntity;
import cn.jctl.service.FmRelayService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("fmRelayService")
public class FmRelayServiceImpl extends ServiceImpl<FmRelayDao, FmRelayEntity> implements FmRelayService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FmRelayEntity> page = this.selectPage(
                new Query<FmRelayEntity>(params).getPage(),
                new EntityWrapper<FmRelayEntity>()
        );

        return new PageUtils(page);
    }

}
