package cn.jctl.modules.node.service;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.modules.node.entity.FmNodeEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-05-02 13:39:02
 */
public interface FmNodeService extends IService<FmNodeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

