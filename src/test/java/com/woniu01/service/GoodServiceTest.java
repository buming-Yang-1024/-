package com.woniu01.service;

import com.woniu01.constance.UserConstance;
import com.woniu01.entity.Good;
import com.woniu01.entity.GoodCategory;
import com.woniu01.entity.User;
import com.woniu01.service.impl.GoodServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName: GoodServiceTest
 * Package: com.woniu01.service
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/16 - 16:09
 * @Version: V1.0
 */
public class GoodServiceTest {
    private GoodService goodService = new GoodServiceImpl();
    @Test
    public void findAllGood() {
    }

    @Test
    public void addGood() {
        Good good = new Good();
        good.setGname("aphone8");
        good.setPrice(new BigDecimal(44));
        good.setCount(55);
        GoodCategory category = new GoodCategory();
        category.setCid(1);
        good.setGoodCategory(category);
        goodService.addGood(good);

    }

    @Test
    public void updateGood() {
        Good good = new Good();
        good.setGid(2);
        good.setGname("aphone16");
        good.setPrice(new BigDecimal(22));
        good.setCount(33);
        GoodCategory category = new GoodCategory();
        category.setCid(1);
        good.setGoodCategory(category);
        goodService.updateGood(good);
    }

    @Test
    public void deleteGood() {
        goodService.deleteGood("aphone88");
    }

    @Test
    public void selectByName() {
    }

    @Test
    public void buyGood() {
        User user = new User();
        user.setUid(5);
        UserConstance.loginUser=user;
        try {
            goodService.buyGood(4,4,8);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}