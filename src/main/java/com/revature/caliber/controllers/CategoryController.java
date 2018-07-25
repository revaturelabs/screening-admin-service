package com.revature.caliber.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Category;
import com.revature.caliber.services.CategoryService;

import io.swagger.annotations.ApiOperation;

/**
 * Controller that will handle requests for the Category service
 * @author Ethan Conner
 * Controller that will handle requests for the Category service
 * 
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService cs;

	/**
	 * Handles incoming GET request that grabs all the categories
	 *
	 * @return list object containing all the categories retrieved along with HTTP<br>
	 *         status code 200 (OK); otherwise, HTTP status code 204 (NO_CONTENT) if no categories exist
	 */
	@ApiOperation(value = "Gets a list of categories", response = Category.class, responseContainer = "List")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categories = (List<Category>) this.cs.findAll();

		if (categories.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(categories, HttpStatus.OK);
		}
	}
	
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