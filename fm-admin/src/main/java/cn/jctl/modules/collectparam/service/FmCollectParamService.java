package cn.jctl.modules.collectparam.service;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.modules.collectparam.entity.FmCollectParamEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-05-02 13:39:02
 */
public interface FmCollectParamService extends IService<FmCollectParamEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

