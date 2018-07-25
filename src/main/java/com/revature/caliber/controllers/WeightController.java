package com.revature.caliber.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.caliber.beans.Question;
import com.revature.caliber.beans.Weight;

import io.swagger.annotations.ApiOperation;

public class WeightController {
	
	
	/**
	 * Returns list of all weights in the DB
	 * 
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * 
	 * @return list of weights
	 */
	@ApiOperation(value = "Returns list of all weights in the DB", response = Weight.class)
	@GetMapping
	public ResponseEntity<Weight> getWeights() {
		return new ResponseEntity<>(ws.getWeights(), HttpStatus.OK);
	}
	
	/**
	 * Returns weight from skill type and category ids
	 * 
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * 
	 * @param skillTypeId - the associated skill type
	 * @param categoryId - the associated category
	 * @return weight obj
	 */
	@ApiOperation(value = "Gets a weight based on skilltype and category", response = Weight.class)
	@GetMapping("/{skillTypeId}/{categoryId}")
	public ResponseEntity<Weight> getWeightFromIds(@PathVariable(value="skillTypeId") Integer skillTypeId,
			@PathVariable(value="categoryId") Integer categoryId) {
		return new ResponseEntity<>(ws.getWeightBySkillTypeAndCategory(skillTypeId, categoryId), HttpStatus.OK);
	}
	
	
	/**
	 * Updates a weight obj
	 * 
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * 
	 * @param updated weight obj
	 * @return no content
	 */
	@ApiOperation(value = "Update a weight", response = Void.class)
	@PutMapping("/{id}")
	public ResponseEntity<Void> deactivateQuestion(@Valid @RequestBody Weight weight) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@ApiOperation(value = "Adds a new Weight", response = Weight.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Weight> create(@Valid @RequestBody Weight weight) {
		return new ResponseEntity<>(ws.create(weight), HttpStatus.CREATED);
	}
}
