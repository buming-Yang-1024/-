package com.woniu01.service;

import com.woniu01.entity.Good;

import java.util.List;

/**
 * ClassName: GoodService
 * Package: com.woniu01.service
 * Description:
 *
 * @Create: 2025/8/15 - 17:46
 * @Version: V1.0
 */
public interface GoodService {
    List<Good> findAllGood();
    // 添加商品
    void addGood(Good good);
    // 修改商品
    void updateGood(Good good);
    // 删除商品
    void deleteGood(String cname);
    // 根据商品名称查询
    Good selectByName(String cname);

    void buyGood(int gid,int count,int aid);

    // 根据分类查询商品
    List<Good> findGoodByCategory(int cid);

    // 根据商品id查询商品
    Good selectGoodById(int gid);
}
