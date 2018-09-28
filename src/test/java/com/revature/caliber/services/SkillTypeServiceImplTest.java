package com.revature.caliber.services;

import com.revature.caliber.Application;
import com.revature.caliber.beans.SkillType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * SkillTypeService Tests using JUnit
 * @author Alpha Barry | 1807-QC | Emily Higgins
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetSkillType() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSkillType() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSkillType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetActiveSkillTypes() {
		fail("Not yet implemented");
	}

}
