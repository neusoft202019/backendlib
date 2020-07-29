package com.hit.hotel.hr.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.hit.hotel.hr.model.User;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer getUserCount();

    User selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    User selectByUsername(String username);

    List<User> selectAll();

    List<User> selectAllUser();
}