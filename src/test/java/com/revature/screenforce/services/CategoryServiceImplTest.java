package com.revature.screenforce.services;

import com.revature.screenforce.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.screenforce.Application;
import com.revature.screenforce.beans.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Category Tests using JUnit
 *
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CategoryServiceImplTest {
	@Mock CategoryRepository categoryRepository;
	@Mock QuestionService questionService;
	@Mock WeightService weightService;
	@InjectMocks private CategoryServiceImpl categoryService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateCategoryFirst() {
		// Mock DAO save()
		when(categoryRepository.save(any(Category.class))).thenReturn(new Category());
		assertNotNull(categoryService.createCategory(new Category()));
	}

	@Test
	public void testCreateNullCategory() {
		// Mock DAO save()
		when(categoryRepository.save(any(Category.class))).thenReturn(null);

		Category category = null;
		assertNull(categoryService.createCategory(category));
	}

	@Test
	public void testGetAllCategories() {
		List<Category> categories = new ArrayList<>();

		// Mock DAO findAll()
		when(categoryRepository.findAll()).thenReturn(categories);

		int nCategories = categories.size();
		assertEquals(nCategories, categoryService.getAllCategories().size());
	}

	@Test
	public void testUpdateCategory() {
		Category category = new Category();
		category.setCategoryId(404);
		category.setCategoryDescription("Description");

		// Mock DAO findById() & save()
		when(categoryRepository.findById(category.getCategoryId()))
				.thenReturn(java.util.Optional.of(category));
		when(categoryRepository.save(any(Category.class))).thenReturn(category);

		Category b = categoryService.getCategoryById(404);
		String description = "Updated Description";
		b.setCategoryDescription(description);
	    categoryService.updateCategory(b);

		assertEquals(description, categoryService.getCategoryById(404)
				.getCategoryDescription());
	}

	@Test
	public void testDeleteCategory() {
		Category category = new Category();

		// Mock DAO save() & findById()
		when(categoryRepository.save(category)).thenReturn(category);
		when(categoryRepository.findById(any(Integer.class)))
				.thenReturn(Optional.of(new Category()));

		category = categoryService.createCategory(category);
		category.setCategoryId(404);
		categoryService.deleteCategory(category.getCategoryId());

		// getCategoryById is set to return new Category() if no category with ID is
		// found
		assertEquals(new Category(),
				categoryService.getCategoryById(category.getCategoryId()));
	}

	@Test
	public void testGetCategoryById() {
		Category category = new Category();
		category.setCategoryId(404);

		// Mock DAO findById()
		when(categoryRepository.findById(category.getCategoryId())).
				thenReturn(java.util.Optional.of(category));

		assertEquals(category.getCategoryId(),
				categoryService.getCategoryById(category.getCategoryId()).getCategoryId());
	}

	@Test
	public void testExistById() {
		when(categoryRepository.existsById(any(Integer.class))).thenReturn(true);
		assertTrue(categoryService.existsById(406));
	}

	@Test
	public void testExistByIdFail() {
		when(categoryRepository.existsById(any(Integer.class))).thenReturn(false);
		assertFalse(categoryService.existsById(4061));
	}
}
