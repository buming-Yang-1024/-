package com.woniu01.mapper;
import java.math.BigDecimal;
import com.woniu01.entity.Orderitem;
import java.time.LocalDateTime;
import com.woniu01.entity.User;
import java.util.ArrayList;
import java.util.List;

import cn.hutool.db.sql.Direction;

import cn.hutool.db.sql.Order;
import com.woniu01.entity.Orders;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: OrdersMapperTest
 * Package: com.woniu01.mapper
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/18 - 12:02
 * @Version: V1.0
 */
public class OrdersMapperTest {
    SqlSession sqlSession = MybatisUtl.getSqlSession();
    OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
    @Test
    public void selectAll() {
        List<Orders> orders = ordersMapper.selectAll();
        System.out.println(orders);
    }

    @Test
    public void selectById() {
        Orders orders = ordersMapper.selectById(1);
        System.out.println(orders);
    }

    @Test
    public void insert() {
        Orders orders = new Orders();
        User user = new User();
        user.setUid(5);
        orders.setUser(user);
        orders.setTotalMoney(new BigDecimal("100"));
        orders.setTotalCount(2);
        orders.setAname("湖南省衡阳市");
        orders.setOrderTime(LocalDateTime.now());
        orders.setOrderitemList(new ArrayList<Orderitem>());
        ordersMapper.insert(orders);
    }

    @Test
    public void update() {
        Orders orders = new Orders();
        orders.setOid(1);
        orders.setTotalMoney(new BigDecimal("200"));
        orders.setTotalCount(10);
        orders.setOrderTime(LocalDateTime.now());
        orders.setOrderitemList(new ArrayList<Orderitem>());
        orders.setIsDelete(0);
        ordersMapper.update(orders);
    }

    @Test
    public void deleteByOid() {
        ordersMapper.deleteByOid(1);
    }

    @Test
    public void selectStepByOid() {
        System.out.println(ordersMapper.selectStepByOid(41));

    }

    @Test
    public void testSelectById() {
        System.out.println(ordersMapper.selectById(41));
    }
}