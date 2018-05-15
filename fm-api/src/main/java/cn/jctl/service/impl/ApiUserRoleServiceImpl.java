package cn.jctl.service.impl;

import cn.jctl.dao.ApiUserRoleDao;
import cn.jctl.service.ApiUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class ApiUserRoleServiceImpl implements ApiUserRoleService {
    @Autowired
    private ApiUserRoleDao userRoleDao;
    @Override
    public List<Long> querryRoleId(Long userId) {
        return userRoleDao.querryRoleId(userId);
    }
}
