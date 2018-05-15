package cn.jctl.modules.relay.controller;

import java.util.Arrays;
import java.util.Map;

import cn.jctl.modules.relay.entity.FmRelayEntity;
import cn.jctl.modules.relay.service.FmRelayService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;



/**
 * 
 *
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-05-02 13:39:02
 */
@RestController
@RequestMapping("modules/fmrelay")
public class FmRelayController {
    @Autowired
    private FmRelayService fmRelayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("modules:fmrelay:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmRelayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("modules:fmrelay:info")
    public R info(@PathVariable("id") Long id){
			FmRelayEntity fmRelay = fmRelayService.selectById(id);

        return R.ok().put("fmRelay", fmRelay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("modules:fmrelay:save")
    public R save(@RequestBody FmRelayEntity fmRelay){
			fmRelayService.insert(fmRelay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("modules:fmrelay:update")
    public R update(@RequestBody FmRelayEntity fmRelay){
			fmRelayService.updateById(fmRelay);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("modules:fmrelay:delete")
    public R delete(@RequestBody Long[] ids){
			fmRelayService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
