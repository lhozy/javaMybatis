package com.lhozy.test;

import com.lhozy.dao.IUserDao;
import com.lhozy.domain.Conditions;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    private SqlSessionFactoryBuilder factoryBuilder;
    private InputStream is;
    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;
    private IUserDao mapper;

    @Before
    public void init() throws IOException {
        factoryBuilder = new SqlSessionFactoryBuilder();
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = factoryBuilder.build(is);
        sqlSession = sessionFactory.openSession();
        mapper = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
    @Test
    public void testFindUserAccountLazy(){
        List<User> users = mapper.findUserAccountLazy();
        for (User user : users) {
            System.out.println("------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindAll(){
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println("------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUserName("aaa");
        user.setAddress("ssssddd");
        user.setSex("男");
        user.setBirthday(new Date());
        mapper.saveUser(user);
    }
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(49);
        user.setUserName("a49");
        user.setAddress("ssssddd");
        user.setSex("男");
        user.setBirthday(new Date());
        mapper.updateUser(user);
    }
    @Test
    public void testDeleteUser(){
        mapper.deleteUser(50);
    }
    @Test
    public void testFindById(){
        User u = mapper.findById(49);
        System.out.println(u);
        User u2 = mapper.findById(49);
        System.out.println(u2);
    }
    @Test
    public void testFindByName(){

        List<User> users = mapper.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindByConditions(){
        User user = new User();
//        user.setUserName("老王");
        user.setSex("女");
        List<User> users = mapper.findByConditions(user);
        for (User u : users) {
            System.out.println(u);
        }
    }
    @Test
    public void testFindByVo(){
        User user = new User();
        user.setUserName("老王");
        Conditions cons = new Conditions();
        cons.setUser(user);
        List<User> users = mapper.findUserByVo(cons);
        for (User u : users) {
            System.out.println(u);
        }
    }
    @Test
    public void testFindByIds(){
        Conditions cons = new Conditions();
        List<Integer> list= new ArrayList<Integer>();
        list.add(46);
        list.add(48);
        list.add(49);
        cons.setIds(list);
        List<User> users = mapper.findByIds(cons);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindUserAllRole(){
        List<User> userAllRole = mapper.findUserAllRole();
        for (User user : userAllRole) {
            System.out.println("---------------");
            System.out.println(user);
            System.out.println(user.getRoles());

        }

    }

}
