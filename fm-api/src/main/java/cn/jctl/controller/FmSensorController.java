package cn.jctl.controller;

import cn.jctl.common.utils.PageUtils;
import cn.jctl.common.utils.R;
import cn.jctl.entity.FmSensorEntity;
import cn.jctl.service.FmSensorService;
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
@RequestMapping("api/fmsensor")
@Api("传感器接口")
public class FmSensorController {
    @Autowired
    private FmSensorService fmSensorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmSensorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			FmSensorEntity fmSensor = fmSensorService.selectById(id);

        return R.ok().put("fmSensor", fmSensor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FmSensorEntity fmSensor){
			fmSensorService.insert(fmSensor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FmSensorEntity fmSensor){
			fmSensorService.updateById(fmSensor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			fmSensorService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
