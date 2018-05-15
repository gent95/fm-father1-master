package cn.jctl.controller;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;
import cn.jctl.entity.FmParamEntity;
import cn.jctl.service.FmParamService;
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
 * @date 2018-05-02 16:16:46
 */
@RestController
@RequestMapping("api/fmparam")
@Api("采集参数接口")
public class FmParamController {
    @Autowired
    private FmParamService fmParamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmParamService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			FmParamEntity fmParam = fmParamService.selectById(id);

        return R.ok().put("fmParam", fmParam);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FmParamEntity fmParam){
			fmParamService.insert(fmParam);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FmParamEntity fmParam){
			fmParamService.updateById(fmParam);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			fmParamService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
