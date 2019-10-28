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

import com.revature.screenforce.beans.Category;
import com.revature.screenforce.services.CategoryService;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for the category
 * 
 * @author Adil Iqbal | 1805-WVU-MAY29 | Richard Orr
 * @author Theo Thompson| 1805-WVU-MAY29 | Richard Orr
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 */
@RestController
@RequestMapping(value = "/category")
@ApiModel(value = "CategoryController", description = "A rest controller to handle HTTP Requests made to /category")
public class CategoryController {
	/** Category service */
	private CategoryService categoryService;

	/**
	 * Instantiates a new category controller
	 *
	 * @param categoryService Category service
	 */
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Gets all Categories
	 * 
	 * @return List of Categories and Http status code
	 */
	@ApiOperation(value = "Gets a list of all the Categories", response = Category.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All Categories returned") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> s = categoryService.getAllCategories();
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	/**
	 * Creates a new category
	 * 
	 * @param category - transient category
	 * @return Detached category (w/ updated Id) and http status code
	 */
	@ApiOperation(value = "Adds a new Category", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created category returned"),
			@ApiResponse(code = 415, message = "Unsupported Media") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
		if (category != null && !category.getCategoryDescription().equals("")) {
			return new ResponseEntity<>(this.categoryService.createCategory(category), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}
	}

	/**
	 * Updates a located at "/id"
	 * 
	 * @param - the updated
	 * @return Updated and http status code
	 */
	@ApiOperation(value = "Updates a Category", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Category updated"),
			@ApiResponse(code = 400, message = "Bad Request, Category not updated") })
	@PutMapping(value = "/{Id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> updateCategory(@PathVariable(value = "categoryId") int categoryId,
			@RequestBody Category category) {
		if (categoryService.existsById(categoryId)) {
			categoryService.updateCategory(category);
			return new ResponseEntity<>(category, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Gets an individual
	 * 
	 * @param Id - Id of to fetch
	 * @return Requested and http status code
	 */
	@ApiOperation(value = "Gets a Category by category id", response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requested category returned"),
			@ApiResponse(code = 404, message = "Category not found") })
	@GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> getCategoryByCategoryId(@PathVariable Integer categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		if (category.equals(new Category())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(category, HttpStatus.OK);
		}
	}

	/**
	 * Deletes a category
	 * 
	 * @param categoryId - Id of category to delete
	 * @return http status 204
	 */
	@ApiOperation(value = "Deletes a Category")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Category deleted"),
			@ApiResponse(code = 404, message = "Category Not Found, Nothing is Deleted") })
	@DeleteMapping(value = "/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer categoryId) {
		if (categoryService.existsById(categoryId)) {
			categoryService.deleteCategory(categoryId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
