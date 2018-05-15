package cn.jctl.datal.service.impl;

import cn.jctl.dao.AnalysisDao;
import cn.jctl.datal.entity.DataEntity;
import cn.jctl.datal.entity.FormEntity;
import cn.jctl.datal.entity.ParamEntity;
import cn.jctl.datal.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private AnalysisDao analysisDao;
    @Override
    public List<DataEntity> getParam(FormEntity form) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(form.getCreateTime());
        String s=str;
        s+=" 00:00:00";
        System.out.println(s);
        form.setCreateTimel(s);
        str+=" 23:59:59";
        form.setEndTimel(str);
        return analysisDao.getParam(form);
    }

    @Override
    public List<ParamEntity> getParamList(Long riverId, Integer type) {
        return analysisDao.getParamList(riverId, type);
    }
}
