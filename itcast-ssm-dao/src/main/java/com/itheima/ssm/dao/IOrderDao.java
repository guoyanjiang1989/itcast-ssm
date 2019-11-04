package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Order;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {

    @Select("select * from orders")
    @Results(
            @Result(property = "product",column = "productID",javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById"))
    )
    List<Order> findAll() throws Exception;

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(property = "product",column = "productID",javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
            @Result(property = "traveller",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.ITravellerDao.findById")),
            @Result(property = "member",column = "memberID",javaType = Member.class,one = @One(select = "com.itheima.ssm.dao.IMemberDao.findById"))
    })
    Order findById(Integer id) throws Exception;
}
