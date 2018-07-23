package com.revature.caliber.controllers;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Question;
import com.revature.caliber.services.QuestionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/questions")
@CrossOrigin
@ComponentScan("com.revature.caliber.*")
public class QuestionController {

	@Autowired
	private QuestionService qs;

	
	/**
	 * 
	 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
	 * @author Joanel Vasquez | 1803-USF-MAR26 | Wezley Singleton
	 * @author Ethan Conner	  | 1805-WV -AUG3  | Richard Orr
	 * 
	 * @param question
	 * @return question with ID to Janus
	 */
	@ApiOperation(value = "Adds a new Question", response = Question.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		return new ResponseEntity<>(this.qs.create(question), HttpStatus.CREATED);
	}
	
	
}