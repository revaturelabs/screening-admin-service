package com.revature.caliber.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Question;
import com.revature.caliber.services.QuestionServiceImpl;

@RestController
@RequestMapping("/questions")
@CrossOrigin
@ComponentScan("com.revature.caliber.*")
public class QuestionController {

	// maybe an aspect would be ideal?
	// private static final Logger log = Logger.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionServiceImpl questionService;
	
	/**
	 * Returns questions associated with bucket of given id
	 * 
	 * @param bucketId Id of bucket
	 * @return List of questions associated with bucket of given id
	 */
	@GetMapping("/bucket/{bucketId}")
	public ResponseEntity<List<Question>> getBucketQuestions(@PathVariable(value="bucketId") Integer bucketId) {
		// log.info("Getting questions for bucket: " + bucketId);
		return new ResponseEntity<>(questionService.getQuestionsByBucket(bucketId), HttpStatus.OK);
	}
}