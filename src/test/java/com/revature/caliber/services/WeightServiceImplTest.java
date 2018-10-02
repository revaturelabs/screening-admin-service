package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Weight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * SkillTypeService Tests using JUnit
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class WeightServiceImplTest {

	@Autowired
	WeightServiceImpl weightService;
	
	@Test
	public void testGetAllWeights() {
		Weight weight = new Weight();
		int maxW = weightService.getAllWeights().size();
		weightService.create(weight);
		assertEquals((maxW + 1), weightService.getAllWeights().size());
	}

	@Test
	public void testUpdate() {
		Weight weight = new Weight();
		weightService.create(weight);
		int newVal = 800;
		weight.setWeightValue(newVal);
		weightService.update(weight);
		assertEquals(newVal, weightService.get(weight.getWeightId()).getWeightValue());
	}

	@Test
	public void testCreate() {
		Weight weight = new Weight();
		int id = (int) weightService.create(weight).getWeightId();
		assertEquals(id, weightService.get(id).getWeightId());
	}
	
	@Test
	public void testCreateNull() {
		Weight weight = null;
		int before = weightService.getAllWeights().size();
		weightService.create(weight);
		int after = weightService.getAllWeights().size();
		assertEquals(before,after);
	}

	@Test
	public void testDeleteById() {
		Weight weight = new Weight();
		int before = weightService.getAllWeights().size();
		weightService.create(weight);
		weightService.deleteById(weight.getWeightId());
		int after = weightService.getAllWeights().size();
		assertEquals(before, after);
	}
	
	@Test
	public void getAllWeightBySkillTypeId() {
		int actual = weightService.getAllWeightsBySkillTypeID(51).size();
		assertEquals(2, actual);
	}
	
	@Test
	public void getWithSkillTypeAndBucketId() {
		assertEquals(51404, weightService.get(51, 404).getWeightId());
	}


}
