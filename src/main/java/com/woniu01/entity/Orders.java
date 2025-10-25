package com.woniu01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @TableName orders
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer oid;

    private User user;

    private BigDecimal totalMoney;

    private Integer totalCount;

    private String aname;

    private  String phone;

    private String email;

    private LocalDateTime orderTime;

    //一个订单有多个订单项
    private List<Orderitem> orderitemList;
    private Integer isDelete;

}