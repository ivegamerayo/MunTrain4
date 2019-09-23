package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Response;

public interface ResponseRepository extends JpaRepository <Response, Long>{

}
