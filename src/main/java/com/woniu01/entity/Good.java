package com.woniu01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @TableName good
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    private Integer gid;

    private String gname;

    private BigDecimal price;

    private Integer count;

    // 一个商品对应一个类别
    private GoodCategory goodCategory;
    private Integer isDelete;

}