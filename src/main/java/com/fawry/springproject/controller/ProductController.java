package com.fawry.springproject.controller;

import com.fawry.springproject.dto.ProductDto;
import com.fawry.springproject.entity.Product;
import com.fawry.springproject.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping(params = {"pageNo", "size"}) // *
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int size
    ) {
        return productService.getAllProducts(PageRequest.of(pageNo, size));
    }
    @GetMapping(params = {"pageNo", "size", "name", "sku"}) // *
    public Page<Product> filterProducts(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String sku) {
        return productService.filterProducts(name, sku, PageRequest.of(pageNo, size));
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


}
