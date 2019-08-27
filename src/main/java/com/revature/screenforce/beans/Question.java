package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
//import java.util.Objects;

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

    @ApiModelProperty(value = "Question id")
    @Id
    @SequenceGenerator(name = "QUESTION_SEQUENCE", sequenceName = "QUESTION_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_SEQUENCE")
    @Column(name = "QUESTION_ID")
    private int questionId;

    @ApiModelProperty(value = "Bucket id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BUCKET_ID")
    private Bucket bucket;

    @ApiModelProperty(value = "Boolean as to whether or not Question is active")
    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @ApiModelProperty(value = "description of the Question")
    @Column(name = "QUESTION_TEXT")
    private String questionText;

    @ApiModelProperty(value = "sample answer")
    @Column(name = "SAMPLE_ANSWER")
    private String sampleAnswer;


    public Question() {
        super();
    }

    public Question(Integer questionId, Bucket bucket, Boolean isActive, String questionText, String sampleAnswer) {
        super();
        this.questionId = questionId;
        this.bucket = bucket;
        this.isActive = isActive;
        this.questionText = questionText;
        this.sampleAnswer = sampleAnswer;
    }

    /**
     * Getters and setters
     */
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getSampleAnswer() {
        return sampleAnswer;
    }

    public void setSampleAnswer1(String sampleAnswer) {
        this.sampleAnswer = sampleAnswer;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (bucket == null) {
			if (other.bucket != null)
				return false;
		} else if (!bucket.equals(other.bucket))
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

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bucket == null) ? 0 : bucket.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + questionId;
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		result = prime * result + ((sampleAnswer == null) ? 0 : sampleAnswer.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Question [questionId=" + questionId + ", bucket=" + bucket + ", isActive=" + isActive
				+ ", questionText=" + questionText + ", sampleAnswer=" + sampleAnswer + "]";
	}
}