package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Question;


public interface QuestionRepository extends JpaRepository <Question, Long> {
	
	/*
	 * @Query("DELETE q FROM Question q where q.id_examtemplate = :id_examtemplate") void deleteAll(Long id_examtemplate);
	 */
	
	/*
	 * @Query("SELECT q FROM Question q WHERE q.id_examtemplate = :id_examtemplate")
	 * List<Question> findActiveQuestion(@Param("id_examtemplate")Long id);
	 */

}
