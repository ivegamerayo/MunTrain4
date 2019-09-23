package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Examtemplate;
import com.example.demo.repository.ExamtemplateRepository;

@Service
public class ExamtemplateServiceImpl implements ExamtemplateService {
	
	private final Logger log = LoggerFactory.getLogger(ExamtemplateServiceImpl.class);

    
	@Autowired
	private ExamtemplateRepository examtemplateRepository;
	
	@Override
	public Examtemplate save(Examtemplate examtemplate) {
        log.debug("Request to save Examtemplate : {}", examtemplate);
        return examtemplateRepository.save(examtemplate);
	}

	@Override
	public List<Examtemplate> findAll() {
        log.debug("Request to get all Examtemplates");
        return examtemplateRepository.findAll();
	}

	@Override
	public Optional<Examtemplate> findOne(Long id) {
        log.debug("Request to get Examtemplate : {}", id);
        return examtemplateRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Examtemplate : {}", id);
        examtemplateRepository.deleteById(id);
	}

}
