package com.woniu01.mapper;

import cn.hutool.db.sql.Order;
import com.woniu01.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description 针对表【orders(订单表)】的数据库操作Mapper
* @createDate 2025-08-15 17:28:06
* @Entity com.woniu.entity.Orders
*/
public interface OrdersMapper {
    //查询所有订单
    List<Orders> selectAll();
    //查询指定订单
    Orders selectById(int oid);
    // 分步查询指定订单
    Orders selectStepByOid(int oid);
    //添加订单
    void insert( Orders orders);
    //修改订单
    void update( Orders orders);
    //删除订单
    void deleteByOid(int oid);

}




