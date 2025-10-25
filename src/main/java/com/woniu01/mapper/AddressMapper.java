package com.woniu01.mapper;

import com.woniu01.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description 针对表【address(地址表)】的数据库操作Mapper
* @createDate 2025-08-15 17:28:06
* @Entity com.woniu.entity.Address
*/
public interface AddressMapper {
    //查询所有地址
    List<Address> selectAll();
    //根据id查询
    Address selectById(int aid);
    //添加地址
    void insert( Address address);
    //修改地址
    void update(Address address);
    //删除地址
    void deleteByName(String aname);
    //根据id删除地址
    void deleteByAid(int id);
    // 根据地址名查询
    Address selectByName(String aname);

    List<Address> selectAddressByUid(int uid);
}




