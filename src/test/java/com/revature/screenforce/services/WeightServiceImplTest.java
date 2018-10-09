package com.revature.screenforce.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Weight;
import com.revature.screenforce.services.WeightServiceImpl;

import static org.junit.Assert.assertEquals;

/**
 * SkillTypeService Tests using JUnit
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
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
