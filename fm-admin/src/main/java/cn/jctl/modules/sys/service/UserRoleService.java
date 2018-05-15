package cn.jctl.modules.sys.service;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface UserRoleService {
    public List<Long> querryRoleId(Long userId);
}
