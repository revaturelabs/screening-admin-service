package com.revature.screenforce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.screenforce.beans.Bucket;
import com.revature.screenforce.repositories.BucketRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementation for our Bucket service layer
 *  
 *  @author adil iqbal 		| 1805-WVU-MAY29 | Richard Orr
 *  @author Theo Thompson 	| 1805-WVU-MAY29 | Richard Orr
 *  @author Rishabh Rana 	| 1807-QC | Emily Higgins
 *  @author Alpha Barry 	| 1807-QC | Emily Higgins
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	/** Category repository */
	private CategoryRepository categoryRepository;

	/** Question service */
	private QuestionService questionService;

	/** Weight service */
	private WeightService weightService;

	/**
	 * Instantiates a new category service
	 *
	 * @param categoryRepository Category repository
	 * @param questionService Question service
	 * @param weightService Weight service
	 */
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository,
							 QuestionService questionService,
							 WeightService weightService) {
		this.categoryRepository = categoryRepository;
		this.questionService = questionService;
		this.weightService = weightService;
	}

	/**
	 * creates a new category in the DB
	 * @param category - a new category
	 * @return Category obj w/ updated id
	 */
	@Transactional
	@Override
	public Category createCategory(Category category) {
		if(category != null && category != new Category()) {
			return categoryRepository.save(category);
		} 
		else {
			return null;
		}
	}

	/**
	 * Fetches all categories
	 * @return list of categories
	 */
	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;
	}

	/**
	 * Updates category information
	 * @param category - category to update
	 */
	@Override
	@Transactional
	public void updateCategory(Category category) {
		if(!category.getCategoryDescription().isEmpty()) {
			categoryRepository.save(category);
		}
	}

	/**
	 * Removes a category with the specified Id
	 * @param categoryId - id of the category to be deleted
	 * No return
	 */
	@Override
	@Transactional
	public void deleteCategory(int categoryId) {
		weightService.deleteAllByCategoryId(categoryId);
		questionService.deleteByCategoryId(categoryId);
		categoryRepository.deleteById(categoryId);
	}

	/**
	 * Gets a category by its Id
	 * @param categoryId Id of category to filter by
	 * @return category or null if id is not found
	 */
	@Override
	public Category getCategoryById(int categoryId) {
		return categoryRepository.findById(categoryId).orElse(new Category());
	}

	/**
	 * Check if id exist
	 * @param bid Category ID
	 */
	@Override
	public boolean existsById(int categoryId) {
		return categoryRepository.existsById(categoryId);
	}
}
