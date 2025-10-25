package com.woniu01.mapper;
import com.woniu01.entity.Good;
import java.math.BigDecimal;
import java.util.List;

import com.woniu01.entity.Orders;

import com.woniu01.entity.Orderitem;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: OrderitemMapperTest
 * Package: com.woniu01.mapper
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/18 - 14:04
 * @Version: V1.0
 */
public class OrderitemMapperTest {
    SqlSession sqlSession = MybatisUtl.getSqlSession();
    OrderitemMapper orderitemMapper = sqlSession.getMapper(OrderitemMapper.class);
    @Test
    public void selectAll() {
        List<Orderitem> orderitems = orderitemMapper.selectAll();
        System.out.println(orderitems);
    }

    @Test
    public void selectById() {
        Orderitem orderitem = orderitemMapper.selectById(1);
        System.out.println(orderitem);
    }

    @Test
    public void insert() {
        Orderitem orderitem = new Orderitem();
        Orders orders = new Orders();
        orders.setOid(1);
        orderitem.setOrders(orders);
        Good good = new Good();
        good.setGid(1);
        orderitem.setGood(good);
        orderitem.setPrice(new BigDecimal("10"));
        orderitem.setCount(2);
        orderitemMapper.insert(orderitem);
    }

    @Test
    public void update() {
        Orderitem orderitem = new Orderitem();
        Orders orders = new Orders();
        orders.setOid(1);
        orderitem.setOrders(orders);
        Good good = new Good();
        good.setGid(4);
        orderitem.setGood(good);
        orderitem.setPrice(new BigDecimal("100"));
        orderitem.setOtid(1);
        orderitemMapper.update(orderitem);
    }

    @Test
    public void deleteByOtid() {

    }
}