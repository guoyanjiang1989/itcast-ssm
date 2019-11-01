package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus) values (#{id}, #{productnum}, #{productname}, #{cityname}, #{departuretime}, #{productprice}, #{productdesc}, #{productstatus})")
    void save() throws Exception;
}
