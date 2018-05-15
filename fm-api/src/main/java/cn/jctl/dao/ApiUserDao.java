package cn.jctl.dao;

import cn.jctl.entity.ApiUserEntity;


/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface ApiUserDao {
    public void update(ApiUserEntity user);
    public ApiUserEntity info(Long userId);
}
