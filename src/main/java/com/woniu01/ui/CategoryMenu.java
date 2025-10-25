package com.woniu01.ui;

import com.woniu01.entity.GoodCategory;
import com.woniu01.service.GoodCategoryService;
import com.woniu01.service.impl.GoodCategoryServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * ClassName: CategoryMenu
 * Package: com.woniu01.ui
 * Description:
 *
 * @Create: 2025/8/16 - 10:37
 * @Version: V1.0
 */
public class CategoryMenu {
    private static GoodCategoryService goodCategoryService = new GoodCategoryServiceImpl();
    public static void show()
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag)
        {
            System.out.println("1.查看所有分类");
            System.out.println("2.添加分类");
            System.out.println("3.修改分类");
            System.out.println("4.删除分类");
            System.out.println("5.返回");
            int choose = sc.nextInt();
            switch ( choose)
                {
                    case 1:
                        System.out.println("查看所有分类");
                        findAllCategory();
                        break;
                    case 2:
                        System.out.println("添加分类");
                        addCategory();
                        break;
                    case 3:
                        System.out.println("修改分类");
                        updateCategory();
                        break;
                    case 4:
                        System.out.println("删除分类");
                        deleteCategory();
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println("输入错误，请重新输入");
                        break;
                }
        }

    }
    public static void findAllCategory()
    {
        List<GoodCategory> allCategory = goodCategoryService.findAllCategory();
        System.out.println("id"+"\t\t"+"分类名字");
        allCategory.forEach(goodCategory -> System.out.println(goodCategory.getCid()+"\t\t"+goodCategory.getCname()));
    }
    public static void addCategory()
    {
        Scanner sc = new Scanner(System.in);
        String cname;
        do
        {
            System.out.println("请输入分类名称");
            cname = sc.nextLine();
        }while (!(cname.length()>=1 && cname.length()<=10));
        GoodCategory goodCategory = new GoodCategory();
        goodCategory.setCname(cname);
        try {
            goodCategoryService.addCategory(goodCategory);
            System.out.println("添加成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    public static void updateCategory()
    {
        Scanner sc = new Scanner(System.in);
        findAllCategory();
        System.out.println("请输入要修改分类的id");
        int cid= sc.nextInt();
        String newCname;
        sc.nextLine();
        do
        {
            System.out.println("请输入新的分类名称");
            newCname = sc.nextLine();

        }while (!(newCname.length()>=1 && newCname.length()<=10));
        GoodCategory goodCategory = new GoodCategory();
        goodCategory.setCname(newCname);
        goodCategory.setCid(cid);
        try {
            goodCategoryService.updateCategory(goodCategory);
            System.out.println("修改成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteCategory()
    {
        Scanner sc = new Scanner(System.in);
        String cname;
        do
        {
            System.out.println("请输入要删除的分类名称");
            cname = sc.nextLine();
        }while (!(cname.length()>=1 && cname.length()<=10));
        try {
            goodCategoryService.deleteCategory(cname);
            System.out.println("删除成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
