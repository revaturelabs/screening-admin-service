package com.revature.caliber.beans;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 *
 * @author Ethan Conner | 1805-WVU-AUG3 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 *
 * POJO for the weight object
 *
 */
@ApiModel(value = "Weight", description = "Weights for Buckets within a SkillType, determining how a Bucket contributes to the final score")
@Entity
@Table(name = "WEIGHT")
public class Weight {

	@ApiModelProperty(value = "The weightId - primary key for the table")
	@EmbeddedId
	@Column(name= "WEIGHT_ID")
	private WeightIdentity weightId;

	@ApiModelProperty(value = "The actual weight needed for calculation")
	@Column(name = "WEIGHT")
	private int weight;

	@ApiModelProperty(value="the SkillType Id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "SKILLTYPE_ID")
	private SkillType skillType;

	@ApiModelProperty(value="The Bucket Id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "BUCKET_ID")
	private Bucket bucket;

	public Weight() {
		super();
	}

	public Weight(WeightIdentity weightId, int weight, SkillType skillType, Bucket bucket) {
		super();
		this.weightId = weightId;
		this.weight = weight;
		this.skillType = skillType;
		this.bucket = bucket;
	}

	/**
	 * Getters and setters
	 */
	public WeightIdentity getWeightId() {
		return weightId;
	}

	public void setWeightId(WeightIdentity weightId) {
		this.weightId = weightId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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
				getWeight() == weight1.getWeight() &&
				getSkillType() == weight1.getSkillType() &&
				getBucket() == weight1.getBucket();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getWeightId(), getWeight(), getSkillType(), getBucket());
	}

	@Override
	public String toString() {
		return "Weight{" +
				"weightId=" + weightId +
				", weight=" + weight +
				", skillType=" + skillType +
				", bucket=" + bucket +
				'}';
	}
}
