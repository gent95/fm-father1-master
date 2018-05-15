package cn.jctl.service;

import com.baomidou.mybatisplus.service.IService;
import cn.jctl.common.utils.PageUtils;
import cn.jctl.entity.FmParamEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @date 2018-05-02 16:16:46
 */
public interface FmParamService extends IService<FmParamEntity>{

    PageUtils queryPage(Map<String, Object> params);
    List<FmParamEntity> selectAll();
}

