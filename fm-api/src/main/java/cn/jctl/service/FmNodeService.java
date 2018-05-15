package cn.jctl.service;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.entity.FmNodeEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @date 2018-05-02 13:39:02
 */
public interface FmNodeService extends IService<FmNodeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

