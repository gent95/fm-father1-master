package cn.jctl.modules.sys.controller;

import cn.jctl.common.annotation.SysLog;
import cn.jctl.common.utils.R;
import cn.jctl.common.validator.ValidatorUtils;
import cn.jctl.common.validator.group.UpdateGroup;
import cn.jctl.modules.sys.entity.SysUserEntity;
import cn.jctl.modules.sys.entity.UserEntity;
import cn.jctl.modules.sys.service.RoleService;
import cn.jctl.modules.sys.service.UserRoleService;
import cn.jctl.modules.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    /**
     * 修改用户
     * @param user
     * @return
     */
    @SysLog("修改用户")
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public R update(UserEntity user){
        ValidatorUtils.validateEntity(user, UpdateGroup.class);

        userService.update(user);

        return R.ok();
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public R info(){
        SysUserEntity entity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        Long userid=entity.getUserId();
        UserEntity user = userService.info(userid);
        List<Long> roleidlist = userRoleService.querryRoleId(userid);
        ArrayList<String> rolelist = new ArrayList<>();
        user.setRoleIdList(roleidlist);
        for(Long roleid:roleidlist){
            rolelist.add(roleService.querryRole(roleid));
        }
        user.setRoleList(rolelist);
        return R.ok().put("user",user);
    }

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/info/{userId}")
    /*@RequiresPermissions("sys:user:info")*/
    public R info(@PathVariable("userId") Long userId){
        UserEntity user = userService.info(userId);
        List<Long> roleidlist = userRoleService.querryRoleId(userId);
        ArrayList<String> rolelist = new ArrayList<>();
        user.setRoleIdList(roleidlist);
        for(Long roleid:roleidlist){
            rolelist.add(roleService.querryRole(roleid));
        }
        user.setRoleList(rolelist);
        return R.ok().put("user", user);
    }
}
