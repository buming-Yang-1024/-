package com.woniu01.mapper;

import com.woniu01.entity.Shoppcart;

import java.util.List;

/**
* @description 针对表【shoppcart(购物车表)】的数据库操作Mapper
* @createDate 2025-08-19 15:08:43
* @Entity com.woniu.entity.Shoppcart
*/
public interface ShoppcartMapper {
    // 增加购物车
    void insert(Shoppcart shoppcart);
    //更新购物车
    void update(Shoppcart shoppcart);
    // 删除购物车
    void deleteById(int id);
    // 查询全部购物车
    List<Shoppcart> selectAll();
    //根据id查询购物车
    Shoppcart selectById(int id);
    // 根据用户id查询购物车
    List<Shoppcart> selectByUid(int uid);

    // 根据商品id查询购物车
    Shoppcart selectByGid(int gid);
}




