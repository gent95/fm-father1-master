package cn.jctl.controller;

import cn.jctl.annotation.SysLog;
import cn.jctl.common.utils.R;
import cn.jctl.common.utils.RedisUtils;
import cn.jctl.common.validator.ValidatorUtils;
import cn.jctl.common.validator.group.UpdateGroup;
import cn.jctl.entity.ApiUserEntity;
import cn.jctl.entity.SysUserEntity;
import cn.jctl.service.ApiRoleService;
import cn.jctl.service.ApiUserRoleService;
import cn.jctl.service.ApiUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@RestController
@RequestMapping("/sys/user")
@Api(tags="个人信息接口")
public class ApiUserController {
    @Autowired
    private ApiUserService userService;
    @Autowired
    private ApiUserRoleService userRoleService;
    @Autowired
    private ApiRoleService roleService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 修改用户
     * @param user
     * @return
     */
    @SysLog("修改用户")
    /*@RequestMapping("/update")*/
    @RequiresPermissions("sys:user:update")
    @PostMapping("update")
    @ApiOperation("修改用户")
    public R update(ApiUserEntity user){
        ValidatorUtils.validateEntity(user, UpdateGroup.class);
        userService.update(user);
        return R.ok();
    }

    /**
     * 获取登录的用户信息
     */
    @GetMapping("info")
    @ApiOperation("获取登录的用户信息")
    public R info(){
        SysUserEntity entity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        Long userid=entity.getUserId();
        ApiUserEntity user = userService.info(userid);
        redisUtils.set("user1",user);
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
    @GetMapping("info/{userId}")
    @ApiOperation("获取用户信息")
    public R info(@PathVariable("userId") Long userId){
        ApiUserEntity user = userService.info(userId);
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
