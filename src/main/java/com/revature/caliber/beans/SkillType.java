package com.revature.caliber.beans;

import java.io.Serializable;

public class SkillType implements Serializable {

	private static final long serialVersionUID = -6863562903787298483L;
	@ApiModelProperty(value = "Skill type id")
	@Id
	@SequenceGenerator(name = "skillSeq", sequenceName = "SKILL_TYPE_SEQUENCE")
	@GeneratedValue(generator = "skillSeq", strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	private int id;
	private String title;
	
	public SkillType() {
		super();
	}
	
	public SkillType(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		SkillType other = (SkillType) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SkillType [id=" + id + ", title=" + title + "]";
	}
	
}
