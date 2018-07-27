package com.revature.caliber.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Question;
import com.revature.caliber.services.QuestionService;

import io.swagger.annotations.ApiOperation;

/**
 * Controller that handles mapping for all of the methods for question manipulation
 * 
 * @author Ethan Conner  | 1805-WVU | Richard Orr
 * @author Adil Iqbal	  | 1805-WVU -MAY29  | Richard Orr
 * 
 */

@RestController
@CrossOrigin
public class QuestionController {
	@Autowired
	private QuestionService qs;

	
	/**
	 * @author Adil Iqbal	  | 1805-WVU -MAY29  | Richard Orr
	 * @author Ethan Conner	  | 1805-WVU -MAY29  | Richard Orr
	 * @param bucketId of bucket
	 * @return Question List
	 */
	@ApiOperation(value = "Adds a new Question", response = Question.class)
	@PostMapping(value = "/question" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		return new ResponseEntity<>(this.qs.create(question), HttpStatus.CREATED);
	}
	
	@GetMapping("/bucket/{bucketId}/question")
	public ResponseEntity<List<Question>> getBucketQuestions(@PathVariable(value="bucketId") Integer bucketId) {
		return new ResponseEntity<>(qs.getQuestionsByBucket(bucketId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Updates question", response = Question.class)
	@PutMapping(value = "/question" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> updateQuestion(@Valid @RequestBody Question question) {
		qs.updateQuestion(question);
		return new ResponseEntity<>(question, HttpStatus.OK);
	}
	
	@DeleteMapping("/question/{questionId}")
	public ResponseEntity<Question> deleteByQuestionId(@PathVariable(value="questionId") Integer questionId) {
		qs.deleteByQuestionId(questionId);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	@ApiOperation(value = "Sets Question to active state", response = Void.class)
	@PutMapping("/question/{id}/activate")
	public ResponseEntity<Void> activateQuestion(@PathVariable(value="id") Integer questionId) {
		qs.toggleQuestionStatus(true, questionId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@ApiOperation(value = "Sets Question to inactive status", response = Void.class)
	@PutMapping("/question/{id}/deactivate")
	public ResponseEntity<Void> deactivateQuestion(@PathVariable(value="id") Integer questionId) {
		qs.toggleQuestionStatus(false, questionId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

