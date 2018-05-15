package cn.jctl.modules.sys.service.impl;

import cn.jctl.modules.sys.dao.UserRoleDao;
import cn.jctl.modules.sys.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Override
    public List<Long> querryRoleId(Long userId) {
        return userRoleDao.querryRoleId(userId);
    }
}
