package cn.jctl.service;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.entity.FmCollectEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @date 2018-05-02 13:39:02
 */
public interface FmCollectService extends IService<FmCollectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

