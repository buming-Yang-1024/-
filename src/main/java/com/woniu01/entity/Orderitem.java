package com.woniu01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @TableName orderitem
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderitem {
    private Integer otid;

    private Orders orders;

    private Good good;

    private BigDecimal price;
    private Integer count;
    private Integer isDelete;


}