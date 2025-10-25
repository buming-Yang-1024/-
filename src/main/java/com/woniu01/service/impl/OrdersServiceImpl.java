package com.woniu01.service.impl;

import com.woniu01.entity.Orders;
import com.woniu01.mapper.MybatisUtl;
import com.woniu01.mapper.OrdersMapper;
import com.woniu01.service.OrdersService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * ClassName: OrdersServiceImpl
 * Package: com.woniu01.service.impl
 * Description:
 *
 * @Create: 2025/8/15 - 17:47
 * @Version: V1.0
 */
public class OrdersServiceImpl implements OrdersService {
  
    @Override
    public List<Orders> findAllOrders() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.selectAll();
        sqlSession.close();
        return ordersList;
    }

    @Override
    public void addOrders(Orders orders) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        ordersMapper.insert(orders);
        sqlSession.close();
    }

    @Override
    public void updateOrders(Orders orders) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        ordersMapper.update(orders);
        sqlSession.close();
    }

    @Override
    public void deleteOrders(int oid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        ordersMapper.deleteByOid(oid);
        sqlSession.close();
    }

    @Override
    public Orders selectById(int oid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        Orders findOrders = ordersMapper.selectById(oid);
        sqlSession.close();
        // 1<<1 1*2的1次方=2  1<<0 1*2的0次方 =1
        // 101   sum=0   sum = sum<<1 | head.val;          sum=1
        // sum =2
        // sum=4

        return findOrders;
    }


}
