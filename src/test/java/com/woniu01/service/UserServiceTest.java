package com.woniu01.service;

import com.woniu01.entity.User;
import com.woniu01.service.impl.UserServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * ClassName: UserServiceTest
 * Package: com.woniu01.service
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/15 - 16:37
 * @Version: V1.0
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registered() {
       // User user = new User(null, "admin2", "123", "admin@1235", "12345678901", new BigDecimal(2000.0), LocalDateTime.now());
        try {
           // userService.registered(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}