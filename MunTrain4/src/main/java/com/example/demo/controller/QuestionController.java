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

import com.example.demo.model.Question;
import com.example.demo.service.ExamtemplateService;
import com.example.demo.service.QuestionService;

@Controller
public class QuestionController {

	private final Logger log = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ExamtemplateService examtemplateService;

	//No se usa este método para simplificar las vistas
	/* 
	 * @GetMapping("/questions") public ModelAndView getAllQuestions() {
	 * log.debug("request to get Questions"); ModelAndView mav = new ModelAndView();
	 * mav.setViewName("question-list"); mav.addObject("questions",
	 * questionService.findAll()); return mav; }
	 */

	@GetMapping("/questions/empty")
	public ModelAndView createQuestion() {
		log.debug("request to empty question form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("question-form");
		mav.addObject("question", new Question());
		mav.addObject("examtemplates", examtemplateService.findAll());
		return mav;
	}

	/**
	 * GET /questions/:id : get the "id" question related to a specific template
	 *
	 * @param id of the question to retrieve
	 * @return
	 */
	@GetMapping("/questionstemplate/{id}") 
	public ModelAndView getReleatedQuestions(@PathVariable Long id) {
		log.debug("request to get Question : {}", id);
		Optional<Question> question = questionService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (question.isPresent()) {
			mav.setViewName("question-one");
			mav.addObject("question", question.get());
		} else {
			mav.setViewName("examtemplate-list");
			mav.addObject("message", "Question not found");
		}

		return mav;
	}	


	/**
	 * GET /questions/:id : get the "id" question.
	 *
	 * @param id the id of the question to retrieve
	 * @return
	 */
	@GetMapping("/questions/{id}")
	public ModelAndView getQuestion(@PathVariable Long id) {
		log.debug("request to get Question : {}", id);
		Optional<Question> question = questionService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (question.isPresent()) {
			mav.setViewName("question-form");
			mav.addObject("question", question.get());
			mav.addObject("examtemplates", examtemplateService.findAll());
		} else {
			mav.setViewName("question-list");
			mav.addObject("message", "Question not found");
		}

		return mav;
	}
	
	
	@PostMapping("/questions")
	public String saveQuestion(@ModelAttribute("question") Question question) {
		log.debug("request to save Question : {}", question);

		// El questiono no existe y tenemos que crearlo
		if (question.getId() == null) {
			questionService.save(question);
			return "redirect:/responses/empty";
		}

		// El questiono ya existe y tenemos que actualizarlo
		Optional<Question> existingQuestionWrap = questionService.findOne(question.getId());
		if (existingQuestionWrap.isPresent()) {

			Question existingQuestion = existingQuestionWrap.get();
			existingQuestion.setDescription(question.getDescription());
			existingQuestion.setExamtemplate(question.getExamtemplate());
			questionService.save(existingQuestion);
		}
		return "redirect:/responses/empty";
	}

	/**
	 * /questions/:id/delete : delete the "id" question.
	 *
	 * @param id the id of the question to delete
	 * @return
	 */
	@GetMapping("/questions/{id}/delete")
	public String deleteQuestion(@PathVariable Long id) {
		log.debug("request to delete Question : {}", id);
		questionService.delete(id);
		return "redirect:/examtemplates";
	}
	

}
