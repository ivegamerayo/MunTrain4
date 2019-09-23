package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Examtemplate;

public interface ExamtemplateService {
	
	/**
	 * Save a examtemplate
	 * @param examtemplate
	 * @return
	 */
	Examtemplate save(Examtemplate examtemplate);
	
	/**
	 * Get all examtemplates
	 * @return
	 */
	List<Examtemplate> findAll();
	
	/**
	 * Get one examtemplate by id
	 * @param id
	 * @return
	 */
	Optional<Examtemplate> findOne(Long id);
	
	/**
	 * It deletes one examtemplate by id
	 * @param id
	 */
	void delete(Long id);


}
