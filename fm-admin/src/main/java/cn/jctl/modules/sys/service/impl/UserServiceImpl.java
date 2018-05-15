package cn.jctl.modules.sys.service.impl;

import cn.jctl.modules.sys.dao.UserDao;
import cn.jctl.modules.sys.entity.UserEntity;
import cn.jctl.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static cn.jctl.modules.sys.shiro.ShiroUtils.getUserId;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void update(UserEntity user) {
        user.setUserId(getUserId());
        userDao.update(user);
    }

    @Override
    public UserEntity info(Long userId) {
        return userDao.info(userId);
    }

}
