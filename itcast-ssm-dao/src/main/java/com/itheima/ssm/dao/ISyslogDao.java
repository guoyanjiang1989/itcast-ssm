package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISyslogDao {

    @Select("select * from syslog")
    List<Syslog> findAll() throws Exception;

    @Insert("insert into syslog (visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(Syslog syslog) throws Exception;
}
