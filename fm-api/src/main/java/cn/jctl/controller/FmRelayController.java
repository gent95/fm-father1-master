package cn.jctl.controller;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;
import cn.jctl.entity.FmRelayEntity;
import cn.jctl.service.FmRelayService;
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
@RequestMapping("api/fmrelay")
@Api("中继接口")
public class FmRelayController {
    @Autowired
    private FmRelayService fmRelayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmRelayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			FmRelayEntity fmRelay = fmRelayService.selectById(id);

        return R.ok().put("fmRelay", fmRelay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FmRelayEntity fmRelay){
			fmRelayService.insert(fmRelay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FmRelayEntity fmRelay){
			fmRelayService.updateById(fmRelay);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			fmRelayService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
