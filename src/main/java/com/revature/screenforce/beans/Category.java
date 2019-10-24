package com.revature.screenforce.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * Define category POJO
 *
 * @author Adil Iqbal | 1805-WVU-MAY29 | Richard Orr
 * @author Jeremy Straus | 1807-QC | Emily Higgins
 * @author Rishabh Rana | 1807-QC | Emily Higgins
 * @author Alpha Barry | 1807-QC | Emily Higgins
 * @author Omar Guzman | 1807-QC | Emily Higgins
 */
@ApiModel(value = "Category", description = "A Category which holds a set of related Questions")
@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 2435095816452768808L;

    /** ID of the category */
    @ApiModelProperty(value = "id of the Category")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQUENCE")
    @SequenceGenerator(name = "CATEGORY_SEQUENCE", sequenceName = "category_sequence", allocationSize = 1)
    @Column(name = "CATEGORY_ID")
    private int categoryId;

    /** Description of the category */
    @ApiModelProperty(value = "description of the Category")
    @Column(name = "CATEGORY_DESCRIPTION")
    private String categoryDescription;

    /** Denotes whether category is active or not */
    @ApiModelProperty(value = "denotes whether Category is active or not")
    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    /**
     * Instantiates a new category
     */
    public Category() {
        super();
    }

    /**
     * Instantiates a new category
     *
     * @param categoryId ID of category
     * @param categoryDescription Description of category
     * @param isActive Is category active?
     */
    public Category(Integer categoryId, String categoryDescription, Boolean isActive) {
        super();
        this.categoryId = categoryId;
        this.categoryDescription = categoryDescription;
        this.isActive = isActive;
    }

    /**
     * Returns the category ID
     *
     * @return Category ID
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Set category ID
     *
     * @param categoryId Category ID
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Returns category description
     *
     * @return Category description
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * Sets category description
     *
     * @param categoryDescription Category description
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     * Returns if category is active
     *
     * @return Category's active state
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Change the active state of the category
     *
     * @param isActive Category's active state
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Compares equality between categories
     *
     * @param o Category to compare
     * @return True if categories are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return getCategoryId() == category.getCategoryId() &&
                isActive == category.isActive &&
                Objects.equals(getCategoryDescription(), category.getCategoryDescription());
    }

    /**
     * Returns hashcode of category
     *
     * @return Hashcore
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getCategoryDescription(), isActive);
    }

    /**
     * Converts category to string
     *
     * @return String representation of category
     */
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
