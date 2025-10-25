package com.woniu01.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.woniu01.entity.User;
import com.woniu01.exception.EmailExistException;
import com.woniu01.exception.UserExistException;
import com.woniu01.exception.UserNameOrPasswordException;
import com.woniu01.mapper.MybatisUtl;
import com.woniu01.mapper.UserMapper;
import com.woniu01.service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ClassName: UserServiceImpl
 * Package: com.woniu01.service.impl
 * Description:
 *
 * @Create: 2025/8/15 - 16:04
 * @Version: V1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public void registered(User user) {
            SqlSession sqlSession = MybatisUtl.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User findUser = userMapper.selectByName(user.getUname());
            if (findUser != null)
            {
                throw new UserExistException("用户已存在");
            }
            findUser=userMapper.selectByEmail(user.getEmail());
            if(findUser!=null)
            {
                throw new EmailExistException("邮箱已存在");
            }
            // 设置默认余额和注册时间
            user.setBalance(new BigDecimal(2000.0));
            user.setRegisttime(LocalDateTime.now());
            //密码加密
            user.setPassword(DigestUtil.md5Hex(user.getPassword()));
            userMapper.insert(user);
            sqlSession.close();
    }

    @Override
    public User login(String uname, String password) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByName(uname);
        if(user==null)
        {
            throw new UserNameOrPasswordException("用户不存在");
        }
        if(!user.getPassword().equals(DigestUtil.md5Hex(password)))
        {
            throw new UserNameOrPasswordException("密码错误");
        }
        //用户脱敏
        user.setPassword("");
        sqlSession.close();
        return user;
    }

    @Override
    public User findByName(String uname) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByName(uname);
        sqlSession.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.update(user);

    }

}
