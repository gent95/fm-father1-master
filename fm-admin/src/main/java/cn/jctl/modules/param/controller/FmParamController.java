package cn.jctl.modules.param.controller;


import cn.jctl.modules.param.entity.FmParamEntity;
import cn.jctl.modules.param.service.FmParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@RestController
@RequestMapping("/param")
public class FmParamController {
    @Autowired
    private FmParamService fmParamService;

    @RequestMapping("/list")
    public List<FmParamEntity> getParamById(Integer riverId, Integer nodeId){
        return fmParamService.getParamById(riverId,nodeId);
    }
}
