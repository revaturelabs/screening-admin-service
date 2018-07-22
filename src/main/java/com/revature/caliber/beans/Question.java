package com.revature.caliber.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Question", description = "a question to ask a candidate, along with 5 sample answers "
		+ "of varying correctness")
@Entity 
@Table(name = "QUESTION")
public class Question implements Serializable{
	
	private static final long serialVersionUID = -6987859794752419355L;

	@ApiModelProperty(value = "Question id")
	@Id
	@SequenceGenerator(name = "QUESTION_SEQUENCE",initialValue= 1000, sequenceName = "QUESTION_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_SEQUENCE")
	@Column(name = "QUESTION_ID")
	private Integer questionId;
	
	@ApiModelProperty(value = "Bucket id")
	@Column(name = "BUCKET_ID")
	private Integer bucketId;
	
	@ApiModelProperty(value = "Boolean as to whether or not Question is active")
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	
	@ApiModelProperty(value = "description of the Question")
	@Column(name = "QUESTION_TEXT")
	private String questionText;
	
	@ApiModelProperty(value = "sample answer 1")
	@Column(name = "SAMPLE_ANSWER_1")
	private String sampleAnswer1;

	@ApiModelProperty(value = "sample answer 2")
	@Column(name = "SAMPLE_ANSWER_2")
	private String sampleAnswer2;

	@ApiModelProperty(value = "sample answer 3")
	@Column(name = "SAMPLE_ANSWER_3")
	private String sampleAnswer3;

	@ApiModelProperty(value = "sample answer 4")
	@Column(name = "SAMPLE_ANSWER_4")
	private String sampleAnswer4;

	@ApiModelProperty(value = "sample answer 5")
	@Column(name = "SAMPLE_ANSWER_5")
	private String sampleAnswer5;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Integer questionId, Integer bucketId, Boolean isActive, String questionText, String sampleAnswer1,
			String sampleAnswer2, String sampleAnswer3, String sampleAnswer4, String sampleAnswer5) {
		super();
		this.questionId = questionId;
		this.bucketId = bucketId;
		this.isActive = isActive;
		this.questionText = questionText;
		this.sampleAnswer1 = sampleAnswer1;
		this.sampleAnswer2 = sampleAnswer2;
		this.sampleAnswer3 = sampleAnswer3;
		this.sampleAnswer4 = sampleAnswer4;
		this.sampleAnswer5 = sampleAnswer5;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getBucketId() {
		return bucketId;
	}

	public void setBucketId(Integer bucketId) {
		this.bucketId = bucketId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getSampleAnswer1() {
		return sampleAnswer1;
	}

	public void setSampleAnswer1(String sampleAnswer1) {
		this.sampleAnswer1 = sampleAnswer1;
	}

	public String getSampleAnswer2() {
		return sampleAnswer2;
	}

	public void setSampleAnswer2(String sampleAnswer2) {
		this.sampleAnswer2 = sampleAnswer2;
	}

	public String getSampleAnswer3() {
		return sampleAnswer3;
	}

	public void setSampleAnswer3(String sampleAnswer3) {
		this.sampleAnswer3 = sampleAnswer3;
	}

	public String getSampleAnswer4() {
		return sampleAnswer4;
	}

	public void setSampleAnswer4(String sampleAnswer4) {
		this.sampleAnswer4 = sampleAnswer4;
	}

	public String getSampleAnswer5() {
		return sampleAnswer5;
	}

	public void setSampleAnswer5(String sampleAnswer5) {
		this.sampleAnswer5 = sampleAnswer5;
	}

	
	
	
}