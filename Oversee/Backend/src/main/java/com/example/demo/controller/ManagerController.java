package com.example.demo.controller;

import com.example.demo.entities.HRdetails;
import com.example.demo.entities.Managerdetails;
import com.example.demo.servimpl.HRImpl;
import com.example.demo.servimpl.ManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/manager")

public class ManagerController {
    //Get By ID
    //Get Teams
    //Create Manager

    @Autowired
    private ManagerImpl m;

    @Autowired
    private HRImpl h;

    @GetMapping("/get/{Id}")
    public ResponseEntity<Managerdetails> getManager(@PathVariable Long Id) {
        return ResponseEntity.ok(m.getManager(Id));
    }

    @PostMapping("/add")
    public ResponseEntity<Managerdetails> addManager(@RequestBody Managerdetails manager, @RequestParam Long hr){
        manager.setRole("manager");
        manager.setHr(h.getHR(hr));
        Managerdetails ret = m.addManager(manager);
        return new ResponseEntity<>(ret, HttpStatus.CREATED);
    }
}
