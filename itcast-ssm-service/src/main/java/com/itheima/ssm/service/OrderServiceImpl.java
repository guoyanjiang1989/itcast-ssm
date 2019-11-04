package com.itheima.ssm.service;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Order> findAll() throws Exception {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findAllByPage(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return orderDao.findAll();
    }

    @Override
    public Order findById(Integer id) throws Exception {
        return orderDao.findById(id);
    }
}
