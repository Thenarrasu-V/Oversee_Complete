package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.FeedbackForm;

public interface Feedbackrepo extends JpaRepository<FeedbackForm ,Long>{

}
