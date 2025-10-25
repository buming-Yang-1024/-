package com.woniu01.ui;

import com.woniu01.constance.UserConstance;
import com.woniu01.entity.Orders;
import com.woniu01.service.OrdersService;
import com.woniu01.service.impl.OrdersServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: OrderMenu
 * Package: com.woniu01.ui
 * Description:
 *
 * @Create: 2025/8/16 - 16:50
 * @Version: V1.0
 */
public class OrderMenu {
    private static OrdersService ordersService=new OrdersServiceImpl();
    public static void show()
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag)
        {
            System.out.println("1.查看所有订单");
            System.out.println("2.查询指定用户的订单");
            System.out.println("3.删除订单");
            System.out.println("4.返回");
            int choose = sc.nextInt();
            switch ( choose)
            {
                case 1:
                    System.out.println("查看所有订单");
                    findAllOrders();
                    break;
                case 2:
                    System.out.println("查询指定用户的订单详情");
                    findOrdersByoId();
                    break;
                case 3:
                    System.out.println("删除订单");
                    deleteOrders();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;

            }
        }
    }
    public static void findAllOrders()
    {
        System.out.println("用户"+"\t\t\t"+"总金额"+"\t\t"+"总数量"+"\t\t"+"地址"+"\t\t"+ "电话"+"\t\t"+"邮箱"+"\t\t"+"下单时间");
        try {
            List<Orders> allOrders = ordersService.findAllOrders();
            allOrders.forEach(orders -> {
                System.out.println(orders.getUser().getUname()+"\t\t"+orders.getTotalMoney()+"\t\t"+orders.getTotalCount()
                        +"\t\t"+orders.getAname()+orders.getPhone()+"\t\t"+orders.getEmail()
                        +"\t\t"+orders.getOrderTime());
            });
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void findOrdersByoId()
    {
        Scanner sc = new Scanner(System.in);
        List<Orders> allOrders = ordersService.findAllOrders();
        allOrders.forEach(orders -> {
            System.out.println(orders.getOid()+"\t"+orders.getAname());
        });
        System.out.println("请输入订单号");
        int oid=sc.nextInt();
        try {
            Orders orders = ordersService.selectById(oid);
            System.out.println(orders);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void deleteOrders()
    {
        Scanner sc = new Scanner(System.in);
        List<Orders> allOrders = ordersService.findAllOrders();
        allOrders.forEach(orders -> {
            System.out.println(orders.getOid()+"\t"+orders.getAname());
        });
        System.out.println("请输入要删除地址的id");
        int deleteId=sc.nextInt();
        try {
            ordersService.deleteOrders(deleteId);
            System.out.println("删除成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}

