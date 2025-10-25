package com.woniu01.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName user
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer uid;

    private String uname;

    private String password;

    private String email;

    private String phone;

    private BigDecimal balance;

    private LocalDateTime registtime;
    // 一个用户有多个订单
    private List<Orders> ordersList;
    // 一个用户有多个地址
    private List<Address> addressList;

}