package com.revature.caliber.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.SkillType;
import com.revature.caliber.services.SkillTypeService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller that handles mapping for SkillType manipulation
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@RestController
@RequestMapping(value = "/skillType")
@CrossOrigin
@ApiModel(value = "SkillTypeController", description = "A rest controller to handle HTTP Requests made to /skillTypes")
public class SkillTypeController {
		
	/*
	 * 
	### SkillType
	  #### GET /skillTypes
	    find all skill types.
	    
	  #### GET /skillTypes/active
	    find all active skill types.
	    
	  #### GET /skillTypes/{skillTypeId}
	    find skill type by id.
	    
	  #### POST /skillTypes
	    save skill type
	  
	   #### PUT /skillTypes/{skillTypeId}
	    updates specific skill type
	     
	   #### DELETE /skillTypes/{skillTypeId}
	    delete skill type by id
	 */

	@Autowired
	SkillTypeService skillService;
	
	/**
	 * Request that returns all skill types
	 * 
	 * @return List of all SkillType objects
	 * @author Isaac Pawling | 1805-WVU | Richard Orr
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "Gets list of SkillTypes",
		notes = "Enter Notes here",
	    response = SkillType.class,
	    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All SkillTypes returned") } )
	public ResponseEntity<List<SkillType>> getSkills() {
		return new ResponseEntity<>(skillService.getSkills(), HttpStatus.OK);
	}
	
	// TODO need to make an isActive parameter in the bean so I can do this
	/**
	 * Request that returns all active skill types
	 * Mapping value = "/skillTypes/active"
	 * 
	 * @return List of all SkillType objects
	 * @author Isaac Pawling | 1805-WVU | Richard Orr
	 */
//	@RequestMapping(method=RequestMethod.GET)
//	@ApiOperation(value = "Gets list of SkillTypes",
//		notes = "Enter Notes here",
//	    response = SkillType.class,
//	    responseContainer = "List")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "All SkillTypes returned") } )
//	public ResponseEntity<List<SkillType>> getSkills() {
//		return new ResponseEntity<>(skillService.getSkillTypes(), HttpStatus.OK);
//	}
	
	/**
	 * Request that returns a skill type by id
	 * 
	 * @return SkillType object and Http status code 200 if found, 404 otherwise
	 * @author Isaac Pawling | 1805-WVU | Richard Orr
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation(value = "Gets a SkillType by id",
		notes = "Enter Notes here",
	    response = SkillType.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requested SkillType returned"),
			@ApiResponse(code = 404, message = "Requested SkillType not found") } )
	public ResponseEntity<SkillType> getSkillById(@PathVariable(value="id") Integer id) {
		SkillType skill = null;
		if ((skill = skillService.getSkill(id)) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(skill, HttpStatus.OK);
	}
	
	
	/**
	 * Request that creates a skill type
	 * 
	 * @return SkillType w/ updated Id and Http status code 200, 
	 * @author Isaac Pawling | 1805-WVU | Richard Orr
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value = "Creates a SkillType",
		notes = "Enter Notes here",
	    response = SkillType.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "SkillType created"),
			@ApiResponse(code = 406, message = "SkillType must have a title") } )
	public ResponseEntity<SkillType> postSkill(@Valid @RequestBody SkillType s) {
		if (s.getTitle().equals("")) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(skillService.createSkill(s), HttpStatus.CREATED);
	}
	
	/**
	 * Request that puts skill type by id
	 * 
	 * @return Http status code 200
	 * @author Isaac Pawling | 1805-WVU | Richard Orr
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ApiOperation(value = "Puts a SkillType by id",
		notes = "Enter Notes here",
	    response = SkillType.class)
	@ApiResponses(value = { @ApiResponse(code = 202, message = "SkillType updated"),
			@ApiResponse(code = 404, message = "SkillType not found") } )
	public ResponseEntity<Void> putSkillById(@Valid @RequestBody SkillType s) {
		if (skillService.getSkill(s.getSkillTypeId()) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		skillService.updateSkill(s);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	/**
	 * Request that deletes a skill
	 * 
	 * @return Http status code 404 if SkillType DNE, 204 otherwise
	 * @author Isaac Pawling | 1805-WVU | Richard Orr
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ApiOperation(value = "Deletes a SkillType by id",
		notes = "Enter Notes here",
	    response = SkillType.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "SkillType deleted"),
			@ApiResponse(code = 404, message = "SkillType not found") } )
	public ResponseEntity<Void> deleteSkillById(@PathVariable(value="id") Integer id) {
		if (skillService.getSkill(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		skillService.deleteSkill(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
