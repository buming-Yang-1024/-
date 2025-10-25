package com.woniu01.mapper;

import com.woniu01.entity.Orderitem;

import java.util.List;

/**
* @description 针对表【orderitem(订单条目项表)】的数据库操作Mapper
* @createDate 2025-08-15 17:28:06
* @Entity com.woniu.entity.Orderitem
*/
public interface OrderitemMapper {
    //查询所有订单条目
    List<Orderitem> selectAll();
    //查询指定订单条目
    Orderitem selectById(int otid);
    //添加订单条目
    void insert( Orderitem orderitem);
    //修改订单条目
    void update( Orderitem orderitem);
    //删除订单条目
    void deleteByOtid(int otid);
}




