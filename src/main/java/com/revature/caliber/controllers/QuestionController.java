package com.revature.caliber.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import com.revature.caliber.beans.Question;
import com.revature.caliber.services.QuestionServiceImpl;

/**
 * Controller that handles mapping for all of the methods for question manipulation
 * 
 * @author Alexia Doramus | 1803-USF-MAR26 | Wezley Singleton
 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@RestController
@RequestMapping("/questions")
@CrossOrigin
@ComponentScan("com.revature.caliber.*")
@ApiModel(value = "QuestionController", description = "A rest controller to handle HTTP Requests made to /questions")
public class QuestionController {
	
	@Autowired
	private QuestionServiceImpl questionService;
	
	/**
	 * Returns questions associated with bucket of given id
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
		return new ResponseEntity<>(questionService.getQuestionsByBucket(bucketId), HttpStatus.OK);
	}
}
