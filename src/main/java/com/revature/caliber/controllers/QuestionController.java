package com.revature.caliber.controllers;


import com.revature.caliber.beans.Question;
import com.revature.caliber.services.QuestionService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@Autowired
	private QuestionService qs;

	/**
	 * Get all questions
	 * @return A List of all question in the databse
	 */
	@ApiOperation(value="Get all questions",
			response = Question.class,
		    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All questions returned") } )
	@GetMapping("/all")
	public ResponseEntity<List<Question>> getQuestions() {
		return new ResponseEntity<>(qs.getAllQuestions(), HttpStatus.OK);
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
		Question question = qs.getByQuestionId(questionId);
		if (question != null && !(question.equals(new Question()))) {
			return new ResponseEntity<>(qs.getByQuestionId(questionId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Find all questions associated with a specific bucket
	 * @param bucketId Id of bucket to filter by
	 * @return List of questions associated with bucket of given id
	 */
	@ApiOperation(value = "Find list of Questions by bucketId",
		notes = "Each question belongs to a particular bucket that classifies subject matter",
	    response = Question.class,
	    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Response is empty if bucketId is not found") } )
	@GetMapping("/getByBucket/{bucketId}")
	public ResponseEntity<List<Question>> getBucketQuestions(@PathVariable(value="bucketId") int bucketId) {
		return new ResponseEntity<>(qs.getQuestionsByBucket(bucketId), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete all questions associated with a bucketId")
	@ApiResponse(code = 204, message = "Deleted associated questions")
	@DeleteMapping("/deleteByBucket/{bucketId}")
	public ResponseEntity<Void> deleteByBucket(@PathVariable(value = "bucketId") int bucketId){
		qs.deleteByBucketId(bucketId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Method to add a new question to the database
	 * @param question Question object to add to the database
	 * @return Question List and http status code 201
	 */
	@ApiOperation(value = "Adds a new Question", response = Question.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "New question created") } )
	@PostMapping(value = "/new" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> create(@Valid @RequestBody Question question) {
		return new ResponseEntity<>(this.qs.create(question), HttpStatus.CREATED);
	}
	
	/**
	 * Updates a number of fields for a specific question
	 * @param question updated question object
	 * @return updated question and http status code 200
	 */
	@ApiOperation(value = "Updates question", response = Question.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Question updated") } )
	@PutMapping(value = "/update" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteByQuestionId(@PathVariable(value="id") Integer questionId) {
		qs.deleteByQuestionId(questionId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Toggles question isActive status
	 * @param questionId - id of question to remove
	 * @return http status code 204
	 */
	@ApiOperation(value = "Sets Question to active state", response = void.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Question toggled") } )
	@PutMapping("/toggle/{id}")
	public ResponseEntity<Void> activateQuestion(@PathVariable(value="id") Integer questionId) {
		qs.toggleQuestionStatus(questionId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
