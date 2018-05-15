package cn.jctl.controller;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;
import cn.jctl.entity.FmCollectEntity;
import cn.jctl.service.FmCollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @date 2018-05-02 13:39:02
 */
@RestController
@RequestMapping("api/fmcollect")
@Api(tags = "采集点接口")
public class FmCollectController {
    @Autowired
    private FmCollectService fmCollectService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表查询")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmCollectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			FmCollectEntity fmCollect = fmCollectService.selectById(id);

        return R.ok().put("fmCollect", fmCollect);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody FmCollectEntity fmCollect){
			fmCollectService.insert(fmCollect);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody FmCollectEntity fmCollect){
			fmCollectService.updateById(fmCollect);

        return R.ok();
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			fmCollectService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
