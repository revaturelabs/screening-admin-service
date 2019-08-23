package com.revature.screenforce.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Outlines the SkillType POJO
 * 
 * @author Isaac Pawling | 1085-WVU | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 */
@ApiModel(value = "SkillType", description = "SkillType corresponding to an overall training track, associated with a number of Buckets")
@Entity
@Table(name = "SKILL_TYPE")
public class SkillType implements Serializable {

	private static final long serialVersionUID = -6863562903787298483L;

	/** ID of the skill type */
	@ApiModelProperty(value = "Skill type id")
	@Id
	@SequenceGenerator(name = "skillSeq", sequenceName = "SKILL_TYPE_SEQUENCE", allocationSize=1)
	@GeneratedValue(generator = "skillSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "SKILL_TYPE_ID")
	private int skillTypeId;

	/** Name of the skill type */
	@ApiModelProperty(value = "Name of the skill")
	@Column(name = "TITLE")
	private String title;

	/** Active state of the skill type */
    @ApiModelProperty(value = "is the SkillType currently active")
    @Column(name = "is_active")
    private boolean isActive;

	/**
	 * Instantiates a new skill type
	 */
	public SkillType() {
		super();
	}

	/**
	 * Instantiates a new skill type
	 *
	 * @param title Name of the skill type
	 * @param isActive Active state of the skill type
	 */
	public SkillType(String title, boolean isActive) {
		this.title = title;
		this.isActive = isActive;
	}

	/**
	 * Returns unique class version ID
	 *
	 * @return Unique class version ID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * Returns skill type ID
	 *
	 * @return ID of skill type
	 */
	public int getSkillTypeId() {
		return skillTypeId;
	}

	/**
	 * Sets ID for skill type
	 *
	 * @param skillTypeId Skill type ID
	 */
	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	/**
	 * Returns skill type name
	 *
	 * @return Name of skill type
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets skill type name
	 *
	 * @param title Name of skill type
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns active state of skill type
	 *
	 * @return Active state of skill type
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets active state of skill type
	 *
	 * @param isActive Active state of skill type
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Compares skill type objects for equality
	 *
	 * @param o Skill type to compare
	 * @return True if skill types are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SkillType skillType = (SkillType) o;
		return getSkillTypeId() == skillType.getSkillTypeId() &&
				isActive() == skillType.isActive() &&
				Objects.equals(getTitle(), skillType.getTitle());
	}

	/**
	 * Returns hashcode of skill type
	 *
	 * @return Hashcode of skill type
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getSkillTypeId(), getTitle(), isActive());
	}

	/**
	 * Converts skill type to string
	 *
	 * @return String representation of skill type
	 */
	@Override
	public String toString() {
		return "SkillType{" +
				"skillTypeId=" + skillTypeId +
				", title='" + title + '\'' +
				", isActive=" + isActive +
				'}';
	}
}
