package com.fawry.springproject.service.category;

import com.fawry.springproject.entity.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);
    List<Category> getAllCategory();

}
