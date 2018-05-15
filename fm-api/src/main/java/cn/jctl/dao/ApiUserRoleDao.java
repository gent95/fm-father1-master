package cn.jctl.dao;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
public interface ApiUserRoleDao {
    public List<Long> querryRoleId(Long userId);
}
