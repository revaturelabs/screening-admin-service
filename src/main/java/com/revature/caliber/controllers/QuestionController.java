package com.revature.caliber.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.revature.caliber.beans.Question;
import com.revature.caliber.services.QuestionService;


/**
 * Controller that handles mapping for all of the methods for question manipulation
 * 
 * @author Alexia Doramus| 1803-USF-MAR26 | Wezley Singleton
 * @author Richard Vo	 | 1803-USF-MAR26 | Wezley Singleton
 * @author Ethan Conner  | 1805-WVU | Richard Orr
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 * @author Adil Iqbal    | 1805-WVU | Richard Orr
 */

@RestController
@ApiModel(value = "QuestionController", description = "A rest controller to handle HTTP Requests that return questions")
public class QuestionController {

	@Autowired
	private QuestionService qs;

	/**
	 * 
	 * @return list of all questions
	 */
	@ApiOperation(value="Get all questions",
			response = Question.class,
		    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All questions returned") } )
	@GetMapping("/question")
	public ResponseEntity<List<Question>> getQuestions() {
		return new ResponseEntity<>(qs.getAllQuestions(), HttpStatus.OK);
	}	
	
	/**
	 * 
	 * @param bucketId - Id of bucket
	 * @return List of questions associated with bucket of given id
	 */
	@ApiOperation(value = "Find list of Questions by bucketId",
		notes = "Each question belongs to a particular bucket that classifies subject matter",
	    response = Question.class,
	    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Response is empty if bucketId is not found") } )
	@GetMapping("/bucket/{bucketId}/question")
	public ResponseEntity<List<Question>> getBucketQuestions(@PathVariable(value="bucketId") Integer bucketId) {
		return new ResponseEntity<>(qs.getQuestionsByBucket(bucketId), HttpStatus.OK);
	}
	
	/**
	 * @param question Question object to add to the database
	 * @return Question List and http status code 201
	 */
	@ApiOperation(value = "Adds a new Question", response = Question.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "New question created") } )
	@PostMapping(value = "/question" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		return new ResponseEntity<>(this.qs.create(question), HttpStatus.CREATED);
	}
	
	/**
	 * Updates a number of fields for a specific question
	 * @param question - question w/ supposedly updated fields
	 * @return updated question and http status code 200
	 */
	@ApiOperation(value = "Updates question", response = Question.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Question updated") } )
	@PutMapping(value = "/question/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> updateQuestion(@Valid @RequestBody Question question) {
		qs.updateQuestion(question);
		return new ResponseEntity<>(question, HttpStatus.OK);
	}
	
	/**
	 * Removes a question from the DB, if found
	 * @param questionId - id of question to remove
	 * @return http status code 200
	 */
	@ApiOperation(value = "Deletes a question")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Question deleted") } )
	@DeleteMapping("/question/{id}")
	public ResponseEntity<Void> deleteByQuestionId(@PathVariable(value="id") Integer questionId) {
		qs.deleteByQuestionId(questionId);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	/**
	 * Toggles question isActive status
	 * @param questionId - id of question to remove
	 * @return http status code 204
	 */
	@ApiOperation(value = "Sets Question to active state")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Question activated") } )
	@PutMapping("/question/{id}/activate")
	public ResponseEntity<Void> activateQuestion(@PathVariable(value="id") Integer questionId) {
		qs.toggleQuestionStatus(true, questionId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Toggles question isActive status
	 * @param questionId - id of question to remove
	 * @return http status code 204
	 */
	@ApiOperation(value = "Sets Question to inactive status", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Question deactivated") } )
	@PutMapping("/question/{id}/deactivate")
	public ResponseEntity<Void> deactivateQuestion(@PathVariable(value="id") Integer questionId) {
		qs.toggleQuestionStatus(false, questionId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
