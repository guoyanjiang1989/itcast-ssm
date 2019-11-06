package com.itheima.ssm.dao;

import com.itheima.ssm.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from user where username = #{username}")
    @Results(
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findById"))
    )
    User findByUserName(String username);

    @Select("select * from user")
    List<User> findAll() throws Exception;

    @Insert("insert into user(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(User user) throws Exception;

    @Select("select * from user where id = #{id}")
    User findById(Integer id) throws Exception;

}
