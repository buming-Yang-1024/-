package com.woniu01.service;

import com.woniu01.entity.Address;

import java.util.List;

/**
 * ClassName: AddressService
 * Package: com.woniu01.service
 * Description:
 *
 * @Create: 2025/8/15 - 17:46
 * @Version: V1.0
 */
public interface AddressService {
    List<Address> findAllAddress();
    // 添加地址
    void addAddress(Address address);
    // 修改地址
    void updateAddress(Address address);
    // 根据地址名称删除
    void deleteAddress(String aname);
    // 根据地址id删除
    void deleteByAid(int aid);
    // 根据地址名称查询
    Address selectByName(String aname);
    // 根据地址id查询
    Address selectById(int aid);
    //根据用户id查询地址
    List<Address> selectByUid(int uid);
}
