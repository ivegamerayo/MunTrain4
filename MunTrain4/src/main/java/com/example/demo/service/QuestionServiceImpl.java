package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	private final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);

    
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question save(Question question) {
        log.debug("Request to save Question : {}", question);
        return questionRepository.save(question);
	}

	@Override
	public List<Question> findAll() {
        log.debug("Request to get all Questions");
        return questionRepository.findAll();
	}

	@Override
	public Optional<Question> findOne(Long id) {
        log.debug("Request to get Question : {}", id);
        return questionRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Question : {}", id);
        questionRepository.deleteById(id);
	}


}
