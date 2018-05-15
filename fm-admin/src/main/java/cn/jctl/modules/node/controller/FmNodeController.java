package cn.jctl.modules.node.controller;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;
import cn.jctl.modules.node.entity.FmNodeEntity;
import cn.jctl.modules.node.service.FmNodeService;
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
@RequestMapping("modules/fmnode")
public class FmNodeController {
    @Autowired
    private FmNodeService fmNodeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("modules:fmnode:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmNodeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("modules:fmnode:info")
    public R info(@PathVariable("id") Long id){
			FmNodeEntity fmNode = fmNodeService.selectById(id);

        return R.ok().put("fmNode", fmNode);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("modules:fmnode:save")
    public R save(@RequestBody FmNodeEntity fmNode){
			fmNodeService.insert(fmNode);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("modules:fmnode:update")
    public R update(@RequestBody FmNodeEntity fmNode){
			fmNodeService.updateById(fmNode);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("modules:fmnode:delete")
    public R delete(@RequestBody Long[] ids){
			fmNodeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
