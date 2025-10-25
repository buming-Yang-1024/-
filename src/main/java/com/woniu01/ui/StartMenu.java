package com.woniu01.ui;

import com.woniu01.constance.UserConstance;
import com.woniu01.entity.User;
import com.woniu01.exception.UserNameOrPasswordException;
import com.woniu01.service.UserService;
import com.woniu01.service.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * ClassName: StartMenu
 * Package: com.woniu.ui
 * Description:
 *
 * @Create: 2025/8/15 - 15:05
 * @Version: V1.0
 */
public class StartMenu {
    private static final UserService userService = new UserServiceImpl();
    public static void show()
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag)
        {
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.退出");
            System.out.print("请输入你的选择：");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    login();
                    break;
                case 2:
                    try {
                        register();
                        System.out.println("注册成功");
                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
    public static void login()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String uname = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        try {
            UserConstance.loginUser =userService.login(uname,password);
            System.out.println("登录成功");
            //显示主页面
            StoreMainMenu.show();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void register()
    {
        Scanner sc = new Scanner(System.in);
        String uname;
        do {
            // 名字长度为2-10位 非数字
            System.out.println("请输入你的名字");
            uname=sc.nextLine();
        }while (!uname.matches("^[a-zA-Z]{2,10}$"));
        String password;
        do
        {
            // 密码长度为3-10位
            System.out.println("请输入你的密码");
            password=sc.nextLine();
        }while (!password.matches("^\\w{3,10}$"));
        String email;
        do
        {
            // 邮箱格式为xxx@xxx.xxx
            System.out.println("请输入你的邮箱");
            email=sc.nextLine();
        }while (!email.matches("^\\w+@\\w+\\.\\w+$"));
        String phone;
        do
        {
            // 手机号格式为11位数字：1开头，10位数字
            System.out.println("请输入你的手机号");
            phone=sc.nextLine();
        }while (!phone.matches("^1\\d{1,10}$"));
        User user = new User(null, uname, password, email, phone, null,null,null,null);
        userService.registered(user);
    }
}
