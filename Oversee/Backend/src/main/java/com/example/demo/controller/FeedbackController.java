package com.example.demo.controller;

import com.example.demo.entities.FeedbackForm;
import com.example.demo.servimpl.FeedbackImpl;
import com.example.demo.servimpl.UserImpl;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fb")
public class FeedbackController {
    //Send Feedback
    //Get User ID
    //Delete Feedback

    @Autowired
    private FeedbackImpl f;


    @Autowired
    private UserImpl u;

    @GetMapping("/get-all")
    public List<FeedbackForm> getAll(){
        return f.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<FeedbackForm> addfeedback(@RequestBody FeedbackForm fb,@RequestParam Long user){
        fb.setFromName(u.getUser(user).getName());
        FeedbackForm ret = f.addFb(fb);
        return new ResponseEntity<>(ret , HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public String delFeedback(@RequestParam Long fb){
        f.delFb(fb);
        return "Deleted";
    }
}
