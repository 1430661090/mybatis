package com.mycode.mybatis.junit;

import com.mycode.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyFirstTest {

    @Test
    public void testMybatis() throws IOException {

        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("findUserById", 10);
        System.out.println(user);

    }

    @Test
    public void testMybatis1() throws IOException {

        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("findUserByUsername", "五");
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testMybatis2() throws IOException {

        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("小明");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("北京");

        int insertUser = sqlSession.insert("insertUser", user);
        sqlSession.commit();

    }
}
