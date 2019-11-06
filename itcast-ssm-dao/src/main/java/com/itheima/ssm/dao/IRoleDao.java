package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in(select roleID from user_role where userID = #{id})")
    public List<Role> findById() throws Exception;
}
