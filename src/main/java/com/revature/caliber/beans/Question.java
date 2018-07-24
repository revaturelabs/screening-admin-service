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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bucketId == null) ? 0 : bucketId.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		result = prime * result + ((sampleAnswer1 == null) ? 0 : sampleAnswer1.hashCode());
		result = prime * result + ((sampleAnswer2 == null) ? 0 : sampleAnswer2.hashCode());
		result = prime * result + ((sampleAnswer3 == null) ? 0 : sampleAnswer3.hashCode());
		result = prime * result + ((sampleAnswer4 == null) ? 0 : sampleAnswer4.hashCode());
		result = prime * result + ((sampleAnswer5 == null) ? 0 : sampleAnswer5.hashCode());
		return result;
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
		if (bucketId == null) {
			if (other.bucketId != null)
				return false;
		} else if (!bucketId.equals(other.bucketId))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		if (sampleAnswer1 == null) {
			if (other.sampleAnswer1 != null)
				return false;
		} else if (!sampleAnswer1.equals(other.sampleAnswer1))
			return false;
		if (sampleAnswer2 == null) {
			if (other.sampleAnswer2 != null)
				return false;
		} else if (!sampleAnswer2.equals(other.sampleAnswer2))
			return false;
		if (sampleAnswer3 == null) {
			if (other.sampleAnswer3 != null)
				return false;
		} else if (!sampleAnswer3.equals(other.sampleAnswer3))
			return false;
		if (sampleAnswer4 == null) {
			if (other.sampleAnswer4 != null)
				return false;
		} else if (!sampleAnswer4.equals(other.sampleAnswer4))
			return false;
		if (sampleAnswer5 == null) {
			if (other.sampleAnswer5 != null)
				return false;
		} else if (!sampleAnswer5.equals(other.sampleAnswer5))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [questionId=");
		builder.append(questionId);
		builder.append(", bucketId=");
		builder.append(bucketId);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", questionText=");
		builder.append(questionText);
		builder.append(", sampleAnswer1=");
		builder.append(sampleAnswer1);
		builder.append(", sampleAnswer2=");
		builder.append(sampleAnswer2);
		builder.append(", sampleAnswer3=");
		builder.append(sampleAnswer3);
		builder.append(", sampleAnswer4=");
		builder.append(sampleAnswer4);
		builder.append(", sampleAnswer5=");
		builder.append(sampleAnswer5);
		builder.append("]");
		return builder.toString();
	}
	
}