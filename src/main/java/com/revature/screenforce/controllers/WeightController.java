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

import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.services.WeightService;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller that will handle requests for the weight service
 *
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/weight")
@ApiModel(value = "SkillTypeController", description = "A rest controller to handle HTTP Requests for CRUD operations on weights")
public class WeightController {

    
    private WeightService weightService;
    @Autowired
    public WeightController(WeightService weightService) {
    	this.weightService = weightService;
    }

    /**
     * Returns list of all weights in the DB
     *
     * @return list of weights
     */
    @ApiOperation(value = "Returns list of all weights in the DB", response = Weight.class, responseContainer = "List")
    @GetMapping()
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All weights returned")})
    public ResponseEntity<List<Weight>> getWeights() {
        return new ResponseEntity<>(weightService.getAllWeights(), HttpStatus.OK);
    }

    /**
     * Returns weight from skill type and bucket ids
     *
     * @param skillTypeId - the associated skill type
     * @param bucketId    - the associated bucket
     * @return weight obj
     */
    @ApiOperation(value = "Gets a weight based on skilltype and bucket", response = Weight.class)
    @GetMapping("/{skillTypeId}/{bucketId}")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Requested weight returned")})
    public ResponseEntity<Weight> getWeightFromIds(@PathVariable(value = "skillTypeId") int skillTypeId,
                                                   @PathVariable(value = "bucketId") int bucketId) {
        return new ResponseEntity<>(weightService.get(skillTypeId, bucketId), HttpStatus.OK);
    }

	/**
	 * Get a list of weights based on their SkillTypes
	 *
	 * @param skillTypeId Id of the SkillType to filter by
	 * @return List of Weights with matching SkillTypes
	 */
	@ApiOperation(value = "Get a list of weights based on their skillTypes", response = Weight.class, responseContainer = "List")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "List of weights returned")})
	@GetMapping("/getBySkillType/{skillTypeId}")
	public ResponseEntity<List<Weight>> getWeightBySkillType(@PathVariable int skillTypeId) {
		return new ResponseEntity<>(weightService.getAllWeightsBySkillTypeID(skillTypeId), HttpStatus.OK);
	}

	/**
	 * Get a weight by its Id
	 *
	 * @param weightId Id of the weight to filter by
	 * @return Weight object with matching Id
	 */
	@ApiOperation(value = "Gets a weight based on weight Id", response = Weight.class)
    @GetMapping("/{weightId}")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Requested weight returned")})
    public ResponseEntity<Weight> getWeightFromId(@PathVariable(value = "weightId") int weightId) {
        Weight weight = weightService.get(weightId);
		if (weight.equals(new Weight())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
			return new ResponseEntity<>(weight, HttpStatus.OK);
        }
    }


    /**
     * Updates a weight obj
     *
     * @param weight updated weight obj
     * @return no content
     */
    @ApiOperation(value = "Update a weight", response = Void.class)
    @PutMapping(value = "/{weightId}")
    @ApiResponses(value = {
    		@ApiResponse(code = 204, message = "Weight updated"),
    		@ApiResponse(code = 404, message = "Weight ID not found, nothing is updated") })
    public ResponseEntity<Void> updateWeight(@PathVariable(value = "weightId") int weightId, @RequestBody Weight weight) {
        if (weightService.existsById(weightId)) {
        	weightService.update(weight);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    	
    }

    /**
     * @param weight - transient weight
     * @return persisted weight with ID created
     */
    @ApiOperation(value = "Adds a new Weight", response = Weight.class)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Weight created and returned w/ updated id")})
    public ResponseEntity<Weight> create(@Valid @RequestBody Weight weight) {
        return new ResponseEntity<>(weightService.create(weight), HttpStatus.CREATED);
    }

    /**
     * @param weightId - ID of skillType for weight to be deleted
     * @return Void
     */
    @ApiOperation(value = "Deletes a Weight", response = Void.class)
    @DeleteMapping(value = "/{weightId}")
    @ApiResponses(value = {
    		@ApiResponse(code = 204, message = "Weight deleted"),
    		@ApiResponse(code = 404, message = "Weight ID not found, nothing is deleted") })
    public ResponseEntity<Void> delete(@PathVariable(value = "weightId") int weightId) {
        if (weightService.existsById(weightId)) {
        	weightService.deleteById(weightId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
