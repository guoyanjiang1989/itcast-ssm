package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Syslog;
import com.itheima.ssm.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SyslogController {

    @Autowired
    private ISyslogService syslogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {

        List<Syslog> syslogs = syslogService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("syslogs",syslogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
