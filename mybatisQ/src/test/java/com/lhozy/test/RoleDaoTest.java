package com.lhozy.test;

import com.lhozy.dao.IAccountDao;
import com.lhozy.dao.IRoleDao;
import com.lhozy.domain.Account;
import com.lhozy.domain.Role;
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
import java.util.List;

public class RoleDaoTest {
    private SqlSessionFactoryBuilder factoryBuilder;
    private InputStream is;
    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;
    private IRoleDao mapper;

    @Before
    public void init() throws IOException {
        factoryBuilder = new SqlSessionFactoryBuilder();
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = factoryBuilder.build(is);
        sqlSession = sessionFactory.openSession();
        mapper = sqlSession.getMapper(IRoleDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindRoleAllUser(){
        List<Role> list = mapper.findRoleAlluser();
        for (Role role : list) {
            System.out.println(role);
            System.out.println(role.getUsers());

        }
    }

//    @Test
//    public void testFindById(){
//        Account account = mapper.findById();
//        System.out.println(account);
//    }


}
