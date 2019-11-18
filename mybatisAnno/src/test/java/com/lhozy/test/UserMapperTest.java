package com.lhozy.test;

import com.lhozy.dao.UserMapper;
import com.lhozy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserMapperTest {
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private InputStream is;
    private UserMapper mapper;

    @Before
    public void init() throws IOException {
        builder = new SqlSessionFactoryBuilder();
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = builder.build(is);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
    @Test
    public void testFindUserAll(){
        List<User> users = mapper.findUserAll();
        for (User user : users) {
            System.out.println("--------");
            System.out.println(user);

        }
    }
    @Test
    public void testFindAll(){
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println("--------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void testFindById(){
        User user = mapper.findById(41);
        System.out.println(user);
    }
    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("save2");
        user.setUserAddress("asd2");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        mapper.save(user);

    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserId(63);
        user.setUserName("s33");
        user.setUserAddress("a33");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        mapper.update(user);

    }
}
