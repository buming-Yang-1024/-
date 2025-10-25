package com.woniu01.ui;

import com.woniu01.entity.GoodCategory;
import com.woniu01.service.GoodCategoryService;
import com.woniu01.service.impl.GoodCategoryServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * ClassName: StoreMainMenu
 * Package: com.woniu01.ui
 * Description:
 *
 * @Create: 2025/8/15 - 17:04
 * @Version: V1.0
 */
public class StoreMainMenu {
    private static GoodCategoryService goodCategoryService = new GoodCategoryServiceImpl();
    public static void show()
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag)
        {
            System.out.println("欢迎来到商城系统");
            System.out.println("1.分类管理");
            System.out.println("2.商品管理");
            System.out.println("3.订单管理");
            System.out.println("4.地址管理");
            System.out.println("5.购物车管理");
            System.out.println("6.注销");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("分类管理");
                    CategoryMenu.show();
                    break;
                case 2:
                    System.out.println("商品管理");
                    GoodMenu.show();
                    break;
                case 3:
                    System.out.println("订单管理");
                    OrderMenu.show();
                    break;
                case 4:
                    System.out.println("地址管理");
                    AddressMenu.show();
                    break;
                case 5:
                    System.out.println("购物车管理");
                    ShoppcartMenu.show();
                    break;
                case 6:
                    flag=false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }

    }


}



