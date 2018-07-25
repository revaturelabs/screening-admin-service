package com.revature.caliber.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Weight;
import com.revature.caliber.services.WeightService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
@CrossOrigin
public class WeightController {
	
	@Autowired
	private WeightService ws;
	
	/**
	 * Returns list of all weights in the DB
	 * 
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * 
	 * @return list of weights
	 */
	@ApiOperation(value = "Returns list of all weights in the DB", response = Weight.class,  responseContainer = "List")
	@GetMapping(value="/weight")
	public ResponseEntity<List<Weight>> getWeights() {
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
	@GetMapping("/skilltype/{skillTypeId}/category/{categoryId}/weight")
	public ResponseEntity<Weight> getWeightFromIds(@PathVariable(value="skillTypeId") Integer skillTypeId,
			@PathVariable(value="categoryId") Integer categoryId) {
		return new ResponseEntity<>(ws.getWeightBySkillTypeAndCategory(skillTypeId.intValue(), categoryId.intValue()), HttpStatus.OK);
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
	@PutMapping(value="/weight")
	public ResponseEntity<Void> updateWeight(@Valid @RequestBody Weight weight) {
		ws.update(weight);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * @param weight - transient weight
	 * @return persisted weight with ID created
	 */
	@ApiOperation(value = "Adds a new Weight", response = Weight.class)
	@PostMapping(value="/weight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Weight> create(@Valid @RequestBody Weight weight) {
		return new ResponseEntity<>(ws.create(weight), HttpStatus.CREATED);
	}
	
	/**
	 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
	 * @param weightId - ID of weight to be deleted
	 * @return Void
	 */
	@ApiOperation(value = "Deletes a Weight", response = Void.class)
	@DeleteMapping(value="/weight/{weightId}")
	public ResponseEntity<Void> delete(@PathVariable(value = "weightId") long weightId){
		ws.deleteById(weightId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
