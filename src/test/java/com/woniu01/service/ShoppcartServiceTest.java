package com.woniu01.service;

import com.woniu01.constance.UserConstance;
import com.woniu01.entity.User;
import com.woniu01.service.impl.ShoppcartServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ClassName: ShoppcartServiceTest
 * Package: com.woniu01.service
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/19 - 17:22
 * @Version: V1.0
 */
public class ShoppcartServiceTest {
    ShoppcartService shoppcartService=new ShoppcartServiceImpl();
    @Test
    public void shoppcartPay() {
        User user = new User();
        user.setUid(5);
        user.setUname("liu");
        UserConstance.loginUser=user;
        List<Integer> sidList=new ArrayList<>();
        int aid=8;
        sidList.add(9);
        sidList.add(10);
        //757.94     剩余242.06
        shoppcartService.shoppcartPay(sidList, aid);
    }
}