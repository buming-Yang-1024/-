package com.woniu01.mapper;

import com.woniu01.entity.GoodCategory;

import java.util.List;

/**
* @description 针对表【good_category(商品分类表)】的数据库操作Mapper
* @createDate 2025-08-15 17:28:06
* @Entity com.woniu.entity.GoodCategory
*/
public interface GoodCategoryMapper {
    //查询所有分类
    List<GoodCategory> selectAll();
    //查询指定分类
    GoodCategory selectById(int cid);
    //添加分类
    void insert(GoodCategory goodCategory);
    //修改分类
    void update(GoodCategory goodCategory);
    //删除分类
    void deleteByName(String cname);
    // 根据分类名查询
    GoodCategory selectByName(String cname);
}




