package com.woniu01.mapper;

import com.woniu01.entity.Good;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ClassName: GoodMapperTest
 * Package: com.woniu01.mapper
 * Description:
 *
 * @Author: LZ
 * @Create: 2025/8/16 - 14:54
 * @Version: V1.0
 */
public class GoodMapperTest {

    @Test
    public void selectAll() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper mapper = sqlSession.getMapper(GoodMapper.class);
        List<Good> goods = mapper.selectAll();
        System.out.println(goods);
    }

    @Test
    public void selectByName() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper mapper = sqlSession.getMapper(GoodMapper.class);
        Good aphone = mapper.selectByName("aphone");
        System.out.println(aphone);
    }

    @Test
    public void selectByIdBatch() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodMapper mapper = sqlSession.getMapper(GoodMapper.class);
        List<Integer> ids=new ArrayList<>();
        Collections.addAll(ids,1,2,4);
        List<Good> goods = mapper.selectByIdBatch(ids);
        System.out.println(goods);
    }
}