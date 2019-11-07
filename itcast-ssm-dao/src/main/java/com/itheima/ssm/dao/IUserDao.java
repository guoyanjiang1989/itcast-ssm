package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from user where username = #{username}")
    @Results(
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    )
    User findByUserName(String username);

    @Select("select * from user")
    List<User> findAll() throws Exception;

    @Insert("insert into user(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(User user) throws Exception;

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    User findById(Integer id) throws Exception;

    @Select("select * from role where id not in (select roleID from user_role where userID = #{id})")
    List<Role> findOtherRoles(Integer id) throws Exception;

    @Insert("insert into user_role (userID,roleID) values (#{userID},#{roleID})")
    void addRolesToUser(@Param("userID") Integer userID, @Param("roleID") Integer roleID) throws Exception;
}
