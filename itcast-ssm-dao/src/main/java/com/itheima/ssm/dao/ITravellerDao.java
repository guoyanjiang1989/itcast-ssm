package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerID from order_traveller where id = #{id})")
    public Traveller findById() throws Exception;
}
