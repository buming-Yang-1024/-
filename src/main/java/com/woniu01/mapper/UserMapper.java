package com.woniu01.mapper;

import com.woniu01.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2025-08-15 12:15:50
* @Entity com.woniu.entity.User
*/
public interface UserMapper {
   void insert(User user);
   User selectByName(String uname);
   User selectByEmail(String email);
   User selectByNameAndPassword(@Param("uname") String uname,@Param("password") String password);

    void update(User user);
}




