package com.hit.hotel.hr.service;

import java.util.List;

import com.hit.hotel.hr.model.User;

public interface IUserService {

    User selectById(int userId);

    int addUser(User user);

    int insertUser(User user);

    int deleteUser(int userId);

    int updateUser(User user);

    Integer getUserCount();

    User selectByUsernameAndPassword(String username, String password);

    User selectByUsername(String username);

    List<User> selectAll();

    List<User> selectAllUser();

}
