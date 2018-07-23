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
* @author Ethan Conner | 1805-WV
*/
@ApiModel(value = "Category", description = "View Categories")
@Component
@Entity
@Table(name = "Catigory")
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
		// TODO Auto-generated constructor stub
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
        
    

}