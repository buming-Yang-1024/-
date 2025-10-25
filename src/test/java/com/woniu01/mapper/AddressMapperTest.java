package com.woniu01.mapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.woniu01.entity.Orders;
import java.util.ArrayList;

import com.woniu01.entity.Address;
import com.woniu01.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ClassName: AddressMapperTest
 * Package: com.woniu01.mapper
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/16 - 17:12
 * @Version: V1.0
 */
public class AddressMapperTest {
    AddressMapper mapper = MybatisUtl.getSqlSession().getMapper(AddressMapper.class);
    @Test
    public void selectAll() {
        List<Address> addresses = mapper.selectAll();
        System.out.println(addresses);
    }

    @Test
    public void selectById() {
        mapper.selectById(2);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUid(5);
      //  mapper.insert(new Address(null,"张三",user,0));
    }

    @Test
    public void update() {
        User user = new User();
        user.setUid(5);
        //mapper.update(new Address(7,"李四",user,0));
    }

    @Test
    public void deleteByName() {
        mapper.deleteByName("张三");
    }

    @Test
    public void selectByName() {
    }
}