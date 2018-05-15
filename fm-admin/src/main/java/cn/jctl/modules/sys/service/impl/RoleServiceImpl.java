package cn.jctl.modules.sys.service.impl;

import cn.jctl.modules.sys.dao.RoleDao;
import cn.jctl.modules.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public String querryRole(Long roleid) {
        return roleDao.querryRole(roleid);
    }
}
