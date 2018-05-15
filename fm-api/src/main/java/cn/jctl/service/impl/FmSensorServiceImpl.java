package cn.jctl.service.impl;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.Query;
import cn.jctl.dao.FmSensorDao;
import cn.jctl.entity.FmSensorEntity;
import cn.jctl.service.FmSensorService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("fmSensorService")
public class FmSensorServiceImpl extends ServiceImpl<FmSensorDao, FmSensorEntity> implements FmSensorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FmSensorEntity> page = this.selectPage(
                new Query<FmSensorEntity>(params).getPage(),
                new EntityWrapper<FmSensorEntity>()
        );

        return new PageUtils(page);
    }

}
