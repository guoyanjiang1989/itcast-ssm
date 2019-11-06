package com.itheima.ssm.controller;

import com.itheima.ssm.domain.User;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<User> users = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        User user = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(User user) throws Exception {
        userService.save(user);
        return "redirect: /user/findAll.do";
    }
}
