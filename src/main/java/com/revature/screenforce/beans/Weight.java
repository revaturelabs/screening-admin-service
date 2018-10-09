package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;


/**
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 *
 * POJO for the weight object
 */
@ApiModel(value = "Weight", description = "Weights for Buckets within a SkillType, determining how a Bucket contributes to the final score")
@Entity
@Table(name = "WEIGHT")
public class Weight {

    @ApiModelProperty(value = "The weightId - primary key for the table")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WEIGHT_ID")
    private long weightId;

    @ApiModelProperty(value = "The actual weight needed for calculation")
    @Column(name = "WEIGHT_VALUE")
    private int weightValue;

    @ApiModelProperty(value = "the SkillType Id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SKILL_TYPE_ID")
    private SkillType skillType;

    @ApiModelProperty(value = "The Bucket Id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BUCKET_ID")
    private Bucket bucket;

    public Weight() {
        super();
    }

    public Weight(int weightId, int weightValue, SkillType skillType, Bucket bucket) {
        super();
        this.weightId = weightId;
        this.weightValue = weightValue;
        this.skillType = skillType;
        this.bucket = bucket;
    }

    /**
     * Getters and setters
     */
    public long getWeightId() {
        return weightId;
    }

    public void setWeightId(long weightId) {
        this.weightId = weightId;
    }

    public int getWeightValue() {
        return weightValue;
    }

    public void setWeightValue(int weightValue) {
        this.weightValue = weightValue;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight1 = (Weight) o;
        return getWeightId() == weight1.getWeightId() &&
                getWeightValue() == weight1.getWeightValue() &&
                getSkillType() == weight1.getSkillType() &&
                getBucket() == weight1.getBucket();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeightId(), getWeightValue(), getSkillType(), getBucket());
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weightId=" + weightId +
                ", weightValue=" + weightValue +
                ", skillType=" + skillType +
                ", bucket=" + bucket +
                '}';
    }
}
