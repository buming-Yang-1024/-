package com.woniu01.service;

import com.woniu01.entity.Orders;
import com.woniu01.service.impl.OrdersServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: OrdersServiceTest
 * Package: com.woniu01.service
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/19 - 14:42
 * @Version: V1.0
 */
public class OrdersServiceTest {
   OrdersService ordersService=new OrdersServiceImpl();
    @Test
    public void selectById() {
        Orders orders = ordersService.selectById(32);
        System.out.println(orders);
    }
}