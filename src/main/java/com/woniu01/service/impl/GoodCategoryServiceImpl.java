package com.woniu01.service.impl;

import com.woniu01.entity.GoodCategory;
import com.woniu01.exception.GoodCategoryExistException;
import com.woniu01.exception.GoodCategoryNotExistException;
import com.woniu01.mapper.GoodCategoryMapper;
import com.woniu01.mapper.MybatisUtl;
import com.woniu01.mapper.UserMapper;
import com.woniu01.service.GoodCategoryService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * ClassName: GoodCategoryServiceImpl
 * Package: com.woniu01.service.impl
 * Description:
 *
 * @Create: 2025/8/15 - 17:47
 * @Version: V1.0
 */
public class GoodCategoryServiceImpl implements GoodCategoryService {
    @Override
    public List<GoodCategory> findAllCategory() {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodCategoryMapper goodCategoryMapper = sqlSession.getMapper(GoodCategoryMapper.class);
        List<GoodCategory> goodCategories = goodCategoryMapper.selectAll();
        sqlSession.close();
        return goodCategories;
    }

    @Override
    public void addCategory(GoodCategory goodCategory) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodCategoryMapper goodCategoryMapper = sqlSession.getMapper(GoodCategoryMapper.class);
        GoodCategory findGoodCategory = goodCategoryMapper.selectByName(goodCategory.getCname());
        if(findGoodCategory!=null)
        {
            throw new GoodCategoryExistException("该分类已存在");
        }
        goodCategoryMapper.insert(goodCategory);
        sqlSession.close();
    }

    @Override
    public void updateCategory(GoodCategory goodCategory) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodCategoryMapper goodCategoryMapper = sqlSession.getMapper(GoodCategoryMapper.class);
        GoodCategory findGoodCategory = goodCategoryMapper.selectById(goodCategory.getCid());
        if(findGoodCategory==null)
        {
            throw new GoodCategoryNotExistException("更新的分类不存在");
        }
        goodCategoryMapper.update(goodCategory);
        sqlSession.close();
    }

    @Override
    public void deleteCategory(String cname) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodCategoryMapper goodCategoryMapper = sqlSession.getMapper(GoodCategoryMapper.class);
        GoodCategory findGoodCategory = goodCategoryMapper.selectByName(cname);
        if(findGoodCategory==null)
        {
            throw new GoodCategoryNotExistException("删除的分类不存在");
        }
        goodCategoryMapper.deleteByName(cname);
        sqlSession.close();
    }

    @Override
    public GoodCategory selectByName(String cname) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodCategoryMapper goodCategoryMapper = sqlSession.getMapper(GoodCategoryMapper.class);
        GoodCategory findGoodCategory = goodCategoryMapper.selectByName(cname);
        sqlSession.close();
        return findGoodCategory;
    }

    @Override
    public GoodCategory selectById(int cid) {
        SqlSession sqlSession = MybatisUtl.getSqlSession();
        GoodCategoryMapper goodCategoryMapper = sqlSession.getMapper(GoodCategoryMapper.class);
        GoodCategory category = goodCategoryMapper.selectById(cid);
        sqlSession.close();
        return category;
    }
}
