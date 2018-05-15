package cn.jctl.modules.sys.dao;

import cn.jctl.modules.sys.entity.UserEntity;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface UserDao {
    public void update(UserEntity user);
    public UserEntity info(Long userId);
}
