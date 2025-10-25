package com.woniu01.service;

import com.woniu01.entity.Orders;

import java.util.List;

/**
 * ClassName: OrdersService
 * Package: com.woniu01.service
 * Description:
 *
 * @Create: 2025/8/15 - 17:46
 * @Version: V1.0
 */
public interface OrdersService {
    List<Orders> findAllOrders();
    // 添加订单
    void addOrders(Orders orders);
    // 修改订单
    void updateOrders(Orders orders);
    // 删除订单
    void deleteOrders(int oid);
    // 根据订单名称查询
    Orders selectById(int oid);
}
