package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Outlines the Question POJO
 *
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * @author Isaac Pawling | 1085-WVU | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Question", description = "a question to ask a candidate, along with 5 sample answers "
        + "of varying correctness")
@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

    private static final long serialVersionUID = -6987859794752419355L;

    /** ID of the question */
    @ApiModelProperty(value = "Question id")
    @Id
    @SequenceGenerator(name = "QUESTION_SEQUENCE", sequenceName = "QUESTION_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_SEQUENCE")
    @Column(name = "QUESTION_ID")
    private int questionId;

    /** Category question is contained in */
    @ApiModelProperty(value = "Category id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    /** Active state of the question */
    @ApiModelProperty(value = "Boolean as to whether or not Question is active")
    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    /** Question description */
    @ApiModelProperty(value = "description of the Question")
    @Column(name = "QUESTION_TEXT")
    private String questionText;

    /** Sample answer for the question */
    @ApiModelProperty(value = "sample answer")
    @Column(name = "SAMPLE_ANSWER")
    private String sampleAnswer;

    /**
     * Instantiates a new question
     */
    public Question() {
        super();
    }

    /**
     * Instantiates a new question
     *
     * @param questionId ID of the question
     * @param category Category question is contained in
     * @param isActive Active state of the question
     * @param questionText Description of the question
     * @param sampleAnswer Sample answer
	 */
    public Question(Integer questionId, Category category, Boolean isActive, String questionText, String sampleAnswer) {
        super();
        this.questionId = questionId;
        this.category = category;
        this.isActive = isActive;
        this.questionText = questionText;
        this.sampleAnswer = sampleAnswer;
    }

    /**
     * Returns ID of question
     *
     * @return ID of question
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Set ID of question
     *
     * @param questionId Question ID
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * Returns category question is contained in
     *
     * @return Category containing question
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set category to contain question
     *
     * @param category Category to contain question
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returns active state of the question
     *
     * @return Question's active state
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Set question's active state
     *
     * @param isActive Active state of question
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Returns question's description
     *
     * @return Question's description
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Set question's description
     *
     * @param questionText Question's description
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

	/**
	 * Returns sample answer
	 *
	 * @return Sample answer
	 */
	public String getSampleAnswer() {
        return sampleAnswer;
    }

	/**
	 * Sets the sample answer
	 *
	 * @param sampleAnswer Sample answer
	 */
	public void setSampleAnswer(String sampleAnswer) {
        this.sampleAnswer = sampleAnswer;
    }

    /**
     * Compares equality between two questions
     *
     * @param obj Question to compare
     * @return true if questions are equal, false otherwise
     */
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (isActive != other.isActive)
			return false;
		if (questionId != other.questionId)
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		if (sampleAnswer == null) {
			if (other.sampleAnswer != null)
				return false;
		} else if (!sampleAnswer.equals(other.sampleAnswer))
			return false;
		return true;
	}

    /**
     * Returns hashcode for question
     *
     * @return Hashcode
     */
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + questionId;
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		result = prime * result + ((sampleAnswer == null) ? 0 : sampleAnswer.hashCode());
		return result;
	}

    /**
     * Converts question to string
     *
     * @return Question object's string representation
     */
    @Override
	public String toString() {
		return "Question [questionId=" + questionId + ", category=" + category + ", isActive=" + isActive
				+ ", questionText=" + questionText + ", sampleAnswer=" + sampleAnswer + "]";
	}
}
