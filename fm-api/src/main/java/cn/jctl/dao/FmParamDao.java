package cn.jctl.dao;

import cn.jctl.entity.FmParamEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * 
 * @author majiangtao
 * @email gentmjt@gmail.com
 * @date 2018-05-02 16:16:46
 */
public interface FmParamDao extends BaseMapper<FmParamEntity> {
    List<FmParamEntity> selectAll();
}
