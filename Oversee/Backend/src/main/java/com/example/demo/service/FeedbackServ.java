package com.example.demo.service;


import com.example.demo.entities.FeedbackForm;

import java.util.List;

public interface FeedbackServ {
    public List<FeedbackForm> getAll();
    public FeedbackForm addFb(FeedbackForm fb);

    public void delFb(Long Id);
}
