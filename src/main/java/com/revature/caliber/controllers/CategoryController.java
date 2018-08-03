package com.revature.caliber.controllers;



import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Category;
import com.revature.caliber.services.CategoryService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller that will handle requests for the Category service
 * @author Ethan Conner
 * @author Zia Mohiuddin
 * 
 */
@RestController
@RequestMapping("/category")
@ApiModel(value = "CategoryController", description = "A rest controller to handle HTTP Requests made to /category")
public class CategoryController {

	@Autowired
	private CategoryService cs;

	/**
	 * Handles incoming POST request that adds a new Category to the DB
	 *
	 * @param Category - incoming data fields will be mapped into this object
	 * @return added Category and HTTP status code 201 (CREATED)
	 */

	@ApiOperation(value = "Adds a new Category", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Category created") } )
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> create(@Valid @RequestBody Category category) {
		return new ResponseEntity<>(this.cs.create(category), HttpStatus.CREATED);
	}

	/**
	 * Handles incoming GET request that grabs all the categories
	 *
	 * @return list object containing all the categories retrieved along with HTTP<br>
	 *         status code 200 (OK); otherwise, HTTP status code 204 (NO_CONTENT) if no categories exist
	 */
	@ApiOperation(value = "Gets a list of categories", response = Category.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All categories returned"),
			@ApiResponse(code = 204, message = "No categories were found") } )
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
	 * Handles incoming Get requests to find all active categories
	 * 
	 * @return HTTP status code 200 (OK) if there are active categories,<br> 
	 * 204 (NO_CONTENT) if there are no active categories
	 */
	@ApiOperation(value = "Gets a list of all active categories", response = Category.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Active categories returned"),
			@ApiResponse(code = 204, message="No active categories were found") } )
	@GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> findAllActive() {
		List<Category> categories = (List<Category>) this.cs.findAllActive();
		
		if (categories.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	/**
	 * Handles incoming GET request that gets a Category by its id
	 * 
	 * @param id - Category's id
	 * @return a Category retrieved along with HTTP status code 200 (OK); otherwise,<br>
	 * null is returned along with HTTP status code 404 (NOT_FOUND)
	 */
	@ApiOperation(value = "Get a Category by its id", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Category with supplied id returned"),
			@ApiResponse(code = 404, message = "No category found with supplied id") } )
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> findById(@PathVariable int id) {
		Category category = this.cs.findByCategoryID(id);

		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(category, HttpStatus.OK);
		}
	}
	
	/**
	 * Handles incoming PUT requests to update Category
	 * @param category - the Category object to place at "/id"
	 * @return a Category that was updated and status code 200 (OK)
	 */
	@ApiOperation(value = "Updates a Category", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Category updated") } )
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) {
		cs.updateCategory(category);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	/**
	 * Handles incoming Delete requests to Delete Category
	 * @param id the id of the category to delete
	 * @return http status 204
	 */
	@ApiOperation(value = "Deletes a category", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Category deleted") } )
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
		cs.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
