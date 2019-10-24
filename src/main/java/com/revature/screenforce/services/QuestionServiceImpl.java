package com.revature.screenforce.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.screenforce.beans.Question;
import com.revature.screenforce.repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the QuestionService
 * Calls the appropriate QuestionDAO method
 * 
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 * @author Adil Iqbal	 | 1805-WVU | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */

@Service
public class QuestionServiceImpl implements QuestionService {
	/** Question repository */
	private QuestionRepository questionRepository;

	/**
	 * Instantiates a new question service
	 * @param questionRepository Question repository
	 */
	@Autowired
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	/**
	 * Add a question to the database
	 *
	 * @param question transient question to be persisted
	 * @return Question
	 */
	@Transactional
	@Override
	public Question create(Question question) {
		return questionRepository.save(question);	
	}

	/**
	 * Gets all questions
	 *
	 * @return Question List
	 */
	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	/**
	 * Gets questions based on categoryId
	 * @param categoryId of category
	 * @return List of questions in the specified category
	 */
	@Override
	public List<Question> getQuestionsByCategory(int categoryId) {
		return questionRepository.findAllByCategoryCategoryId(categoryId);
	}

	/**
	 * Delete question by id
	 * @param questionId Id of question
	 * No return
	 */
	@Transactional
	@Override
	public void deleteByQuestionId(int questionId) {
		questionRepository.deleteById(questionId);
	}

	/**
	 * Get question by questionId
	 * @param questionId Id of the question to filter by
	 * @return Question object with matching questionId
	 */
	@Override
	public Question getByQuestionId(int questionId) {
		return questionRepository.findById(questionId).orElse(null);
	}

	/**
	 * update question
	 * @param question - a Question object
	 * @return updated Question object
	 */
	@Override
	@Transactional
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	/**
	 * Delete all questions associated with a specific bucket
	 * @param bucketId Id of bucket to filter by
	 */
	@Override
	@Transactional
	public void deleteByCategoryId(int categoryId) {
	  List<Question> q = new ArrayList<>(this.getQuestionsByCategory(categoryId));
		for (Question question : q) {
			deleteByQuestionId(question.getQuestionId());
		}
	}

	/**
	 * Check if id exist
	 * @param id ID of question
	 */
	@Override
	public boolean existsById(int questionId) {
		return questionRepository.existsById(questionId);
	}
}
