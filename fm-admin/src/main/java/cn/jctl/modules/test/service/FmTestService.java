package cn.jctl.modules.test.service;

import com.baomidou.mybatisplus.service.IService;
import cn.jctl.common.utils.PageUtils;
import cn.jctl.modules.test.entity.FmTestEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-23 15:26:14
 */
public interface FmTestService extends IService<FmTestEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

