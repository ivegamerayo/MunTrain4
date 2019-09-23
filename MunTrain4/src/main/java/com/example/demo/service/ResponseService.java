package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Response;

public interface ResponseService {
	
	/**
	 * Save a response
	 * @param response
	 * @return
	 */
	Response save(Response response);
	
	/**
	 * Get all responses
	 * @return
	 */
	List<Response> findAll();
	
	/**
	 * Get one response by id
	 * @param id
	 * @return
	 */
	Optional<Response> findOne(Long id);
	
	/**
	 * It deletes one response by id
	 * @param id
	 */
	void delete(Long id);


}
