package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    public Question(Integer questionId, Bucket bucket, Boolean isActive, String questionText, String sampleAnswer1,
                    String sampleAnswer2, String sampleAnswer3, String sampleAnswer4, String sampleAnswer5) {
        super();
        this.questionId = questionId;
        this.bucket = bucket;
        this.isActive = isActive;
        this.questionText = questionText;
        this.sampleAnswer1 = sampleAnswer1;
        this.sampleAnswer2 = sampleAnswer2;
        this.sampleAnswer3 = sampleAnswer3;
        this.sampleAnswer4 = sampleAnswer4;
        this.sampleAnswer5 = sampleAnswer5;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(getQuestionId(), question.getQuestionId()) &&
                Objects.equals(getBucket(), question.getBucket()) &&
                Objects.equals(getIsActive(), question.getIsActive()) &&
                Objects.equals(getQuestionText(), question.getQuestionText()) &&
                Objects.equals(getSampleAnswer1(), question.getSampleAnswer1()) &&
                Objects.equals(getSampleAnswer2(), question.getSampleAnswer2()) &&
                Objects.equals(getSampleAnswer3(), question.getSampleAnswer3()) &&
                Objects.equals(getSampleAnswer4(), question.getSampleAnswer4()) &&
                Objects.equals(getSampleAnswer5(), question.getSampleAnswer5());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId(), getBucket(), getIsActive(), getQuestionText(), getSampleAnswer1(), getSampleAnswer2(), getSampleAnswer3(), getSampleAnswer4(), getSampleAnswer5());
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", bucket=" + bucket +
                ", isActive=" + isActive +
                ", questionText='" + questionText + '\'' +
                ", sampleAnswer1='" + sampleAnswer1 + '\'' +
                ", sampleAnswer2='" + sampleAnswer2 + '\'' +
                ", sampleAnswer3='" + sampleAnswer3 + '\'' +
                ", sampleAnswer4='" + sampleAnswer4 + '\'' +
                ", sampleAnswer5='" + sampleAnswer5 + '\'' +
                '}';
    }
}