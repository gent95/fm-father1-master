package cn.jctl.modules.sys.dao;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface UserRoleDao {
    public List<Long> querryRoleId(Long userId);
}
