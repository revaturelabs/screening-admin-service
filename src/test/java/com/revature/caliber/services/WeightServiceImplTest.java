package com.revature.caliber.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.beans.Bucket;
import com.revature.caliber.beans.SkillType;
import com.revature.caliber.beans.Weight;

public class WeightServiceImplTest {
	
	@Autowired
	WeightServiceImpl weightService;
	


	@Test
	public void testGetAllWeights() {
		Weight weight =new Weight();
		int maxW = weightService.getAllWeights().size();
		weightService.create(weight);
		assertEquals((maxW + 1), weightService.getAllWeights().size());
	}

	@Test
	public void testUpdate() {
		Weight weight =new Weight();
		int val = weight.getWeightValue();
		int newVal = 800;
		weight.setWeightValue(newVal);
		weightService.create(weight);
		assertEquals(val, weightService.get(weight.getWeightId()).getWeightValue());
	}

	@Test
	public void testCreate() {
		Weight weight =new Weight();
		int id = (int) weightService.create(weight).getWeightId();
		assertEquals(id, weightService.get(id).getWeightId());
	}

	@Test
	public void testDeleteById() {
		Weight weight =new Weight();
		int before = weightService.getAllWeights().size();
		weightService.create(weight);
		weightService.deleteById(weight.getWeightId());
		int after = weightService.getAllWeights().size();
		assertEquals(before, after);
	}


}
