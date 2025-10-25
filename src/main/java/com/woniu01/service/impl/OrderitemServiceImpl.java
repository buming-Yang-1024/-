package com.woniu01.service.impl;

import com.woniu01.entity.Orderitem;
import com.woniu01.mapper.MybatisUtl;
import com.woniu01.mapper.OrderitemMapper;
import com.woniu01.service.OrderitemService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * ClassName: OrderitemServiceImpl
 * Package: com.woniu01.service.impl
 * Description:
 *
 * @Create: 2025/8/15 - 17:47
 * @Version: V1.0
 */
public class OrderitemServiceImpl implements OrderitemService {
  
    @Override
    public List<Orderitem> findAllOrderitem() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrderitemMapper orderitemMapper = sqlSession.getMapper(OrderitemMapper.class);
        List<Orderitem> orderitemList = orderitemMapper.selectAll();
        sqlSession.close();
        return orderitemList;
    }

    @Override
    public void addOrderitem(Orderitem orderitem) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrderitemMapper orderitemMapper = sqlSession.getMapper(OrderitemMapper.class);
        orderitemMapper.insert(orderitem);
        sqlSession.close();
    }

    @Override
    public void updateOrderitem(Orderitem orderitem) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrderitemMapper orderitemMapper = sqlSession.getMapper(OrderitemMapper.class);
        orderitemMapper.update(orderitem);
        sqlSession.close();
    }

    @Override
    public void deleteOrderitem(int otid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrderitemMapper orderitemMapper = sqlSession.getMapper(OrderitemMapper.class);
        orderitemMapper.deleteByOtid(otid);
        sqlSession.close();
    }

    @Override
    public Orderitem selectById(int otid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        OrderitemMapper orderitemMapper = sqlSession.getMapper(OrderitemMapper.class);
        Orderitem findOrderitem = orderitemMapper.selectById(otid);
        sqlSession.close();
        return findOrderitem;
    }


}
