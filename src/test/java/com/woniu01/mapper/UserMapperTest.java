package com.woniu01.mapper;

import com.woniu01.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: UserMapperTest
 * Package: com.woniu.mapper
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/15 - 15:36
 * @Version: V1.0
 */
public class UserMapperTest {
    SqlSession sqlSession = MybatisUtl.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    @Test
    public void insert() {
      //  User user = new User(null, "admin", "123456", "322@33", "12345678901", new BigDecimal(1000), LocalDateTime.now());
       // userMapper.insert(user);
    }


}