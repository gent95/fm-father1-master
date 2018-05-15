package cn.jctl.controller;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;
import cn.jctl.entity.FmNodeEntity;
import cn.jctl.service.FmNodeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @date 2018-05-02 13:39:02
 */
@RestController
@RequestMapping("api/fmnode")
@Api("节点接口")
public class FmNodeController {
    @Autowired
    private FmNodeService fmNodeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmNodeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			FmNodeEntity fmNode = fmNodeService.selectById(id);

        return R.ok().put("fmNode", fmNode);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FmNodeEntity fmNode){
			fmNodeService.insert(fmNode);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FmNodeEntity fmNode){
			fmNodeService.updateById(fmNode);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			fmNodeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
