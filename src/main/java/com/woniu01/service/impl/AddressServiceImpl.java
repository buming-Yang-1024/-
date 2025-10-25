package com.woniu01.service.impl;

import com.woniu01.entity.Address;
import com.woniu01.entity.User;
import com.woniu01.exception.AddressNotExistException;
import com.woniu01.mapper.AddressMapper;
import com.woniu01.mapper.MybatisUtl;
import com.woniu01.service.AddressService;
import com.woniu01.service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * ClassName: AddressServiceImpl
 * Package: com.woniu01.service.impl
 * Description:
 *
 * @Create: 2025/8/15 - 17:47
 * @Version: V1.0
 */
public class AddressServiceImpl implements AddressService {
    private UserService userService = new UserServiceImpl();
    @Override
    public List<Address> findAllAddress() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        List<Address> addressCategories = addressMapper.selectAll();
        sqlSession.close();
        return addressCategories;
    }

    @Override
    public void addAddress(Address address) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        addressMapper.insert(address);
        sqlSession.close();
    }

    @Override
    public void updateAddress(Address address) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        String aname = address.getAname();
        String phone = address.getPhone();
        String email = address.getEmail();
        User user = address.getUser();
        String regex="^([\\u4E00-\\u9FA5]{2,})(?:省|市|自治区|特别行政区|区|县)([\\u4E00-\\u9FA5]{2,})(?:市|自治州|地区|县)([\\u4E00-\\u9FA5]{2,})(?:市|区|县)?([\\u4E00-\\u9FA5]{2,})?(?:街道|镇|乡|街道办事处)?([\\u4E00-\\u9FA5]{2,})?(?:村|社区|居委会)?$";
        if(!aname.matches(regex))
        {
            throw new RuntimeException("地址不符合规范");
        }
        if(!phone.matches("^1\\d{1,10}$"))
        {
            throw new RuntimeException("电话号码不符合规范");
        }
        if(!email.matches("^\\w+@\\w+\\.\\w+$"))
        {
            throw new RuntimeException("邮箱不符合规范");
        }
        User findUser = userService.findByName(user.getUname());
        if(findUser==null)
        {
            throw new RuntimeException("用户不能为空");
        }
        addressMapper.update(address);
        sqlSession.close();
    }

    @Override
    public void deleteAddress(String aname) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Address findAddress = addressMapper.selectByName(aname);
        if(findAddress==null)
        {
            throw new AddressNotExistException("删除的地址不存在");
        }
        addressMapper.deleteByName(aname);
        sqlSession.close();
    }

    @Override
    public void deleteByAid(int aid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        addressMapper.deleteByAid(aid);
        sqlSession.close();
    }

    @Override
    public Address selectByName(String aname) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Address findAddress = addressMapper.selectByName(aname);
        sqlSession.close();
        return findAddress;
    }

    @Override
    public Address selectById(int aid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Address address = addressMapper.selectById(aid);
        return address;
    }

    @Override
    public List<Address> selectByUid(int uid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        List<Address> addresses = addressMapper.selectAddressByUid(uid);
        sqlSession.close();
        return addresses;
    }
}
