package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;



public interface UserService {
	
	/**
	 * Save a user
	 * @param user
	 * @return
	 */
	User save(User user);
	
	/**
	 * Get all users
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * Get one user by id
	 * @param id
	 * @return
	 */
	Optional<User> findOne(Long id);
	
	/**
	 * Get one user by login and password
	 * @param login
	 * @param password
	 * @return
	 */
	Optional <User> login(String login, String password);
	
	/**
	 * It deletes one user by id
	 * @param id
	 */
	void delete(Long id);

}
