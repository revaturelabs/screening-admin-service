package com.revature.caliber.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* Category with JPA annotations
*  
* @author Ethan Conner | 1805-WV | Richard Orr
*/
@ApiModel(value = "Category", description = "View Categories")
@Component
@Entity
@Table(name = "Category")
public class Category implements Serializable{
	private static final long serialVersionUID = 2435095816452768808L;

    @ApiModelProperty(value = "id of the Category")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_gen")
    @SequenceGenerator(name="category_gen", sequenceName="category_sequence", allocationSize=1)
    @Column(name = "Category_Id")
    private int categoryId;
    @ApiModelProperty(value = "name of the Categories title")
    @Column(name = "Title")
    private String title;
    
    @ApiModelProperty(value = "is the category currently active")
    @Column(name = "is_active")
    private boolean isActive;

	public Category() {
		super();
	}

	public Category(int categoryId, String title, boolean isActive) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.isActive = isActive;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + (isActive ? 1231 : 1237);
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		if (isActive != other.isActive)
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
		StringBuilder builder = new StringBuilder();
		builder.append("Category [categoryId=");
		builder.append(categoryId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}
	
	
        
    

}

