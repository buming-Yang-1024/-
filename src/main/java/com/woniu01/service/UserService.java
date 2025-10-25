package com.woniu01.service;

import com.woniu01.entity.User;

/**
 * ClassName: Userservice
 * Package: com.woniu01.service
 * Description:
 *注册
 * @Create: 2025/8/15 - 16:02
 * @Version: V1.0
 */
public interface UserService {
    void registered(User user);
    User login(String uname, String password);
    User findByName(String uname);
    void updateUser(User user);
}
