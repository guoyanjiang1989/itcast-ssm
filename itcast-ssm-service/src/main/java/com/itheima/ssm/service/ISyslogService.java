package com.itheima.ssm.service;

import com.itheima.ssm.domain.Syslog;

import java.util.List;

public interface ISyslogService {

    List<Syslog> findAll() throws Exception;

    void save(Syslog syslog) throws Exception;
}
