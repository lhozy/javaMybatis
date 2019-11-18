package com.lhozy.test;

import com.lhozy.dao.IAccountDao;
import com.lhozy.dao.IUserDao;
import com.lhozy.domain.Account;
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

public class AccountDaoTest {
    private SqlSessionFactoryBuilder factoryBuilder;
    private InputStream is;
    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;
    private IAccountDao mapper;

    @Before
    public void init() throws IOException {
        factoryBuilder = new SqlSessionFactoryBuilder();
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = factoryBuilder.build(is);
        sqlSession = sessionFactory.openSession();
        mapper = sqlSession.getMapper(IAccountDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = mapper.findAll();
        for (Account account : accounts) {
            System.out.println("----------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindById(){
        Account account = mapper.findById();
        System.out.println(account);
    }


}
