package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Response;
import com.example.demo.repository.ResponseRepository;

@Service
public class ResponseServiceImpl implements ResponseService {
	
	private final Logger log = LoggerFactory.getLogger(ResponseServiceImpl.class);

    
	@Autowired
	private ResponseRepository responseRepository;
	
	@Override
	public Response save(Response response) {
        log.debug("Request to save Response : {}", response);
        return responseRepository.save(response);
	}

	@Override
	public List<Response> findAll() {
        log.debug("Request to get all Responses");
        return responseRepository.findAll();
	}

	@Override
	public Optional<Response> findOne(Long id) {
        log.debug("Request to get Response : {}", id);
        return responseRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Response : {}", id);
        responseRepository.deleteById(id);
	}

}
