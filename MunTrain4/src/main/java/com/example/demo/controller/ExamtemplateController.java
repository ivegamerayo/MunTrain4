package com.example.demo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Examtemplate;
import com.example.demo.service.ExamtemplateService;





@Controller
public class ExamtemplateController {
	
	private final Logger log = LoggerFactory.getLogger(ExamtemplateController.class);

	@Autowired
	private ExamtemplateService examtemplateService;

	/*
	 * @Autowired private QuestionService questionService;
	 */

	@GetMapping("/examtemplates")
	public ModelAndView getAllExamtemplates() {
		log.debug("request to get Examtemplates");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("examtemplate-list");
		mav.addObject("examtemplates", examtemplateService.findAll());
		return mav;
	}

	@GetMapping("/examtemplates/empty")
	public ModelAndView createExamtemplate() {
		log.debug("request to empty examtemplate form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("examtemplate-edit");
		mav.addObject("examtemplate", new Examtemplate());
		return mav;
	}
	
	/**
	 * GET /examtemplates/:id : get the "id" examtemplate.
	 *
	 * @param id the id of the examtemplate to retrieve
	 * @return
	 */
	@GetMapping("/examtemplates/{id}")
	public ModelAndView getExamtemplate(@PathVariable Long id) {
		log.debug("request to get Examtemplate : {}", id);
		Optional<Examtemplate> examtemplate = examtemplateService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (examtemplate.isPresent()) {
			mav.setViewName("examtemplate-edit");
			mav.addObject("examtemplate", examtemplate.get());
		} else {
			mav.setViewName("examtemplate-list");
			mav.addObject("message", "Examtemplate not found");
		}

		return mav;
	}

	
	/**
	 * GET /examtemplates/:id : get the "id" examtemplate.
	 *
	 * @param id the id of the examtemplate to retrieve
	 * @return
	 */
	@PostMapping("/examtemplates")
	public String saveExamtemplate(@ModelAttribute("examtemplate") Examtemplate examtemplate) {
		log.debug("request to save Examtemplate : {}", examtemplate);
		
		// El examtemplateo no existe y tenemos que crearlo
		if (examtemplate.getId() == null) {
			examtemplateService.save(examtemplate);
			return "redirect:/examtemplates";
		}

		// El examtemplate ya existe y tenemos que actualizarlo
			Optional<Examtemplate> existingExamtemplateWrap = examtemplateService.findOne(examtemplate.getId());
			if (existingExamtemplateWrap.isPresent()) {
				Examtemplate existingExamtemplate = existingExamtemplateWrap.get();
				existingExamtemplate.setDescriptionET(examtemplate.getDescriptionET());
				existingExamtemplate.setPublisher(examtemplate.getPublisher());
				existingExamtemplate.setQuestion(examtemplate.getQuestion());
				examtemplateService.save(existingExamtemplate);
			}
		
		return "redirect:/examtemplates";
	}

	/**
	 * /examtemplates/:id/delete : delete the "id" examtemplate.
	 *
	 * @param id the id of the examtemplate to delete
	 * @return
	 */
	@GetMapping("/examtemplates/{id}/delete")
	public String deleteExamtemplate(@PathVariable Long id) {
 		log.debug("request to delete Examtemplate : {}", id);
		examtemplateService.delete(id);
		return "redirect:/examtemplates" ;
	}
	

}
