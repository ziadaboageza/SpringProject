package com.fawry.springproject.controller;

import com.fawry.springproject.entity.Category;
import com.fawry.springproject.service.category.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping // *
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }



}
