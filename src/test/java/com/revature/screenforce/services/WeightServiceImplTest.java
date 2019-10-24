package com.revature.screenforce.services;

import com.revature.screenforce.beans.SkillType;
import com.revature.screenforce.repositories.WeightRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Weight;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * SkillTypeService Tests using JUnit
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class WeightServiceImplTest {
	@Mock WeightRepository weightRepository;
	@InjectMocks WeightServiceImpl weightService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllWeights() {
		List<Weight> weights = new ArrayList<>();

		// Mock DAO findAll()
		when(weightRepository.findAll()).thenReturn(weights);

		int nWeights = weights.size();
		assertEquals(nWeights, weightService.getAllWeights().size());
	}

	@Test
	public void testUpdate() {
		Weight weight = new Weight();
		weight.setWeightValue(800);

		// Mock DAO findById() & save()
		when(weightRepository.findById(any(Integer.class)))
				.thenReturn(java.util.Optional.of(weight));
		when(weightRepository.save(any(Weight.class))).thenReturn(weight);
		weightService.create(weight);
		weight.setWeightValue(33);
		weightService.update(weight);

		assertEquals(weight, weightService.get(weight.getWeightId()));
	}

	@Test
	public void testCreate() {
		// Mock DAO save()
		when(weightRepository.save(any(Weight.class))).thenReturn(new Weight());
		assertNotNull(weightService.create(new Weight()));
	}
	
	@Test
	public void testCreateNull() {
		// Mock DAO save()
		when(weightRepository.save(any(Weight.class))).thenReturn(null);
		Weight nullWeight = weightService.create(new Weight());

		assertNull(nullWeight);
	}

	@Test
	public void testDeleteById() {
		// Mock DAO save() & findById()
		when(weightRepository.save(any(Weight.class))).thenReturn(new Weight());
		when(weightRepository.findById(any(Integer.class)))
				.thenReturn(java.util.Optional.of(new Weight()));

		Weight weight = weightService.create(new Weight());
		weight.setWeightId(33);

		// Mock DAO deleteById()
		weightService.deleteById(weight.getWeightId());

		// getCategoryById is set to return new Category() if no category with ID is
		// found
		assertEquals(new Weight(), weightService.get(weight.getWeightId()));
	}
	
	@Test
	public void getAllWeightBySkillTypeId() {
		// Mock DAO save()
		when(weightRepository.save(any(Weight.class))).thenReturn(new Weight());
		SkillType st1 = new SkillType(); st1.setSkillTypeId(33);
		SkillType st2 = new SkillType(); st2.setSkillTypeId(33);
		Weight w1 = weightService.create(new Weight()); w1.setSkillType(st1);
		Weight w2 = weightService.create(new Weight()); w2.setSkillType(st2);

		// Mock DAO getAllBySkillTypeSkillTypeId()
		List<Weight> weights = new ArrayList<>();
		weights.add(w1);
		weights.add(w2);
		when(weightRepository.getAllBySkillTypeSkillTypeId(any(Integer.class)))
				.thenReturn(weights);

		assertEquals(weights.size(),
				weightService.getAllWeightsBySkillTypeID(33).size());
	}
	
	@Test
	public void getWithSkillTypeAndCategoryId() {
		// Mock DAO getBySkillTypeSkillTypeIdAndCategoryCategoryId()
		when(weightRepository.getBySkillTypeSkillTypeIdAndCategoryCategoryId(
				any(Integer.class),
				any(Integer.class)))
				.thenReturn(new Weight());

		assertEquals(new Weight(), weightService.get(3, 3));
	}

	@Test
	public void testExistById() {
		when(weightRepository.existsById(any(Integer.class))).thenReturn(true);
		assertTrue(weightService.existsById(51404));
	}

	@Test
	public void testExistByIdFail() {
		when(weightRepository.existsById(any(Integer.class))).thenReturn(false);
		assertFalse(weightService.existsById(51404));
	}
}
