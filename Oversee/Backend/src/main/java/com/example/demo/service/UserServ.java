package com.example.demo.service;

import com.example.demo.entities.Userdetails;


public interface UserServ {
    public Userdetails getUser(Long Id);
    public Userdetails addUser(Userdetails user);
}
