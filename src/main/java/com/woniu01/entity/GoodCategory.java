package com.woniu01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @TableName good_category
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodCategory {
    private Integer cid;

    private String cname;

    //一个分类下有多个商品
    private List<Good> goodList;
    private Integer isDelete;
}