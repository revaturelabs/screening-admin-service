package com.revature.screenforce.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.services.CategoryService;
import com.revature.screenforce.services.QuestionService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


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
@RequestMapping("/question")
@ApiModel(value = "QuestionController", description = "A rest controller to handle HTTP Requests that return questions")
public class QuestionController {
	/** Question service */
	private QuestionService questionService;

	/** Category service */
	private CategoryService categoryService;

	/**
	 * Instantiates a new question controller
	 *
	 * @param questionService Question service
	 * @param categoryService Category service
	 */
	@Autowired
	public QuestionController(QuestionService questionService, CategoryService categoryService) {
		this.questionService = questionService;
		this.categoryService = categoryService;
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
	 * Find all questions associated with a specific category
	 * @param categoryId Id of category to filter by
	 * @return List of questions associated with category of given id
	 * 
	 * For the getByCategory method, it should be done using a params. rather than an endpoint. 
	 */
	@ApiOperation(value = "Find list of Questions by categoryId",
		notes = "Each question belongs to a particular category that classifies subject matter",
	    response = Question.class,
	    responseContainer = "List")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success, categoryId found with Question Associated"),
			@ApiResponse(code = 404, message = "categoryId is not found")} )
	@GetMapping("/getByCategory/{categoryId}")
	public ResponseEntity<List<Question>> getCategoryQuestions(@PathVariable(value="categoryId") int categoryId) {
		if (categoryService.existsById(categoryId)) {
			return new ResponseEntity<>(questionService.getQuestionsByCategory(categoryId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	/**
	 * Deletes questions by category ID
	 * 
	 * @param categoryId Category ID
	 */
	@ApiOperation(value = "Delete all questions associated with a categoryId")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "categoryId found, deleted all question"),
			@ApiResponse(code = 404, message = "categoryId is not found")} )
	@DeleteMapping("/deleteByCategory/{categoryId}")
	public ResponseEntity<Void> deleteByCategory(@PathVariable(value = "categoryId") int categoryId){
		if(categoryService.existsById(categoryId)) {
			questionService.deleteByCategoryId(categoryId);
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
	 *
	 * @param id ID of question to update
	 * @param question question object
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
	 *
	 * @param id ID of question to remove
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
