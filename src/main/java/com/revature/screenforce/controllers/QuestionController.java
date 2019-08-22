package com.revature.screenforce.controllers;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.services.BucketService;
import com.revature.screenforce.services.QuestionService;

import javax.validation.Valid;
import java.util.List;


/**
 * Controller that handles mapping for all of the methods for question manipulation
 * 
 * @author Alexia Doramus| 1803-USF-MAR26 | Wezley Singleton
 * @author Richard Vo	 | 1803-USF-MAR26 | Wezley Singleton
 * @author Ethan Conner  | 1805-WVU | Richard Orr
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 * @author Adil Iqbal    | 1805-WVU | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */

@RestController
@CrossOrigin
@RequestMapping("/question")
@ApiModel(value = "QuestionController", description = "A rest controller to handle HTTP Requests that return questions")
public class QuestionController {
	
	private QuestionService questionService;
	
	private BucketService bucketService;
	
	@Autowired
	public QuestionController(QuestionService questionService, BucketService bucketService){
		this.questionService = questionService;
		this.bucketService = bucketService;
	}
	
	/**
	 * Get all questions
	 * @return A List of all question in the database
	 */
	@ApiOperation(value="Get all questions",
			response = Question.class,
		    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All questions returned") } )
	@GetMapping()
	public ResponseEntity<List<Question>> getQuestions() {
		return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
	}

	/**
	 * Get a question by its Id
	 *
	 * @param questionId Id to filter by
	 * @return Question object with matching questionId
	 */
	@ApiOperation(value = "Get a question by its Id", response = Question.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Question found"),
			@ApiResponse(code = 404, message = "Question not found")
	})
	@GetMapping("/{questionId}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int questionId) {
		Question question = questionService.getByQuestionId(questionId);
		if (question != null && !(question.equals(new Question()))) {
			return new ResponseEntity<>(questionService.getByQuestionId(questionId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Find all questions associated with a specific bucket
	 * @param bucketId Id of bucket to filter by
	 * @return List of questions associated with bucket of given id
	 * 
	 * For the getByBucket method, it should be done using a params. rather than an endpoint. 
	 */
	@ApiOperation(value = "Find list of Questions by bucketId",
		notes = "Each question belongs to a particular bucket that classifies subject matter",
	    response = Question.class,
	    responseContainer = "List")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success, bucketId found with Question Associated"),
			@ApiResponse(code = 404, message = "bucketId is not found")} )
	@GetMapping("/getByBucket/{bucketId}")
	public ResponseEntity<List<Question>> getBucketQuestions(@PathVariable(value="bucketId") int bucketId) {
		if (bucketService.existsById(bucketId)) {
			return new ResponseEntity<>(questionService.getQuestionsByBucket(bucketId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	/**
	 * 
	 * @param bucketId
	 * @return Void
	 * 
	 */
	@ApiOperation(value = "Delete all questions associated with a bucketId")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "bucketId found, deleted all question"),
			@ApiResponse(code = 404, message = "bucketId is not found")} )
	@DeleteMapping("/deleteByBucket/{bucketId}")
	public ResponseEntity<Void> deleteByBucket(@PathVariable(value = "bucketId") int bucketId){
		if(bucketService.existsById(bucketId)) {
			questionService.deleteByBucketId(bucketId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Method to add a new question to the database
	 * @param question Question object to add to the database
	 * @return Question List and http status code 201
	 */
	@ApiOperation(value = "Adds a new Question", response = Question.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "New question created") } )
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		return new ResponseEntity<>(this.questionService.create(question), HttpStatus.CREATED);
	}
	
	/**
	 * Updates a number of fields for a specific question
	 * @param updated question object
	 * @return updated question and http status code 200
	 */
	@ApiOperation(value = "Updates question", response = Question.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Question updated"),
			@ApiResponse(code = 400, message = "Bad Request, Question is not updated") } )
	@PutMapping(value = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> updateQuestion(@PathVariable(value = "id") int id, @RequestBody Question question) {
		if (questionService.existsById(id)) {
			questionService.updateQuestion(question);
			return new ResponseEntity<>(question, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Removes a question from the DB, if found
	 * @param questionId - id of question to remove
	 * @return http status code 200
	 */
	@ApiOperation(value = "Deletes a question")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Question deleted"),
			@ApiResponse(code = 400, message = "Bad Request, QuestionID not found") } )
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByQuestionId(@PathVariable(value="id") int id) {
		if (questionService.existsById(id)) {
			questionService.deleteByQuestionId(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
