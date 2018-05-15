package cn.jctl.service;

import cn.jctl.entity.ApiUserEntity;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface ApiUserService {
    public void update(ApiUserEntity user);
    public ApiUserEntity info(Long userId);
}
