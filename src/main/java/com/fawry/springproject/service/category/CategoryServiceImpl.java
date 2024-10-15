package com.fawry.springproject.service.category;

import com.fawry.springproject.entity.Category;
import com.fawry.springproject.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Category Not Found")
                );
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

}
