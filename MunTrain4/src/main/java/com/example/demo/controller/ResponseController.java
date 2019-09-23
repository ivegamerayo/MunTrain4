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

import com.example.demo.model.Response;
import com.example.demo.service.QuestionService;
import com.example.demo.service.ResponseService;

@Controller
public class ResponseController {
	
	private final Logger log = LoggerFactory.getLogger(ResponseController.class);

	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private QuestionService questionService;


	@GetMapping("/responses")
	public ModelAndView getAllResponses() {
		log.debug("request to get Responses");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("response-form");
		mav.addObject("responses", responseService.findAll());
		return mav;
	}

	@GetMapping("/responses/empty")
	public ModelAndView createResponse() {
		log.debug("request to empty response form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("response-form");
		mav.addObject("response", new Response());
		mav.addObject("questions", questionService.findAll());
		return mav;
	}
	
	/**
	 * GET /responses/:id : get the "id" response.
	 *
	 * @param id the id of the response to retrieve
	 * @return
	 */
	@GetMapping("/responses/{id}")
	public ModelAndView getResponse(@PathVariable Long id) {
		log.debug("request to get Response : {}", id);
		Optional<Response> response = responseService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (response.isPresent()) {
			mav.setViewName("response-form");
			mav.addObject("response", response.get());
			mav.addObject("questions", questionService.findAll());
		} else {
			mav.setViewName("examtemplate-list");
			mav.addObject("message", "Response not found");
		}

		return mav;
	}

	/**
	 * GET /responses/:id : get the "id" response.
	 *
	 * @param id the id of the response to retrieve
	 * @return
	 */
	@PostMapping("/responses")
	public String saveResponse(@ModelAttribute("response") Response response) {
		log.debug("request to save Response : {}", response);

		// El responseo no existe y tenemos que crearlo
		if (response.getId() == null) {
			responseService.save(response);
			return "redirect:/responses/empty";
		}

		// El responseo ya existe y tenemos que actualizarlo
		Optional<Response> existingResponseWrap = responseService.findOne(response.getId());
		if (existingResponseWrap.isPresent()) {
			
			Response existingResponse = existingResponseWrap.get();
			existingResponse.setDescriptionR(response.getDescriptionR());
			existingResponse.setImage(response.getImage());
			existingResponse.setValue(response.getValue());
			existingResponse.setQuestion(response.getQuestion());
			//existingResponse.setDate(response.getDate());
			responseService.save(existingResponse);
		}
		return "redirect:/responses/empty";
	}

	/**
	 * /responses/:id/delete : delete the "id" response.
	 *
	 * @param id the id of the response to delete
	 * @return
	 */
	@GetMapping("/responses/{id}/delete")
	public String deleteResponse(@PathVariable Long id) {
		log.debug("request to delete Response : {}", id);
		responseService.delete(id);
		return "redirect:/responses" ;
	}

}
