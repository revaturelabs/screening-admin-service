package com.revature.caliber.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.beans.SkillType;

/**
 * SkillTypeService Tests using JUnit
 * @author Alpha Barry | 1807-QC | Emily Higgins
 */

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
