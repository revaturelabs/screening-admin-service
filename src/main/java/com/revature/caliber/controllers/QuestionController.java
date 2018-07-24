package com.revature.caliber.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import com.revature.caliber.beans.Question;
import com.revature.caliber.services.QuestionService;

import io.swagger.annotations.ApiOperation;

/**
 * Controller that handles mapping for all of the methods for question manipulation
 * 
 * @author Alexia Doramus| 1803-USF-MAR26 | Wezley Singleton
 * @author Richard Vo	 | 1803-USF-MAR26 | Wezley Singleton
 * @author Ethan Conner  | 1805-WVU | Richard Orr
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */

@RestController
@RequestMapping("/questions")
@CrossOrigin
@ApiModel(value = "QuestionController", description = "A rest controller to handle HTTP Requests made to /questions")
public class QuestionController {

	@Autowired
	private QuestionService qs;

	
	/**
	 * 
	 * @param bucketId - Id of bucket
	 * @return List of questions associated with bucket of given id
	 * @author Isaac Pawling | 1805-WVU | Richard Orr
	 */
	@GetMapping("/bucket/{bucketId}")
	@ApiOperation(value = "Find list of Questions by bucketId",
		notes = "Each question belongs to a particular bucket that classifies subject matter",
	    response = Question.class,
	    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Response is empty is bucketId is not found") } )
	public ResponseEntity<List<Question>> getBucketQuestions(@PathVariable(value="bucketId") Integer bucketId) {
		return new ResponseEntity<>(qs.getQuestionsByBucket(bucketId), HttpStatus.OK);
	}
	
	/**
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
