package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Question;

public interface QuestionService {

	/**
	 * Save a question
	 * 
	 * @param question
	 * @return
	 */
	Question save(Question question);

	/**
	 * Get all questions
	 * 
	 * @return
	 */
	List<Question> findAll();


	/**
	 * Get one question by id
	 * 
	 * @param id
	 * @return
	 */

	Optional<Question> findOne(Long id);

	/**
	 * It deletes one question by id
	 * 
	 * @param id
	 */
	void delete(Long id);
	

}
