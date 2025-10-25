package com.woniu01.service;

import com.woniu01.entity.GoodCategory;

import java.util.List;

/**
 * ClassName: GoodCategoryService
 * Package: com.woniu01.service
 * Description:
 *
 * @Create: 2025/8/15 - 17:46
 * @Version: V1.0
 */
public interface GoodCategoryService {
    List<GoodCategory> findAllCategory();
    // 添加分类
    void addCategory(GoodCategory goodCategory);
    // 修改分类
    void updateCategory(GoodCategory goodCategory);
    // 删除分类
    void deleteCategory(String cname);
    // 根据分类名称查询
    GoodCategory selectByName(String cname);
    // 根据分类id查询
    GoodCategory selectById(int cid);
}
