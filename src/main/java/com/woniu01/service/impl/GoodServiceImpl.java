package com.woniu01.service.impl;
import java.time.LocalDateTime;

import cn.hutool.core.bean.BeanUtil;
import com.woniu01.constance.UserConstance;
import com.woniu01.entity.*;

import com.woniu01.exception.GoodExistException;
import com.woniu01.exception.GoodNotExistException;
import com.woniu01.mapper.*;
import com.woniu01.service.*;
import com.woniu01.service.GoodService;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: GoodServiceImpl
 * Package: com.woniu01.service.impl
 * Description:
 *
 * @Create: 2025/8/15 - 17:47
 * @Version: V1.0
 */
public class GoodServiceImpl implements GoodService {
    SqlSession sqlSession = MybatisUtl.getNotCmtSqlSession();
    private  GoodCategoryService goodCategoryService = new GoodCategoryServiceImpl();
    private OrderitemService orderitemService=new OrderitemServiceImpl();
    private OrdersService ordersService=new OrdersServiceImpl();
    private AddressService addressService=new AddressServiceImpl();
    private UserService userService=new UserServiceImpl();
    @Override
    public List<Good> findAllGood() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        List<Good> goodCategories = goodMapper.selectAll();
        sqlSession.close();
        return goodCategories;
    }

    @Override
    public void addGood(Good good) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        Good findGood = goodMapper.selectByName(good.getGname());
        if(findGood!=null)
        {
            throw new GoodExistException("该商品已存在");
        }
        goodMapper.insert(good);
        sqlSession.close();
    }
    @Override
    public void updateGood(Good good) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        String gname = good.getGname();
        if(gname.length()<1 || gname.length()>10)
        {
            throw new RuntimeException("商品名称长度必须在1-10之间");
        }
        BigDecimal price = good.getPrice();
        if(price.compareTo(new BigDecimal(0))<0)
        {
            throw new RuntimeException("商品价格必须大于0");
        }
        Integer count = good.getCount();
        if(count<0)
        {
            throw new RuntimeException("商品数量必须大于等于0");
        }
        GoodCategory goodCategory = good.getGoodCategory();
        GoodCategory category = goodCategoryService.selectById(goodCategory.getCid());
        if(category==null)
        {
            throw new RuntimeException("商品分类不能为空");
        }
        good.setGoodCategory(category);
        goodMapper.update(good);
    }
    public void updateGoodByNotCmt(Good good) {
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        String gname = good.getGname();
        if(gname.length()<1 || gname.length()>10)
        {
            throw new RuntimeException("商品名称长度必须在1-10之间");
        }
        BigDecimal price = good.getPrice();
        if(price.compareTo(new BigDecimal(0))<0)
        {
            throw new RuntimeException("商品价格必须大于0");
        }
        Integer count = good.getCount();
        if(count<0)
        {
            throw new RuntimeException("商品数量必须大于等于0");
        }
        GoodCategory goodCategory = good.getGoodCategory();
        GoodCategory category = goodCategoryService.selectByName(goodCategory.getCname());
        if(category==null)
        {
            throw new RuntimeException("商品分类不能为空");
        }
        good.setGoodCategory(category);
        goodMapper.update(good);
    }

    @Override
    public void deleteGood(String gname) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        Good findGood = goodMapper.selectByName(gname);
        if(findGood==null)
        {
            throw new GoodNotExistException("删除的分类不存在");
        }
        goodMapper.deleteByName(gname);
        sqlSession.close();
    }

    @Override
    public Good selectByName(String gname) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        Good findGood = goodMapper.selectByName(gname);
        sqlSession.close();
        return findGood;
    }

    @Override
    public void buyGood( int gid,int count,int aid) {
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        try {
            Good good = goodMapper.selectById(gid);
            if (good==null)
            {
                throw new RuntimeException("商品不存在");
            }
            int stock = good.getCount();
            if(stock-count<0)
            {
                throw new RuntimeException("库存不足");
            }
            //获取商品的价格
            BigDecimal price = good.getPrice();
            //计算总价格
            BigDecimal totalMoney = price.multiply(new BigDecimal(count));
            //获取用户的余额
            User user = userService.findByName(UserConstance.loginUser.getUname());
            BigDecimal balance = user.getBalance();
            //计算用户剩下的钱
            BigDecimal subtract = balance.subtract(totalMoney);
            if(subtract.compareTo(BigDecimal.ZERO)<0)
            {
                throw new RuntimeException("用户余额不足");
            }
            Address address = addressService.selectById(aid);
            if (address==null)
            {
                throw new RuntimeException("地址不存在");
            }
            // 封装订单
            Orders orders = new Orders();
            orders.setUser(UserConstance.loginUser);
            orders.setTotalMoney(totalMoney);
            orders.setTotalCount(count);
            orders.setAname(address.getAname());
            orders.setPhone(address.getPhone());
            orders.setEmail(address.getEmail());
            orders.setOrderTime(LocalDateTime.now());
            orders.setOrderitemList(null);
            //将订单存入数据库
            sqlSession.getMapper(OrdersMapper.class).insert(orders);
            // 封装订单条目
            Orderitem orderitem = new Orderitem();
            orderitem.setOrders(orders);
            orderitem.setGood(good);
            orderitem.setPrice(good.getPrice());
            orderitem.setCount(count);
            // 将订单条目存入数据库
            sqlSession.getMapper(OrderitemMapper.class).insert(orderitem);
            // 减少商品库存
            Good goods = new Good();
            goods.setCount(stock-count);
            BeanUtil.copyProperties(good,goods,"count");

            this.updateGoodByNotCmt(goods);
            // 更新用户余额
            user.setBalance(subtract);
            sqlSession.getMapper(UserMapper.class).update(user);
            //提交事务
            sqlSession.commit();
        } catch (RuntimeException e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Good> findGoodByCategory(int cid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        List<Good> goods = goodMapper.selectGoodByCid(cid);
        return goods;
    }

    @Override
    public Good selectGoodById(int gid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        Good good = goodMapper.selectById(gid);
        return good;
    }
}
