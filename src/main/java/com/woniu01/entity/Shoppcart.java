package com.woniu01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @TableName shoppcart
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shoppcart {
    private Integer id;

    private String gname;

    private User user;

    private Good good;

    private Integer count;

    private BigDecimal price;

    private LocalDateTime createtime;
}