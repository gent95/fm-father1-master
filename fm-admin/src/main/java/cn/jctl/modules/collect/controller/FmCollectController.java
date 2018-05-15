package cn.jctl.modules.collect.controller;

import java.util.Arrays;
import java.util.Map;

import cn.jctl.modules.collect.entity.FmCollectEntity;
import cn.jctl.modules.collect.service.FmCollectService;
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
@RequestMapping("modules/fmcollect")
public class FmCollectController {
    @Autowired
    private FmCollectService fmCollectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("modules:fmcollect:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmCollectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("modules:fmcollect:info")
    public R info(@PathVariable("id") Long id){
			FmCollectEntity fmCollect = fmCollectService.selectById(id);

        return R.ok().put("fmCollect", fmCollect);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("modules:fmcollect:save")
    public R save(@RequestBody FmCollectEntity fmCollect){
			fmCollectService.insert(fmCollect);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("modules:fmcollect:update")
    public R update(@RequestBody FmCollectEntity fmCollect){
			fmCollectService.updateById(fmCollect);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("modules:fmcollect:delete")
    public R delete(@RequestBody Long[] ids){
			fmCollectService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
