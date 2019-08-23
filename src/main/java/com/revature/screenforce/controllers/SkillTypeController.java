package com.revature.screenforce.controllers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.screenforce.beans.SkillType;
import com.revature.screenforce.services.SkillTypeService;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller that handles mapping for SkillType manipulation
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/skilltype")
@ApiModel(value = "SkillTypeController", description = "A rest controller to handle HTTP Requests made to /skilltype")
public class SkillTypeController {
	/** Skill type service */
	private SkillTypeService skillTypeService;

	/**
	 * Instantiates a new skill type controller
	 *
	 * @param skillTypeService Skill type service
	 */
	@Autowired
	public SkillTypeController(SkillTypeService skillTypeService) {
		this.skillTypeService = skillTypeService;
	}
  
	/**
	 * Gets all skill types
	 * 
	 * @return List of all SkillType objects
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "Gets list of SkillTypes",
	    response = SkillType.class,
	    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All SkillTypes returned") } )
	public ResponseEntity<List<SkillType>> getSkills() {
		return new ResponseEntity<>(skillTypeService.getAllSkillTypes(), HttpStatus.OK);
	}
	
	/**
	 * Gets all active skill types
	 * 
	 * @return List of all active SkillType objects
	 */
	@RequestMapping(method=RequestMethod.GET, value = "/active")
	@ApiOperation(value = "Gets list of active SkillTypes",
	    response = SkillType.class,
	    responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All active SkillTypes returned") } )
	public ResponseEntity<List<SkillType>> getActiveSkills() {
		return new ResponseEntity<>(skillTypeService.getActiveSkillTypes(true), HttpStatus.OK);
	}
	
	/**
	 * Gets requested Id
	 * 
	 * @return SkillType object and Http status code 200 if found, 404 otherwise
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation(value = "Gets a SkillType by id",
	    response = SkillType.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Requested SkillType returned"),
			@ApiResponse(code = 404, message = "Requested SkillType not found") } )
	public ResponseEntity<SkillType> getSkillById(@PathVariable(value="id") Integer id) {
		SkillType skill = skillTypeService.getSkillType(id);
		if (skill == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(skill, HttpStatus.OK);
		}			
	}
	
	
	/**
	 * Creates a skill type
	 *
	 * @param s Skill type object to create
	 * @return SkillType w/ updated Id and Http status code 200,
	 * 	updating skilltype with empty title results in 406
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value = "Creates a SkillType",
	    response = SkillType.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "SkillType created"),
			@ApiResponse(code = 406, message = "SkillType must have a title") } )
	public ResponseEntity<SkillType> postSkill(@Valid @RequestBody SkillType s) {
		if (s.getTitle().equals("")) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(skillTypeService.createSkillType(s), HttpStatus.CREATED);
	}
	
	/**
	 * Updates skill type located at "/id"
	 *
	 * @param s Skill type object to update
	 * @return Http status code 202, 404 if skill type w/ provided Id DNE
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ApiOperation(value = "Puts a SkillType by id",
	    response = SkillType.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 202, message = "SkillType updated"),
			@ApiResponse(code = 404, message = "SkillType not found") } )
	public ResponseEntity<Void> putSkillById(@PathVariable(value="id") int id, @RequestBody SkillType s) {
		if (skillTypeService.existsById(id)) {
			skillTypeService.updateSkillType(s);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Deletes a skill
	 *
	 * @param id ID of skill type to delete
	 * @return Http status code 404 if SkillType DNE, 204 otherwise
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ApiOperation(value = "Deletes a SkillType by id",
	    response = SkillType.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "SkillType deleted"),
			@ApiResponse(code = 404, message = "SkillType not found") } )
	public ResponseEntity<Void> deleteSkillById(@PathVariable(value="id") int id) {
		SkillType sType = skillTypeService.getSkillType(id);
		if (sType != null) {
			skillTypeService.deleteSkillType(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
