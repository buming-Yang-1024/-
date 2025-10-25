package com.woniu01.ui;

import com.woniu01.entity.Good;
import com.woniu01.entity.User;
import com.woniu01.mapper.GoodMapper;
import com.woniu01.mapper.MybatisUtl;
import com.woniu01.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName: GoodMenuTest
 * Package: com.woniu01.ui
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/16 - 16:30
 * @Version: V1.0
 */
public class GoodMenuTest {

    @Test
    public void updateGoods() {
        String regex="^([\\u4E00-\\u9FA5]{2,})(?:省|市|自治区|特别行政区|区|县)([\\u4E00-\\u9FA5]{2,})(?:市|自治州|地区|县)([\\u4E00-\\u9FA5]{2,})(?:市|区|县)?([\\u4E00-\\u9FA5]{2,})?(?:街道|镇|乡|街道办事处)?([\\u4E00-\\u9FA5]{2,})?(?:村|社区|居委会)?$";
        String address="广东省你妈南山区牛马村";
        System.out.println(address.matches(regex));
    }
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper goodMapper = sqlSession.getMapper(GoodMapper.class);
        Good good = goodMapper.selectById(4);
        BigDecimal price = good.getPrice();
        BigDecimal multiply = price.multiply(new BigDecimal(2));
        System.out.println(multiply);
        sqlSession = MybatisUtl.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByName("liu");
        BigDecimal balance = user.getBalance();
        BigDecimal subtract = balance.subtract(multiply);
        System.out.println(subtract);
    }
    @Test
    public void test01()
    {
        System.out.println(4| 1); //100 001
    }
}