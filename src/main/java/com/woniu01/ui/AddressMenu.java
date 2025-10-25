package com.woniu01.ui;

import com.woniu01.constance.UserConstance;
import com.woniu01.entity.Address;
import com.woniu01.service.AddressService;
import com.woniu01.service.impl.AddressServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: AddressMenu
 * Package: com.woniu01.ui
 * Description:
 *
 * @Create: 2025/8/18 - 9:24
 * @Version: V1.0
 */
public class AddressMenu {
    private static AddressService addressService=new AddressServiceImpl();
    public static void show() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag)
        {
            System.out.println("1.查看地址");
            System.out.println("2.添加地址");
            System.out.println("3.修改地址");
            System.out.println("4.删除地址");
            System.out.println("5.返回");
            int choose = sc.nextInt();
            switch ( choose)
                {
                    case 1:
                        System.out.println("查看地址");
                        findAllAddress();
                        break;
                    case 2:
                        System.out.println("添加地址");
                        addAddress();
                        break;
                    case 3:
                        System.out.println("修改地址");
                        updateAddress();
                        break;
                    case 4:
                        System.out.println("删除地址");
                        deleteAddress();
                        break;
                    case 5:
                        flag = false;
                        break;
                }
        }
      
     
    }
    public static void findAllAddress()
    {
        System.out.println("地址"+"\t\t"+"用户名"+"\t\t"+"电话"+"\t\t"+"邮箱");
        List<Address> allAddress = addressService.findAllAddress();
        allAddress.forEach(address -> {
            System.out.println(address.getAname()+"\t\t"+address.getUser().getUname()+"\t\t"+address.getPhone()+"\t\t"+address.getEmail());
        });
    }
    public static void addAddress()
    {
        Scanner sc = new Scanner(System.in);
        String aname;
        String regex="^([\\u4E00-\\u9FA5]{2,})(?:省|市|自治区|特别行政区|区|县)([\\u4E00-\\u9FA5]{2,})(?:市|自治州|地区|县)([\\u4E00-\\u9FA5]{2,})(?:市|区|县)?([\\u4E00-\\u9FA5]{2,})?(?:街道|镇|乡|街道办事处)?([\\u4E00-\\u9FA5]{2,})?(?:村|社区|居委会)?$";
        do
        {
            System.out.println("请输入地址");
            aname = sc.nextLine();
        }while (!aname.matches(regex));
        String phone;
        do {
            System.out.println("请输入电话");
            phone=sc.nextLine();
        }while (!phone.matches("^1\\d{1,10}$"));
        String email;
        do {
            System.out.println("请输入邮箱");
            email=sc.nextLine();
        }while (!email.matches("^\\w+@\\w+\\.\\w+$"));
        Address address = new Address();
        address.setAname(aname);
        address.setPhone(phone);
        address.setEmail(email);
        address.setUser(UserConstance.loginUser);
        try {
            addressService.addAddress(address);
            System.out.println("添加成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    public static void updateAddress()
    {
        // 可以修改任意用户的地址
        List<Address> allAddress = addressService.findAllAddress();
        allAddress.forEach(address -> {
            System.out.println(address.getAid()+"\t"+address.getAname());
        });
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择要修改地址的id");
        int modifyId=sc.nextInt();
        sc.nextLine();
        System.out.println("请输入新的地址");
        String aname=sc.nextLine();
        System.out.println("请输入新的电话号码");
        String phone=sc.nextLine();
        System.out.println("请输入新的邮箱");
        String email=sc.nextLine();
        Address address = new Address();
        address.setAid(modifyId);
        address.setAname(aname);
        address.setPhone(phone);
        address.setEmail(email);
        address.setUser(UserConstance.loginUser);
        try {
            addressService.updateAddress(address);
            System.out.println("修改成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteAddress()
    {
        Scanner sc = new Scanner(System.in);
        List<Address> allAddress = addressService.findAllAddress();
        allAddress.forEach(address -> {
            System.out.println(address.getAid()+"\t"+address.getAname());
        });
        System.out.println("请输入要删除地址的id");
        int deleteId=sc.nextInt();
        try {
            addressService.deleteByAid(deleteId);
            System.out.println("删除成功");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
