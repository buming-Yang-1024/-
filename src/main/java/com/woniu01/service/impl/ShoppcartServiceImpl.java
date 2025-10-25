package com.woniu01.service.impl;
import cn.hutool.core.bean.BeanUtil;
import com.woniu01.entity.Good;
import com.woniu01.entity.Orders;
import java.math.BigDecimal;

import com.woniu01.constance.UserConstance;
import com.woniu01.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.woniu01.mapper.MybatisUtl;
import com.woniu01.mapper.ShoppcartMapper;
import com.woniu01.mapper.UserMapper;
import com.woniu01.service.*;
import com.woniu01.service.ShoppcartService;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ClassName: ShoppcartServiceImpl
 * Package: com.woniu01.service.impl
 * Description:
 *
 * @Create: 2025/8/15 - 17:47
 * @Version: V1.0
 */
public class ShoppcartServiceImpl implements ShoppcartService {
   private GoodService goodService=new GoodServiceImpl();
   private AddressService addressService=new AddressServiceImpl();
   private UserService userService=new UserServiceImpl();
   private OrdersService ordersService=new OrdersServiceImpl();
   private OrderitemService orderitemService=new OrderitemServiceImpl();
    @Override
    public List<Shoppcart> findAllShoppcart() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
        List<Shoppcart> shoppcartList = shoppcartMapper.selectAll();
        sqlSession.close();
        return shoppcartList;
    }

    @Override
    public List<Shoppcart> findByCartUid(int uid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
        List<Shoppcart> shoppcarts = shoppcartMapper.selectByUid(uid);
        sqlSession.close();
        return shoppcarts;
    }

    @Override
    public void shoppcartPay(List<Integer> sidList,int aid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=UserConstance.loginUser;
        List<Shoppcart> shoppcartList = sidList.stream().map(this::selectById).toList();
        int totalcount=0;
        BigDecimal totalPrice = new BigDecimal(0);
        List<Orderitem> orderitems=new ArrayList<>();
        for (Shoppcart shoppcart : shoppcartList) {
            int count = shoppcart.getCount();
            // 减少库存
            Good good = goodService.selectGoodById(shoppcart.getGood().getGid());
            int stock = good.getCount();
            Good goods = new Good();
            goods.setCount(stock-count);
            BeanUtil.copyProperties(good,goods,"count");
            goodService.updateGood(goods);
            // 计算总数量
             totalcount+=count;
             //计算总价格
            totalPrice = totalPrice.add(shoppcart.getPrice().multiply(new BigDecimal(count)));
            // 创建订单条目
            Orderitem orderitem = new Orderitem();
            orderitem.setGood(shoppcart.getGood());
            orderitem.setPrice(shoppcart.getPrice());
            orderitem.setCount(shoppcart.getCount());
            orderitems.add(orderitem);
        }
        User curUser = userService.findByName(user.getUname());
        //获取用户的钱数
        BigDecimal balance = curUser.getBalance();
        BigDecimal subtract = balance.subtract(totalPrice);
        if(subtract.compareTo(BigDecimal.ZERO)<0)
        {
            throw  new RuntimeException("用户余额不足，无法购买");
        }
        Address address = addressService.selectById(aid);
        // 创建订单
        Orders orders = new Orders();
        orders.setUser(user);
        orders.setTotalMoney(totalPrice);
        orders.setTotalCount(totalcount);
        orders.setAname(address.getAname());
        orders.setPhone(address.getPhone());
        orders.setEmail(address.getEmail());
        orders.setOrderTime(LocalDateTime.now());
        // 将订单存入数据库
        ordersService.addOrders(orders);
        //将订单项存入数据库
        for (Orderitem orderitem : orderitems) {
            orderitem.setOrders(orders);
            orderitemService.addOrderitem(orderitem);
        }
        //更新用户的余额
        curUser.setBalance(subtract);
        userMapper.update(curUser);
        //删除购物车
        ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
        for (Shoppcart shoppcart : shoppcartList) {
            shoppcartMapper.deleteById(shoppcart.getId());
        }
    }

    @Override
    public Shoppcart selectBygId(int gid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
        Shoppcart shoppcart=shoppcartMapper.selectByGid(gid);
        return shoppcart;
    }

    @Override
    public void addShoppcart(Shoppcart shoppcart) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
        int count = shoppcart.getCount();
        Good good = goodService.selectGoodById(shoppcart.getGood().getGid());
        if(good.getCount()-count<0)
        {
            throw new RuntimeException("超出库存，不能添加");
        }
        shoppcartMapper.insert(shoppcart);
        sqlSession.close();
    }

    @Override
    public void updateShoppcart(Shoppcart shoppcart) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
        Integer count = shoppcart.getCount();
        if(count<0)
        {
            throw new RuntimeException("数量不能小于0");
        }
        shoppcartMapper.update(shoppcart);
        sqlSession.close();
    }

    @Override
    public void deleteShoppcart(int id) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
        shoppcartMapper.deleteById(id);
        sqlSession.close();
    }

    @Override
    public Shoppcart selectById(int id) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
        Shoppcart findShoppcart = shoppcartMapper.selectById(id);
        sqlSession.close();
        return findShoppcart;
    }


}
