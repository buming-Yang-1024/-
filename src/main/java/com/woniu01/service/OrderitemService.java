package com.woniu01.service;

import com.woniu01.entity.Orderitem;

import java.util.List;

/**
 * ClassName: OrderitemService
 * Package: com.woniu01.service
 * Description:
 *
 * @Create: 2025/8/15 - 17:46
 * @Version: V1.0
 */
public interface OrderitemService {
    List<Orderitem> findAllOrderitem();
    // 添加订单条目
    void addOrderitem(Orderitem orderitem);
    // 修改订单条目
    void updateOrderitem(Orderitem orderitem);
    // 删除订单条目
    void deleteOrderitem(int otid);
    // 根据订单条目名称查询
    Orderitem selectById(int otid);

}
