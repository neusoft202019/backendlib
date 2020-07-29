package com.hit.hotel.hr.service;


import java.util.List;

import com.hit.hotel.hr.model.Worker;

public interface IWorkerService {
    int insert(Worker worker);
    int delete(int workerId);
    int updateById(Worker worker);
    Worker selectById(int workerId);
    Worker selectByUsername(String username);
    List<Worker> findAll();
    List<Worker> selectByRole(String role);
    Worker login(String username,String password,String role);
    Worker login(String username,String password);
}
