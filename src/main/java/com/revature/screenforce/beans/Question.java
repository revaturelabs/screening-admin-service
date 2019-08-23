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

    /** ID of the question */
    @ApiModelProperty(value = "Question id")
    @Id
    @SequenceGenerator(name = "QUESTION_SEQUENCE", sequenceName = "QUESTION_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_SEQUENCE")
    @Column(name = "QUESTION_ID")
    private int questionId;

    /** Bucket question is contained in */
    @ApiModelProperty(value = "Bucket id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BUCKET_ID")
    private Bucket bucket;

    /** Active state of the question */
    @ApiModelProperty(value = "Boolean as to whether or not Question is active")
    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    /** Question description */
    @ApiModelProperty(value = "description of the Question")
    @Column(name = "QUESTION_TEXT")
    private String questionText;

    /** Sample answer 1 */
    @ApiModelProperty(value = "sample answer 1")
    @Column(name = "SAMPLE_ANSWER_1")
    private String sampleAnswer1;

    /** Sample answer 2 */
    @ApiModelProperty(value = "sample answer 2")
    @Column(name = "SAMPLE_ANSWER_2")
    private String sampleAnswer2;

    /** Sample answer 3 */
    @ApiModelProperty(value = "sample answer 3")
    @Column(name = "SAMPLE_ANSWER_3")
    private String sampleAnswer3;

    /** Sample answer 4 */
    @ApiModelProperty(value = "sample answer 4")
    @Column(name = "SAMPLE_ANSWER_4")
    private String sampleAnswer4;

    /** Sample answer 5 */
    @ApiModelProperty(value = "sample answer 5")
    @Column(name = "SAMPLE_ANSWER_5")
    private String sampleAnswer5;

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
     * @param bucket Bucket question is contained in
     * @param isActive Active state of the question
     * @param questionText Description of the question
     * @param sampleAnswer1 Sample answer 1
     * @param sampleAnswer2 Sample answer 2
     * @param sampleAnswer3 Sample answer 3
     * @param sampleAnswer4 Sample answer 4
     * @param sampleAnswer5 Sample answer 5
     */
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
     * Returns bucket question is contained in
     *
     * @return Bucket containing question
     */
    public Bucket getBucket() {
        return bucket;
    }

    /**
     * Set bucket to contain question
     *
     * @param bucket Bucket to contain question
     */
    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
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
     * Returns sample answer 1
     *
     * @return Sample answer 1
     */
    public String getSampleAnswer1() {
        return sampleAnswer1;
    }

    /**
     * Set sample answer 1
     *
     * @param sampleAnswer1 Sample answer 1
     */
    public void setSampleAnswer1(String sampleAnswer1) {
        this.sampleAnswer1 = sampleAnswer1;
    }

    /**
     * Returns sample answer 2
     *
     * @return Sample answer 2
     */
    public String getSampleAnswer2() {
        return sampleAnswer2;
    }

    /**
     * Set sample answer 2
     *
     * @param sampleAnswer2 Sample answer 2
     */
    public void setSampleAnswer2(String sampleAnswer2) {
        this.sampleAnswer2 = sampleAnswer2;
    }

    /**
     * Returns sample answer 3
     *
     * @return Sample answer 3
     */
    public String getSampleAnswer3() {
        return sampleAnswer3;
    }

    /**
     * Set sample answer 3
     *
     * @param sampleAnswer3 Sample answer 3
     */
    public void setSampleAnswer3(String sampleAnswer3) {
        this.sampleAnswer3 = sampleAnswer3;
    }

    /**
     * Returns sample answer 4
     *
     * @return Sample answer 4
     */
    public String getSampleAnswer4() {
        return sampleAnswer4;
    }

    /**
     * Set sample answer 4
     *
     * @param sampleAnswer4 Sample answer 4
     */
    public void setSampleAnswer4(String sampleAnswer4) {
        this.sampleAnswer4 = sampleAnswer4;
    }

    /**
     * Returns sample answer 5
     *
     * @return Sample answer 5
     */
    public String getSampleAnswer5() {
        return sampleAnswer5;
    }

    /**
     * Set sample answer 5
     *
     * @param sampleAnswer5 Sample answer 5
     */
    public void setSampleAnswer5(String sampleAnswer5) {
        this.sampleAnswer5 = sampleAnswer5;
    }

    /**
     * Compares equality between two questions
     *
     * @param o Question to compare
     * @return true if questions are equal, false otherwise
     */
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

    /**
     * Returns hashcode for question
     *
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getQuestionId(), getBucket(), getIsActive(), getQuestionText(), getSampleAnswer1(), getSampleAnswer2(), getSampleAnswer3(), getSampleAnswer4(), getSampleAnswer5());
    }

    /**
     * Converts question to string
     *
     * @return Question object's string representation
     */
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
