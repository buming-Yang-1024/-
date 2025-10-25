package com.woniu01.ui;
import java.time.LocalDateTime;
import com.woniu01.entity.User;

import com.woniu01.constance.UserConstance;
import com.woniu01.entity.*;
import com.woniu01.entity.Good;
import com.woniu01.service.AddressService;
import com.woniu01.service.GoodCategoryService;
import com.woniu01.service.GoodService;
import com.woniu01.service.ShoppcartService;
import com.woniu01.service.impl.AddressServiceImpl;
import com.woniu01.service.impl.GoodCategoryServiceImpl;
import com.woniu01.service.impl.GoodServiceImpl;
import com.woniu01.service.impl.ShoppcartServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: GoodMenu
 * Package: com.woniu01.ui
 * Description:
 *
 * @Create: 2025/8/16 - 11:43
 * @Version: V1.0
 */
public class GoodMenu {
    private static GoodService goodService = new GoodServiceImpl();
    private static AddressService addressService=new AddressServiceImpl();
    private static GoodCategoryService goodCategoryService = new GoodCategoryServiceImpl();
    private static ShoppcartService shoppcartService=new ShoppcartServiceImpl();
    public static void show()
    {
        Scanner sc= new Scanner(System.in);
        boolean flag = true;
        while (flag)
        {
            System.out.println("1.查询所有商品");
            System.out.println("2.根据分类查询商品");
            System.out.println("3.添加商品");
            System.out.println("4.修改商品");
            System.out.println("5.删除商品");
            System.out.println("6.返回");
            int choose = sc.nextInt();
            switch (choose)
                {
                    case 1:{
                        System.out.println("查看所有商品");
                        boolean isBuy=true;
                        while (isBuy)
                        {
                            findAllGoods();
                            System.out.println("是否要购买商品");
                            System.out.println("1.购买");
                            System.out.println("2.加入购物车");
                            System.out.println("3.不购买，我只看看");
                            int num=sc.nextInt();
                            switch (num)
                            {
                                case 1:
                                    buyGoods();
                                    break;
                                case 2:
                                    addshoppcart();
                                    break;
                                case 3:
                                    isBuy=false;
                                    break;
                                default:
                                    System.out.println("输入错误");
                                    break;
                            }
                        }
                        break;
                    }

                    case 2:
                    {
                        System.out.println("根据分类查询商品");
                        boolean isBuy=true;
                        while (isBuy)
                        {
                            findGoodByCategory();
                            System.out.println("是否要购买商品");
                            System.out.println("1.购买");
                            System.out.println("2.加入购物车");
                            System.out.println("3.不购买，我只看看");
                            int num=sc.nextInt();
                            switch (num)
                            {
                                case 1:
                                    buyGoods();
                                    break;
                                case 2:
                                    addshoppcart();
                                    break;
                                case 3:
                                    isBuy=false;
                                    break;
                                default:
                                    System.out.println("输入错误");
                                    break;
                            }
                        }
                        break;

                    }
                    case 3:
                        System.out.println("添加商品");
                        addGoods();
                        break;
                    case 4:
                        System.out.println("修改商品");
                        updateGoods();
                        break;
                    case 5:
                        System.out.println("删除商品");
                        deleteGoods();
                        break;
                    case 6:
                        flag = false;
                        break;
                }
                }
        }
    private static void addshoppcart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要添加到购物车商品的id");
        int gid= sc.nextInt();
        System.out.println("请输入你要添加的件数");
        int count=sc.nextInt();
        Good good = goodService.selectGoodById(gid);
        Integer uid = UserConstance.loginUser.getUid();
        User user = new User();
        user.setUid(uid);
        Shoppcart shoppcart = new Shoppcart();
        shoppcart.setGname(good.getGname());
        shoppcart.setUser(user);
        shoppcart.setGood(good);
        shoppcart.setCount(count);
        shoppcart.setPrice(good.getPrice());
        try {
            // 如果要添加到购物车的商品已经在购物车中了，那么就是更新购物车，增加数量
            Shoppcart curCart = shoppcartService.selectBygId(gid);
            if(curCart!=null)
            {
                //商品已经存在
                shoppcart.setCount(curCart.getCount()+count);
                shoppcart.setId(curCart.getId());
                shoppcartService.updateShoppcart(shoppcart);
            }else {
                shoppcartService.addShoppcart(shoppcart);
            }
            System.out.println("添加成功");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void findGoodByCategory()
    {
        Scanner sc = new Scanner(System.in);
        List<GoodCategory> allCategory = goodCategoryService.findAllCategory();
        allCategory.forEach(goodCategory -> {
            System.out.println(goodCategory.getCid()+"\t"+goodCategory.getCname());
        });
        System.out.println("请输入分类id");
        int cid=sc.nextInt();
        List<Good> goods = goodService.findGoodByCategory(cid);
        System.out.println("商品id"+"\t\t"+"商品名字"+"\t\t"+"价格"+"\t\t"+"数量");
        goods.forEach(good ->
                System.out.println(good.getGid()+"\t\t"+good.getGname()+"\t\t"+good.getPrice() +"\t\t"+good.getCount() ));
    }
    public static void buyGoods()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要购买商品的id");
        int gid= sc.nextInt();
        System.out.println("请输入你要购买的件数");
        int count=sc.nextInt();
        List<Address> addresses = addressService.selectByUid(UserConstance.loginUser.getUid());
        addresses.forEach(address -> {
            System.out.println(address.getAid()+"\t"+address.getAname()+"\t"+ address.getPhone()+"\t"+address.getEmail());
        });
        System.out.println("请选择你的地址");
        int aid=sc.nextInt();
        try {
            goodService.buyGood(gid,count,aid);
            System.out.println("购买成功");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void findAllGoods()
    {
        List<Good> allGoods = goodService.findAllGood();
        System.out.println("商品id"+"\t\t"+"商品名字"+"\t\t"+"价格"+"\t\t"+"数量"+"\t\t"+"分类");
        allGoods.forEach(good -> 
                System.out.println(good.getGid()+"\t\t"+good.getGname()+"\t\t"+good.getPrice() +"\t\t"+good.getCount() +"\t\t"+good.getGoodCategory().getCname()));
    }
    public static void addGoods()
    {
        Scanner sc = new Scanner(System.in);
        String gname;
        do
        {
            System.out.println("请输入商品名称");
            gname = sc.nextLine();
        }while (!(gname.length()>=1 && gname.length()<=10));
        BigDecimal price=null;
        do
        {
            System.out.println("请输入商品的金额");
            price = sc.nextBigDecimal();
        }while (price.compareTo(new BigDecimal(0))<=0);
        int count=0;
        do
            {
                System.out.println("请输入商品数量");
                count = sc.nextInt();
            }while (count<=0);
        // 查询所有的分类
        List<GoodCategory> allCategory = goodCategoryService.findAllCategory();
        allCategory.forEach(System.out::println);
        GoodCategory category;
        do
        {
            System.out.println("请输入商品分类的名字");
            String cname=sc.next();
            category= goodCategoryService.selectByName(cname);
            if (category==null)
            {
                System.out.println("要添加的分类不存在");
            }
        }while (category==null);
        Good good = new Good();
        good.setGname(gname);
        good.setPrice(price);
        good.setCount(count);
        good.setGoodCategory(category);
        try {
            goodService.addGood(good);
            System.out.println("添加成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    public static void updateGoods()
    {
        Scanner sc = new Scanner(System.in);
        findAllGoods();
        System.out.println("请输入要更新商品的id");
        int modifyId = sc.nextInt();
        // 查询出要更新的商品
        Good oldGood = goodService.selectGoodById(modifyId);
        if (oldGood==null)
        {
            System.out.println("要修改的商品不存在");
            return;
        }
        sc.nextLine();
        System.out.println("请输入新的商品名称");
        String newCname = sc.nextLine();
        System.out.println("请输入新的商品的金额");
        BigDecimal price = new BigDecimal(sc.nextLine());
        System.out.println("请输入新的商品数量");
        int count =sc.nextInt();
        CategoryMenu.findAllCategory();
        System.out.println("请输入新的商品分类Id");
        int  cid = sc.nextInt();
        GoodCategory category = new GoodCategory();
        category.setCid(cid);
        Good good = new Good();
        good.setGid(oldGood.getGid());
        good.setGname(newCname);
        good.setPrice(price);
        good.setCount(count);
        good.setGoodCategory(category);
        try {
            goodService.updateGood(good);
            System.out.println("修改成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteGoods()
    {
        Scanner sc = new Scanner(System.in);
        String gname;
        do
        {
            System.out.println("请输入要删除的商品名称");
            gname = sc.nextLine();
        }while (!(gname.length()>=1 && gname.length()<=10));
        try {
            goodService.deleteGood(gname);
            System.out.println("删除成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
       
    }
    

