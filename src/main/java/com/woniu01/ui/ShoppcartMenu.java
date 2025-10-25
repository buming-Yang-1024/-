package com.woniu01.ui;

import com.woniu01.constance.UserConstance;
import com.woniu01.entity.Address;
import com.woniu01.entity.Shoppcart;
import com.woniu01.service.AddressService;
import com.woniu01.service.ShoppcartService;
import com.woniu01.service.impl.AddressServiceImpl;
import com.woniu01.service.impl.ShoppcartServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: ShoppcartMenu
 * Package: com.woniu01.ui
 * Description:
 *
 * @Create: 2025/8/19 - 15:38
 * @Version: V1.0
 */
public class ShoppcartMenu {
    private static ShoppcartService shoppcartService=new ShoppcartServiceImpl();
    private static AddressService addressService=new AddressServiceImpl();
    public static void show()
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag)
        {
            System.out.println("1.查看购物车");
            System.out.println("2.修改购物车");
            System.out.println("3.删除购物车");
            System.out.println("4.购物车下单");
            System.out.println("5.返回");
            int choose = sc.nextInt();
            switch ( choose)
            {
                case 1:
                    System.out.println("查看购物车");
                    findShoppcart();
                    break;
                case 2:
                    System.out.println("修改购物车");
                    updateShoppcart();
                    break;
                case 3:
                    System.out.println("删除购物车");
                    deleteShoppcart();
                    break;
                case 4:
                    System.out.println("购物车下单");
                    shoppcartPay();
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
    public static void shoppcartPay(){
        findShoppcart();
        Scanner sc = new Scanner(System.in);
        List<Integer> sidList=new ArrayList<>();
        boolean flag=true;
        while (flag)
        {
            System.out.println("请选择你要下单购物车条目id");
            int sid=sc.nextInt();
            sidList.add(sid);
            System.out.println("是否停止选择 1-停止  其他-继续");
            int choose=sc.nextInt();
            if(choose==1)
            {
                flag=false;
            }
        }
        List<Address> addresses = addressService.selectByUid(UserConstance.loginUser.getUid());
        addresses.forEach(address -> {
            System.out.println(address.getAid()+"\t"+address.getAname()+"\t"+ address.getPhone()+"\t"+address.getEmail());
        });
        System.out.println("请选择你的地址");
        int aid=sc.nextInt();
        try {
            shoppcartService.shoppcartPay(sidList,aid);
            System.out.println("下单成功");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void findShoppcart()
    {

        System.out.println("id"+"\t\t"+"商品名"+"\t\t"+"用户id"+"\t\t"+"商品id"+"\t\t"+"数量"+"\t\t"+"价格"+"\t\t"+"创建时间");
        try {
            List<Shoppcart> byCart = shoppcartService.findByCartUid(UserConstance.loginUser.getUid());
            byCart.forEach(shoppcart -> {
                System.out.println( shoppcart.getId()+"\t\t"+shoppcart.getGname()+"\t\t"+shoppcart.getUser().getUid()+"\t\t"+shoppcart.getGood().getGid()+"\t\t"+
                        shoppcart.getCount()+"\t\t"+shoppcart.getPrice()+"\t\t"+shoppcart.getCreatetime());
            });
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void updateShoppcart()
    {
        //购物车只能修改商品数量
        // 五号用户购物车中有aphone16,apone9
        Scanner sc = new Scanner(System.in);
        List<Shoppcart> allShoppcart = shoppcartService.findAllShoppcart();
        allShoppcart.forEach(shoppcart -> {
            System.out.println(shoppcart.getId()+"\t"+shoppcart.getGname());
        });
        System.out.println("请输入要修改的购物车条目id");
        int sid=sc.nextInt();
        Shoppcart shoppcart = shoppcartService.selectById(sid);
        System.out.println("请输入新的商品数量");
        int count=sc.nextInt();
        shoppcart.setCount(count);
        try {
            shoppcartService.updateShoppcart(shoppcart);
            System.out.println("修改成功");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void deleteShoppcart()
    {
        Scanner sc = new Scanner(System.in);
        List<Shoppcart> allShoppcart = shoppcartService.findAllShoppcart();
        allShoppcart.forEach(shoppcart -> {
            System.out.println(shoppcart.getId()+"\t"+shoppcart.getGname());
        });
        System.out.println("请输入要删除购物车条目的id");
        int deleteId=sc.nextInt();
        try {
            shoppcartService.deleteShoppcart(deleteId);
            System.out.println("删除成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
