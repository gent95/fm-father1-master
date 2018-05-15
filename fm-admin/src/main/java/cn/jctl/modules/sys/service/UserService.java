package cn.jctl.modules.sys.service;

import cn.jctl.modules.sys.entity.UserEntity;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface UserService {
    public void update(UserEntity user);
    public UserEntity info(Long userId);
}
