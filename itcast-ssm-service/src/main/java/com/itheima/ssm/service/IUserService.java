package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUserService extends UserDetailsService {

    List<User> findAll() throws Exception;

    void save(User user) throws Exception;

    User findById(Integer id) throws Exception;

    List<Role> findOtherRoles(Integer id) throws Exception;

    void addRolesToUser(Integer userID, Integer[] roleIds) throws Exception;
}
