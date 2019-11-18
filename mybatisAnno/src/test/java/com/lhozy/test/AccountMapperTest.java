package com.lhozy.test;

import com.lhozy.dao.AccountMapper;
import com.lhozy.dao.UserMapper;
import com.lhozy.domain.Account;
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

public class AccountMapperTest {
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private InputStream is;
    private AccountMapper mapper;

    @Before
    public void init() throws IOException {
        builder = new SqlSessionFactoryBuilder();
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = builder.build(is);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(AccountMapper.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindByUID(){
        List<Account> list = mapper.findByUID(41);
        for (Account account : list) {

            System.out.println(account);
        }
    }
    @Test
    public void testFindAll(){
        List<Account> list = mapper.findAll();
        for (Account account : list) {
            System.out.println("----------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
