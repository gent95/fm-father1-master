package cn.jctl.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jctl.modules.test.entity.FmTestEntity;
import cn.jctl.modules.test.service.FmTestService;
import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-23 15:26:14
 */
@RestController
@RequestMapping("test/fmtest")
public class FmTestController {
    @Autowired
    private FmTestService fmTestService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("test:fmtest:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmTestService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("test:fmtest:info")
    public R info(@PathVariable("id") Long id){
			FmTestEntity fmTest = fmTestService.selectById(id);

        return R.ok().put("fmTest", fmTest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("test:fmtest:save")
    public R save(@RequestBody FmTestEntity fmTest){
			fmTestService.insert(fmTest);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("test:fmtest:update")
    public R update(@RequestBody FmTestEntity fmTest){
			fmTestService.updateById(fmTest);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("test:fmtest:delete")
    public R delete(@RequestBody Long[] ids){
			fmTestService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
