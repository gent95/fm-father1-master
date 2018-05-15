package cn.jctl.modules.collectparam.controller;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;
import cn.jctl.modules.collectparam.entity.FmCollectParamEntity;
import cn.jctl.modules.collectparam.service.FmCollectParamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author pyc
 * @email pangpang1012@foxmail.com
 * @date 2018-05-02 13:39:02
 */
@RestController
@RequestMapping("modules/fmcollectparam")
public class FmCollectParamController {
    @Autowired
    private FmCollectParamService fmCollectParamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("modules:fmcollectparam:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmCollectParamService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("modules:fmcollectparam:info")
    public R info(@PathVariable("id") Long id){
			FmCollectParamEntity fmCollectParam = fmCollectParamService.selectById(id);

        return R.ok().put("fmCollectParam", fmCollectParam);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("modules:fmcollectparam:save")
    public R save(@RequestBody FmCollectParamEntity fmCollectParam){
			fmCollectParamService.insert(fmCollectParam);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("modules:fmcollectparam:update")
    public R update(@RequestBody FmCollectParamEntity fmCollectParam){
			fmCollectParamService.updateById(fmCollectParam);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("modules:fmcollectparam:delete")
    public R delete(@RequestBody Long[] ids){
			fmCollectParamService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
