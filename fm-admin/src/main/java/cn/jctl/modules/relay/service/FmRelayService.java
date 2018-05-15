package cn.jctl.modules.relay.service;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.modules.relay.entity.FmRelayEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-05-02 13:39:02
 */
public interface FmRelayService extends IService<FmRelayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

