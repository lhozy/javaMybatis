package com.lhozy.dao;

import com.lhozy.domain.Conditions;

import com.lhozy.domain.User;

import java.util.List;

/**
 * User的持久化层
 */
public interface IUserDao {
    /**
     * 查询用户及所有账号信息
     * @return
     */
    List<User> findAll();

    /**
     * 查询用户及所有账号信息 延迟加载
     * @return
     */
    List<User> findUserAccountLazy();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User findById(Integer id);
    List<User> findByName(String name);
    List<User> findUserByVo(Conditions cons);
    List<User> findByConditions(User user);
    List<User> findByIds(Conditions ids);
    List<User> findUserAllRole();
    List<User> findUserAllRoleLazy();

}
