package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Order;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize) throws Exception {
        List<Order> orderList = orderService.findAllByPage(page,pageSize);
        PageInfo pageInfo = new PageInfo(orderList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orderList",pageInfo);
        mv.setViewName("order-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        Order order = orderService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("order",order);
        mv.setViewName("order-show");
        return mv;
    }
}
