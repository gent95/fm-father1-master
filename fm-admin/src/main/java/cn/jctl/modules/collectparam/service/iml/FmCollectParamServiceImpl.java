package cn.jctl.modules.collectparam.service.iml;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.Query;
import cn.jctl.modules.collectparam.dao.FmCollectParamDao;
import cn.jctl.modules.collectparam.entity.FmCollectParamEntity;
import cn.jctl.modules.collectparam.service.FmCollectParamService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("fmCollectParamService")
public class FmCollectParamServiceImpl extends ServiceImpl<FmCollectParamDao, FmCollectParamEntity> implements FmCollectParamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FmCollectParamEntity> page = this.selectPage(
                new Query<FmCollectParamEntity>(params).getPage(),
                new EntityWrapper<FmCollectParamEntity>()
        );

        return new PageUtils(page);
    }

}
