package cn.jctl.datal.controller;

import cn.jctl.datal.entity.DataEntity;
import cn.jctl.datal.entity.FormEntity;
import cn.jctl.datal.entity.NewFormEntity;
import cn.jctl.datal.entity.ParamEntity;
import cn.jctl.datal.service.AnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@RestController
@RequestMapping("/data")
@Api(tags="参数接口")
public class AnalysisL {
    @Autowired
    private AnalysisService analysisService;

    @PostMapping("param")
    @ApiOperation("参数")
    public List<DataEntity> getParam(@RequestBody NewFormEntity newform) throws ParseException {
        FormEntity entity = new FormEntity();
        entity.setRiverId(newform.getRiverId());
        entity.setParamId(newform.getParamId());
        entity.setType(newform.getType());
        entity.setCreateTime(newform.getCreateTime());
        System.out.println(analysisService.getParam(entity));
        return analysisService.getParam(entity);
    }

    @PostMapping("param/list")
    @ApiOperation("参数列表")
    public List<ParamEntity> getParamList(Long riverId,Integer type){
        return analysisService.getParamList(riverId, type);
    }

    @PostMapping("param/syn")
    @ApiOperation("获取全部参数")
    public HashMap<Long, List<DataEntity>> getParamSyn(@RequestBody NewFormEntity newform) throws ParseException {
        HashMap<Long, List<DataEntity>> map = new HashMap<>();
        List<ParamEntity> paramList = analysisService.getParamList(newform.getRiverId(), newform.getType());
        for(ParamEntity param:paramList){
            newform.setParamId(param.getId());
            FormEntity entity = new FormEntity();
            entity.setRiverId(newform.getRiverId());
            entity.setParamId(newform.getParamId());
            entity.setType(newform.getType());
            entity.setCreateTime(newform.getCreateTime());
            List<DataEntity> datalist = analysisService.getParam(entity);
            map.put(param.getId(),datalist);
        }
        return map;
    }
}
