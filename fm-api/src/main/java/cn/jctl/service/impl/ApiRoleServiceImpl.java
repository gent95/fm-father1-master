package cn.jctl.service.impl;

import cn.jctl.dao.ApiRoleDao;
import cn.jctl.service.ApiRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class ApiRoleServiceImpl implements ApiRoleService {
    @Autowired
    private ApiRoleDao roleDao;

    @Override
    public String querryRole(Long roleid) {
        return roleDao.querryRole(roleid);
    }
}
