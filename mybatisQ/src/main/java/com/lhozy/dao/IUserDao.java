package com.lhozy.dao;

import com.lhozy.domain.Conditions;

import com.lhozy.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User findById(Integer id);
    List<User> findByName(String name);
    List<User> findUserByVo(Conditions cons);
    List<User> findByConditions(User user);
    List<User> findByIds(Conditions ids);
    List<User> findUserAllRole();

}
