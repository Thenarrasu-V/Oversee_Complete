package com.example.demo.service;

import com.example.demo.entities.Managerdetails;

public interface ManagerServ {
    public Managerdetails getManager(Long Id);

    public Managerdetails addManager(Managerdetails manager);
}
