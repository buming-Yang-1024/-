package com.woniu01.service;

import com.woniu01.entity.Shoppcart;

import java.util.List;

/**
 * ClassName: ShoppcartService
 * Package: com.woniu01.service
 * Description:
 *
 * @Create: 2025/8/19 - 15:33
 * @Version: V1.0
 */
public interface ShoppcartService {
    // 添加购物车
    void addShoppcart(Shoppcart shoppcart);
    // 修改购物车
    void updateShoppcart(Shoppcart shoppcart);
    // 删除购物车
    void deleteShoppcart(int id);
    // 根据购物车名称查询
    Shoppcart selectById(int id);
    // 查询所有购物车
    List<Shoppcart> findAllShoppcart();
    // 根据用户id查询购物车
    List<Shoppcart> findByCartUid(int uid);
    // 购物车下单 支付
    void shoppcartPay(List<Integer> sidList,int aid);

    Shoppcart selectBygId(int gid);
}
