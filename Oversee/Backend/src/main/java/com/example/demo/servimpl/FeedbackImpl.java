package com.example.demo.servimpl;

import com.example.demo.entities.FeedbackForm;
import com.example.demo.repositories.Feedbackrepo;
import com.example.demo.service.FeedbackServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackImpl implements FeedbackServ {

    @Autowired
    private Feedbackrepo f;

    @Override
    public List<FeedbackForm> getAll(){
        return f.findAll();
    }

    @Override
    public FeedbackForm addFb(FeedbackForm fb){
        return f.save(fb);
    }

    @Override
    public void delFb(Long Id){
        f.deleteById(Id);
    }
}
