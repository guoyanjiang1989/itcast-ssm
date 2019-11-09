package com.itheima.ssm.service;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User users = userDao.findByUserName(username);
        List<Role> roles = users.getRoles();
        List<SimpleGrantedAuthority> authorities = getAuthority(roles);
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), users.getStatus() == 0?false:true,
                true, true, true, authorities);
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public void save(User user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(Integer id) throws Exception {
        return userDao.findOtherRoles(id);
    }

    @Override
    public void addRolesToUser(Integer userID, Integer[] roleIds) throws Exception {

        for (Integer roleID:roleIds){
            userDao.addRolesToUser(userID,roleID);
        }
    }


}
