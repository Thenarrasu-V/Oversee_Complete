package com.example.demo.controller;


import com.example.demo.entities.Userdetails;
import com.example.demo.service.UserServ;
import com.example.demo.servimpl.HRImpl;
import com.example.demo.servimpl.ManagerImpl;
import com.example.demo.servimpl.UserImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    //Get By ID
    //Get by ManagerID
    //Get All
    //Create USER

    @Autowired
    private UserImpl u;

    @Autowired
    private HRImpl h;

    @Autowired
    private ManagerImpl m;

    @GetMapping("/get/{Id}")
    public ResponseEntity<Userdetails> getUser(@PathVariable Long Id){
        return ResponseEntity.ok(u.getUser(Id));
    }

    @PostMapping("/add")
    public ResponseEntity<Userdetails> addUser(@RequestBody Userdetails user, @RequestParam Long hr, @RequestParam Long manager){
        user.setRole("employee");
        user.setHr(h.getHR(hr));
        user.setManager(m.getManager(manager));
        Userdetails ret = u.addUser(user);
        return new ResponseEntity<>(ret, HttpStatus.CREATED);
    }
}
