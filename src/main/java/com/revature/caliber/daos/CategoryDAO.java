package com.revature.caliber.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Category;

@Repository
public interface CategoryDAO  {
    public Category get(int id);
    public Category getByID(int id);
    public Category update(Category category);
    public Category save(Category category);
    public void delete(Category category);
    public List<Category> list();
    public List<Category> listByCategory(int CategoryId);

}