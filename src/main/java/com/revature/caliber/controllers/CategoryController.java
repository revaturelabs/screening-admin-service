package com.revature.caliber.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Category;
import com.revature.caliber.services.CategoryService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Ethan Conner
 * Controller that will handle requests for the Category service
 * 
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

	/**
	 * Service that contains all the business logic (methods) to be executed for<br>
	 * this controller based on the request type
	 */
	@Autowired
	private CategoryService cs;

	/**
	 * Handles incoming POST request that adds a new Category to the DB
	 *
	 * @param Category - incoming data fields will be mapped into this object
	 * @return added Category and HTTP status code 201 (CREATED)
	 */
	@ApiOperation(value = "Adds a new Category", response = Category.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> create(@Valid @RequestBody Category category) {
		return new ResponseEntity<>(this.cs.create(category), HttpStatus.CREATED);
	}

	

}