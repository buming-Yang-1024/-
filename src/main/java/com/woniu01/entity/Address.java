package com.woniu01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName address
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Integer aid;

    private String aname;

    private User user;
    private String phone;
    private String email;
    private Integer isDelete;
}