package com.revature.screenforce.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.SkillType;
import com.revature.screenforce.services.SkillTypeService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class SkillTypeServiceImplTest {
	@Autowired
	SkillTypeService skillTypeService;

	@Test
	public void testGetAllSkillTypes() {
		SkillType skill = new SkillType();
		int allBefore = skillTypeService.getAllSkillTypes().size();
		skillTypeService.createSkillType(skill);
		assertEquals((allBefore+1), skillTypeService.getAllSkillTypes().size());
	}

	@Test
	public void testCreateSkillType() {
		SkillType skill = new SkillType();
		int allSkillTypesBeforeCreateNew = skillTypeService.getAllSkillTypes().size();
		skillTypeService.createSkillType(skill);
		assertEquals(allSkillTypesBeforeCreateNew + 1, skillTypeService.getAllSkillTypes().size());
	}

	@Test
	public void testGetSkillType() {
		SkillType skill = new SkillType("Intelligence", true);
		skill = skillTypeService.createSkillType(skill);
		
		assertEquals(skill, skillTypeService.getSkillType(skill.getSkillTypeId()));
	}

	@Test
	public void testUpdateSkillType() {
		SkillType skillType = new SkillType();
		skillType = skillTypeService.createSkillType(skillType);
		String newTitle = "New Title";
		skillType.setTitle(newTitle);
		skillTypeService.updateSkillType(skillType);
		assertEquals(newTitle, skillTypeService.getSkillTypeById(skillType.getSkillTypeId()).getTitle());
	}

	@Test
	public void testDeleteSkillType() {
		SkillType skillType = new SkillType();
		int before = skillTypeService.getAllSkillTypes().size();
		skillTypeService.createSkillType(skillType);
		skillTypeService.deleteSkillType(skillType.getSkillTypeId());
		int after = skillTypeService.getAllSkillTypes().size();
		assertEquals(before, after);
	}

	@Test
	public void testGetActiveSkillTypes() {
		SkillType skillType = new SkillType("test", true);
		int activeSkillTypes = skillTypeService.getActiveSkillTypes(true).size();
		skillTypeService.createSkillType(skillType);
		assertEquals(activeSkillTypes+1, skillTypeService.getActiveSkillTypes(true).size());
	}

	@Test
	public void testExistById() {
		assertTrue(skillTypeService.existsById(51));
	}
	
	@Test
	public void testExistByIdFail() {
		assertFalse(skillTypeService.existsById(511));
	}
}
