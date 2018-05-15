package cn.jctl.modules.collect.service;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.modules.collect.entity.FmCollectEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-05-02 13:39:02
 */
public interface FmCollectService extends IService<FmCollectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

