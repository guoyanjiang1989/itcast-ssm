package com.itheima.ssm.service;

import com.itheima.ssm.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUserService extends UserDetailsService {

    public List<User> findAll() throws Exception;

    void save(User user) throws Exception;

    User findById(Integer id) throws Exception;
}
