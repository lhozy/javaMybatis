package com.lhozy.dao;

import com.lhozy.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();
    List<Account> findAccountByUID(Integer uid);
    Account findById();
}
