package com.itheima.ssm.service;

import com.itheima.ssm.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    List<Order> findAll() throws Exception;

    List<Order> findAllByPage(Integer page,Integer pageSize) throws Exception;

    Order findById(Integer id) throws Exception;
}
