package com.revature.screenforce.services;

import com.revature.screenforce.repositories.SkillTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.SkillType;

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
public class SkillTypeServiceImplTest {
	@Mock SkillTypeRepository skillTypeRepository;
	@Mock WeightService weightService;
	@InjectMocks SkillTypeServiceImpl skillTypeService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllSkillTypes() {
		List<SkillType> skillTypes = new ArrayList<>();

		// Mock DAO findAll()
		when(skillTypeRepository.findAll()).thenReturn(skillTypes);

		int nSkillTypes = skillTypes.size();
		assertEquals(nSkillTypes, skillTypeService.getAllSkillTypes().size());
	}

	@Test
	public void testCreateSkillType() {
		// Mock DAO save()
		when(skillTypeRepository.save(any(SkillType.class))).thenReturn(new SkillType());
		assertNotNull(skillTypeService.createSkillType(new SkillType()));
	}

	@Test
	public void testGetSkillType() {
		SkillType skill = new SkillType("Intelligence", true);

		// Mock DAO findById()
		when(skillTypeRepository.findById(any(Integer.class)))
				.thenReturn(java.util.Optional.of(skill));
		
		assertEquals(skill,
				skillTypeService.getSkillType(skill.getSkillTypeId()));
	}

	@Test
	public void testUpdateSkillType() {
		SkillType skillType = new SkillType();
		skillType.setTitle("Title");

		// Mock DAO findById() & save()
		when(skillTypeRepository.findById(any(Integer.class)))
				.thenReturn(java.util.Optional.of(skillType));
		when(skillTypeRepository.save(any(SkillType.class))).thenReturn(skillType);

		SkillType st = skillTypeService.createSkillType(skillType);
		st.setTitle("Updated Title");
		skillTypeService.updateSkillType(st);

		assertEquals(st, skillTypeService.getSkillTypeById(st.getSkillTypeId()));
	}

	@Test
	public void testDeleteSkillType() {
		List<SkillType> skills = new ArrayList<>();
		SkillType skillType = new SkillType();
		skillType.setSkillTypeId(4);

		// Mock DAO save() & findById()
		when(skillTypeRepository.findById(any(Integer.class)))
				.thenReturn(java.util.Optional.of(skillType));
		when(skillTypeRepository.save(any(SkillType.class))).thenReturn(skillType);
		skills.add(skillTypeService.createSkillType(skillType));

		// Mock DAO deleteById()
		skillTypeService.deleteSkillType(skillType.getSkillTypeId());
		skills.remove(skillType);

		when(skillTypeRepository.findAll()).thenReturn(skills);
		assertEquals(skills.size(), skillTypeService.getAllSkillTypes().size());
	}

	@Test
	public void testGetActiveSkillTypes() {
		List<SkillType> skills = new ArrayList<>();
		SkillType skillType = new SkillType("test", true);

		// Mock DAO save()
		when(skillTypeRepository.save(any(SkillType.class))).thenReturn(skillType);
		skills.add(skillTypeService.createSkillType(skillType));

		// Mock DAO findAllByIsActive()
		when(skillTypeRepository.findAllByIsActive(any(Boolean.class))).thenReturn(skills);

		assertEquals(skills.size(),
				skillTypeService.getActiveSkillTypes(true).size());
	}

	@Test
	public void testExistById() {
		when(skillTypeRepository.existsById(any(Integer.class))).thenReturn(true);
		assertTrue(skillTypeService.existsById(51));
	}
	
	@Test
	public void testExistByIdFail() {
		when(skillTypeRepository.existsById(any(Integer.class))).thenReturn(false);
		assertFalse(skillTypeService.existsById(511));
	}
}
