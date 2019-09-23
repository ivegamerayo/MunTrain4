package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Examtemplate;

public interface ExamtemplateRepository extends JpaRepository <Examtemplate, Long> {
	
}
