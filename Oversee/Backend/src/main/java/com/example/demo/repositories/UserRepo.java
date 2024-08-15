package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Userdetails;

public interface UserRepo extends JpaRepository<Userdetails ,Long>{

}
