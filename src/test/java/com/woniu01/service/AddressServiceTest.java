package com.woniu01.service;
import com.woniu01.entity.User;

import com.woniu01.entity.Address;
import com.woniu01.service.impl.AddressServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ClassName: AddressServiceTest
 * Package: com.woniu01.service
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/16 - 17:48
 * @Version: V1.0
 */
public class AddressServiceTest {
    private  AddressService addressService=new AddressServiceImpl();
    @Test
    public void findAllAddress() {
        System.out.println(addressService.findAllAddress());
    }

    @Test
    public void addAddress() {
        Address address=new Address();
        address.setAname("广东省深圳市");
        User user = new User();
        user.setUid(5);
        address.setUser(user);
        addressService.addAddress(address);

    }

    @Test
    public void updateAddress() {
        Address address=new Address();
        address.setAname("广东省深圳市昵称村");
        User user = new User();
        user.setUname("liu");
        address.setUser(user);
        address.setAid(3);
        addressService.updateAddress(address);
    }

    @Test
    public void deleteAddress() {
        addressService.deleteAddress("广东省深圳市");
    }

    @Test
    public void deleteByAid() {
        addressService.deleteByAid(3);
    }

    @Test
    public void selectByName() {
        System.out.println(addressService.selectByName("湖南省衡阳市"));
    }

    @Test
    public void selectById() {
        Address address = addressService.selectById(2);
        System.out.println(address);
    }

    @Test
    public void selectByUid() {
        List<Address> addresses = addressService.selectByUid(5);
        System.out.println(addresses);
    }
}