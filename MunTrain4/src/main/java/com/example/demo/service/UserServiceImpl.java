package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {


	
	    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	    
		@Autowired
		private UserRepository userRepository;
		
		@Override
		public User save(User user) {
	        log.debug("Request to save User : {}", user);
	        return userRepository.save(user);
		}

		@Override
		public List<User> findAll() {
	        log.debug("Request to get all Users");
	        return userRepository.findAll();
		}

		@Override
		public Optional<User> findOne(Long id) {
	        log.debug("Request to get User : {}", id);
	        return userRepository.findById(id);
		}

		@Override
		public void delete(Long id) {
	        log.debug("Request to delete User : {}", id);
	        userRepository.deleteById(id);
		}

		@Override
		public Optional<User> login(String login, String password) {
			// TODO Auto-generated method stub
			log.debug("Request to get Login User : {}", login, password);
	        return userRepository.findAllActiveUsers(login, password);
		}

	}

