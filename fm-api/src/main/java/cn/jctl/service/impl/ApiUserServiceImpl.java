package cn.jctl.service.impl;

import cn.jctl.dao.ApiUserDao;
import cn.jctl.entity.ApiUserEntity;
import cn.jctl.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static cn.jctl.config.ShiroUtils.getUserId;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class ApiUserServiceImpl implements ApiUserService {
    @Autowired
    private ApiUserDao userDao;
    @Override
    public void update(ApiUserEntity user) {
        user.setUserId(getUserId());
        userDao.update(user);
    }

    @Override
    public ApiUserEntity info(Long userId) {
        return userDao.info(userId);
    }

}
