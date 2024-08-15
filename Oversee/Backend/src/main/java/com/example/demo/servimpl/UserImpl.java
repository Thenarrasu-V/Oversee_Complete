package com.example.demo.servimpl;

import com.example.demo.entities.Userdetails;
import com.example.demo.repositories.UserRepo;
import com.example.demo.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserServ {

    @Autowired
    private UserRepo r;
    @Override
    public Userdetails getUser(Long Id) {
        return r.findById(Id).orElse(null);
    }

    @Override
    public Userdetails addUser(Userdetails user){
        return r.save(user);
    }
}
