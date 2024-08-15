package com.example.demo.servimpl;

import com.example.demo.entities.Managerdetails;
import com.example.demo.repositories.ManagerRepo;
import com.example.demo.service.ManagerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerImpl implements ManagerServ {

    @Autowired
    private ManagerRepo m;

    @Override
    public Managerdetails getManager(Long Id){
        return m.findById(Id).orElse(null);
    }

    @Override
    public Managerdetails addManager(Managerdetails manager){
        return m.save(manager);
    }
}
