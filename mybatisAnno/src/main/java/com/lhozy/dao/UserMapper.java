package com.lhozy.dao;

import com.lhozy.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有用户及账户信息
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "id",property = "accounts",many = @Many(select = "com.lhozy.dao.AccountMapper.findByUID",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
//    @ResultType(User.class)
    @ResultMap("userMap")
    List<User> findUserAll();
    /**
     * 根据用户ID查找
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findById(Integer id);

    /**
     * 新增用户
     * @param user
     */
    @Insert("INSERT INTO user (username,address,sex,birthday) VALUES (#{userName},#{userAddress},#{userSex},#{userBirthday})")
    void save(User user);

    /**
     * 更改用户
     * @param user
     */
    @Update("update user set username = #{userName},address = #{userAddress},sex = #{userSex}," +
            "birthday = #{userBirthday} where id = #{userId}")
    void update(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("DELETE FROM user WHERE id = #{userId}")
    void delete(Integer id);

}
