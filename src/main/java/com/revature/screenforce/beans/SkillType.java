package com.revature.screenforce.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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
	
	@ApiModelProperty(value = "Skill type id")
	@Id
	@SequenceGenerator(name = "skillSeq", sequenceName = "SKILL_TYPE_SEQUENCE", allocationSize=1)
	@GeneratedValue(generator = "skillSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "SKILL_TYPE_ID")
	private int skillTypeId;
	
	@ApiModelProperty(value = "Name of the skill")
	@Column(name = "TITLE")
	private String title;
	
    @ApiModelProperty(value = "is the SkillType currently active")
    @Column(name = "is_active")
    private boolean isActive;
	
	public SkillType() {
		super();
	}

	public SkillType(String title, boolean isActive) {
		this.title = title;
		this.isActive = isActive;
	}

	/**
	 * getters & setters
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SkillType skillType = (SkillType) o;
		return getSkillTypeId() == skillType.getSkillTypeId() &&
				isActive() == skillType.isActive() &&
				Objects.equals(getTitle(), skillType.getTitle());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSkillTypeId(), getTitle(), isActive());
	}

	@Override
	public String toString() {
		return "SkillType{" +
				"skillTypeId=" + skillTypeId +
				", title='" + title + '\'' +
				", isActive=" + isActive +
				'}';
	}
}
