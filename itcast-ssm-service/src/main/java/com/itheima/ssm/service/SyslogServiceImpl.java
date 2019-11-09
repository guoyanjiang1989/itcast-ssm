package com.itheima.ssm.service;

import com.itheima.ssm.dao.ISyslogDao;
import com.itheima.ssm.domain.Syslog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SyslogServiceImpl implements ISyslogService {

    @Autowired
    private ISyslogDao syslogDao;

    @Override
    public List<Syslog> findAll() throws Exception {
        return syslogDao.findAll();
    }

    @Override
    public void save(Syslog syslog) throws Exception {
        syslogDao.save(syslog);
    }


}
