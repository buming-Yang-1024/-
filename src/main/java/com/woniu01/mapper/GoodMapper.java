package com.woniu01.mapper;

import com.woniu01.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description 针对表【good(商品表)】的数据库操作Mapper
* @createDate 2025-08-15 17:28:06
* @Entity com.woniu.entity.Good
*/
public interface GoodMapper {
    //查询所有商品
    List<Good> selectAll();
    //查询指定商品
    Good selectById(int gid);
    // 批量查询商品
    List<Good> selectByIdBatch(List<Integer> gids);
    //添加商品
    void insert( Good good);
    //修改商品
    void update( Good good);
    //删除商品
    void deleteByName(String gname);
    // 根据商品名查询
    Good selectByName(String gname);
    // 根据分类查询订单
    List<Good> selectGoodByCid(int cid);

}




