package cn.jctl.modules.sys.controller;


import cn.jctl.common.utils.R;
import cn.jctl.common.validator.ValidatorUtils;
import cn.jctl.modules.form.RegisterForm;
import cn.jctl.modules.sys.entity.SysUserEntity;
import cn.jctl.modules.sys.service.SysUserService;
import cn.jctl.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 注册接口
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-04-16 17:27
 */
@Controller
public class SysRegisterController {
    @Autowired
    private SysUserService userService;


    @ResponseBody()
    @RequestMapping(value = "/sys/reg")
    public R register(RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //查询用户信息
        SysUserEntity user = new SysUserEntity();
        user.setUsername(form.getUsername());
        SysUserEntity userNew = userService.queryUser(user);

        user.setNames(form.getNames());

        //账号不存在
        if (userNew != null){
            return R.error(1000,"账号已存在");
        }
        user.setUsername(null);

        user.setMobile(form.getMobile());
        userNew = userService.queryUser(user);
        if (userNew != null){
            return  R.error(1001,"电话已存在");
        }
        user.setMobile(form.getMobile());
        user.setUsername(form.getUsername());

        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        //DigestUtils.sha256Hex(form.getPassword())
        //ShiroUtils.sha256(user.getPassword(), user.getSalt())
        user.setPassword(ShiroUtils.sha256(form.getPassword(), user.getSalt()));
        user.setCreateTime(new Date());
        user.setEmail(form.getEmail());
        userService.insert(user);

        return R.ok();
    }
}
