package com.revature.caliber.controllers;

import com.revature.caliber.beans.Weight;
import com.revature.caliber.services.WeightService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller that will handle requests for the weight service
 *
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@RestController
@RequestMapping(value = "/weight")
@ApiModel(value = "SkillTypeController", description = "A rest controller to handle HTTP Requests for CRUD operations on weights")
public class WeightController {

    @Autowired
    private WeightService ws;

    /**
     * Returns list of all weights in the DB
     *
     * @return list of weights
     */
    @ApiOperation(value = "Returns list of all weights in the DB", response = Weight.class, responseContainer = "List")
    @GetMapping()
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All weights returned")})
    public ResponseEntity<List<Weight>> getWeights() {
        return new ResponseEntity<>(ws.getAllWeights(), HttpStatus.OK);
    }

    /**
     * Returns weight from skill type and category ids
     *
     * @param skillTypeId - the associated skill type
     * @param bucketId    - the associated category
     * @return weight obj
     */
    @ApiOperation(value = "Gets a weight based on skilltype and category", response = Weight.class)
    @GetMapping("/{skillTypeId}/{bucketId}")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Requested weight returned")})
    public ResponseEntity<Weight> getWeightFromIds(@PathVariable(value = "skillTypeId") int skillTypeId,
                                                   @PathVariable(value = "bucketId") int bucketId) {
        return new ResponseEntity<>(ws.get(skillTypeId, bucketId), HttpStatus.OK);
    }

    /**
     * Returns weight from weight Id
     */
    @ApiOperation(value = "Gets a weight based on weight Id", response = Weight.class)
    @GetMapping("/{weightId}")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Requested weight returned")})
    public ResponseEntity<Weight> getWeightFromId(@PathVariable(value = "weightId") int weightId) {
        Weight weight = ws.get(weightId);
        if (weight == new Weight()) {
            return new ResponseEntity<>(weight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(weight, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Updates a weight obj
     *
     * @param weight updated weight obj
     * @return no content
     */
    @ApiOperation(value = "Update a weight", response = Void.class)
    @PutMapping(value = "/update")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "Weight updated")})
    public ResponseEntity<Void> updateWeight(@Valid @RequestBody Weight weight) {
        ws.update(weight);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * @param weight - transient weight
     * @return persisted weight with ID created
     */
    @ApiOperation(value = "Adds a new Weight", response = Weight.class)
    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Weight created and returned w/ updated id")})
    public ResponseEntity<Weight> create(@Valid @RequestBody Weight weight) {
        return new ResponseEntity<>(ws.create(weight), HttpStatus.CREATED);
    }

    /**
     * @param weightId - ID of skillType for weight to be deleted
     * @return Void
     */
    @ApiOperation(value = "Deletes a Weight", response = Void.class)
    @DeleteMapping(value = "/delete/{weightId}")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "Weight deleted")})
    public ResponseEntity<Void> delete(@PathVariable(value = "weightId") int weightId) {
        ws.deleteById(weightId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
