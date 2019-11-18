package com.lhozy.dao;

import com.lhozy.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true ,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property = "user",one = @One(select = "com.lhozy.dao.UserMapper.findById",fetchType = FetchType.EAGER)),
    } )
    List<Account> findAll();

    @Select("select * from account where uid = #{uid}")
    List<Account> findByUID(Integer uid);

}
