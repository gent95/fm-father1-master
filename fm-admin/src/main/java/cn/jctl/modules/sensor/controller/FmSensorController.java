package cn.jctl.modules.sensor.controller;

import java.util.Arrays;
import java.util.Map;

import cn.jctl.modules.sensor.entity.FmSensorEntity;
import cn.jctl.modules.sensor.service.FmSensorService;
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
@RequestMapping("modules/fmsensor")
public class FmSensorController {
    @Autowired
    private FmSensorService fmSensorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("modules:fmsensor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fmSensorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("modules:fmsensor:info")
    public R info(@PathVariable("id") Long id){
			FmSensorEntity fmSensor = fmSensorService.selectById(id);

        return R.ok().put("fmSensor", fmSensor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("modules:fmsensor:save")
    public R save(@RequestBody FmSensorEntity fmSensor){
			fmSensorService.insert(fmSensor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("modules:fmsensor:update")
    public R update(@RequestBody FmSensorEntity fmSensor){
			fmSensorService.updateById(fmSensor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("modules:fmsensor:delete")
    public R delete(@RequestBody Long[] ids){
			fmSensorService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
