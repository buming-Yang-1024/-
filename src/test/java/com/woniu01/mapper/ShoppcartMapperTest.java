package com.woniu01.mapper;
import com.woniu01.entity.Good;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.woniu01.entity.User;

import com.woniu01.entity.Shoppcart;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: ShoppcartMapperTest
 * Package: com.woniu01.mapper
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/19 - 15:26
 * @Version: V1.0
 */
public class ShoppcartMapperTest {
    SqlSession sqlSession = MybatisUtl.getSqlSession();
    ShoppcartMapper shoppcartMapper = sqlSession.getMapper(ShoppcartMapper.class);
    @Test
    public void insert() {
        Shoppcart shoppcart = new Shoppcart();
        shoppcart.setGname("aphone16");
        User user = new User();
        user.setUid(5);
        shoppcart.setUser(user);
        Good good = new Good();
        good.setGid(3);
        shoppcart.setGood(good);
        shoppcart.setCount(5);
        shoppcart.setPrice(new BigDecimal("22.54"));
        shoppcartMapper.insert(shoppcart);
    }

    @Test
    public void update() {
        Shoppcart shoppcart = new Shoppcart();
        shoppcart.setCount(10);
        shoppcart.setId(2);
        shoppcart.setPrice(new BigDecimal("19.2"));
        shoppcartMapper.update(shoppcart);
    }

    @Test
    public void deleteById() {
        shoppcartMapper.deleteById(2);
    }

    @Test
    public void selectAll() {
        List<Shoppcart> shoppcarts = shoppcartMapper.selectAll();
        System.out.println(shoppcarts);
    }

    @Test
    public void selectById() {
        Shoppcart shoppcart = shoppcartMapper.selectById(4);
        System.out.println(shoppcart);
    }
}