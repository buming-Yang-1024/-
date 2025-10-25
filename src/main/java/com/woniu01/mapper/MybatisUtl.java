package com.woniu01.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: MybatisUtl
 * Package: com.woniu01.mapper
 * Description:
 *
 * @Create: 2025/8/14 - 11:20
 * @Version: V1.0
 */
public class MybatisUtl {
    private static final SqlSessionFactory sqlSessionFactory;
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream   inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static SqlSession getSqlSession()
    {

        return sqlSessionFactory.openSession(true);
    }
    public static SqlSession getNotCmtSqlSession()
    {

        return sqlSessionFactory.openSession(false);
    }
}
