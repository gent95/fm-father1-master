package cn.jctl.controller;

import cn.jctl.common.utils.R;
import cn.jctl.common.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by majiangtao on 2018/4/26.
 */
@RestController
@RequestMapping("/api")
@Api(tags="检测数据接口")
public class ApiWaterController {
    @Autowired
    private RedisUtils redisUtils;


    @GetMapping("get")
    @ApiOperation("获取最新检测数据")
    public Object get(String nodeMac){
        if (StringUtils.isEmpty(nodeMac)){
            return R.error().put("code","500").put("msg","节点编号不能为空!");
        }
        return R.ok(redisUtils.get(nodeMac));
    }
}
