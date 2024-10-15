package com.fawry.springproject.service.product;

import com.fawry.springproject.dto.ProductDto;
import com.fawry.springproject.entity.Product;
import com.fawry.springproject.repository.ProductRepository;
import com.fawry.springproject.service.category.CategoryService;
import com.fawry.springproject.service.mechant.MerchantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final MerchantService merchantService;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> filterProducts(String name, String sku, Pageable pageable) {
        return productRepository.filterProducts(name, sku, pageable);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product with id " + id + " not found")
        );
    }

}