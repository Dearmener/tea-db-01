package com.tea.pj.sys.dao;

import com.tea.pj.sys.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * 日志dao层 --> SysLogMapper.xml
 */
@Mapper
public interface SysLogDao {

    /**
     * 
     * @param username
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysLog> findPageObjects(String username,Integer startIndex,Integer pageSize);

    /**
     *
     * @param username
     * @return
     */
    int getRowCount(String username);

}
