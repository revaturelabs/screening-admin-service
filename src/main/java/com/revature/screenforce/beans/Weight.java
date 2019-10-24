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
@ApiModel(value = "Weight", description = "Weights for Categories within a SkillType, determining how a Category contributes to the final score")
@Entity
@Table(name = "WEIGHT")
public class Weight {
    /** Weight ID */
    @ApiModelProperty(value = "The weightId - primary key for the table")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WEIGHT_ID")
    private int weightId;

    /** Weight needed for calculations */
    @ApiModelProperty(value = "The actual weight needed for calculation")
    @Column(name = "WEIGHT_VALUE")
    private int weightValue;

    /** Skill type object */
    @ApiModelProperty(value = "the SkillType Id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SKILL_TYPE_ID")
    private SkillType skillType;

    /** Category object */
    @ApiModelProperty(value = "The Category Id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    /**
     * Instantiates a new weight
     */
    public Weight() {
        super();
    }

    /**
     * Instantiates a new weight
     *
     * @param weightId Weight ID
     * @param weightValue Weight value
     * @param skillType Skill type
     * @param category Category
     */
    public Weight(int weightId, int weightValue, SkillType skillType, Category category) {
        super();
        this.weightId = weightId;
        this.weightValue = weightValue;
        this.skillType = skillType;
        this.category = category;
    }

    /**
     * Returns ID for weight
     *
     * @return Weight ID
     */
    public int getWeightId() {
        return weightId;
    }

    /**
     * Sets ID for weight
     *
     * @param weightId Weight ID
     */
    public void setWeightId(int weightId) {
        this.weightId = weightId;
    }

    /**
     * Returns weight value
     *
     * @return Weight value
     */
    public int getWeightValue() {
        return weightValue;
    }

    /**
     * Sets weight value
     *
     * @param weightValue Weight value
     */
    public void setWeightValue(int weightValue) {
        this.weightValue = weightValue;
    }

    /**
     * Returns skill type
     *
     * @return Skill type
     */
    public SkillType getSkillType() {
        return skillType;
    }

    /**
     * Sets skill type
     *
     * @param skillType Skill type
     */
    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    /**
     * Returns category
     *
     * @return Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category
     *
     * @param category Category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Tests equality between weights
     *
     * @param o Weight to be compared
     * @return True if weights are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight1 = (Weight) o;
        return getWeightId() == weight1.getWeightId() &&
                getWeightValue() == weight1.getWeightValue() &&
                getSkillType() == weight1.getSkillType() &&
                getCategory() == weight1.getCategory();
    }

    /**
     * Returns weight hashcode
     *
     * @return Hashcode for weight
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWeightId(), getWeightValue(), getSkillType(), getCategory());
    }

    /**
     * Converts weight object to string
     *
     * @return String representation of weight
     */
    @Override
    public String toString() {
        return "Weight{" +
                "weightId=" + weightId +
                ", weightValue=" + weightValue +
                ", skillType=" + skillType +
                ", category=" + category +
                '}';
    }
}
