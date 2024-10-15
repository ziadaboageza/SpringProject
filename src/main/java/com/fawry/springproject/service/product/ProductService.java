package com.fawry.springproject.service.product;

import com.fawry.springproject.dto.ProductDto;
import com.fawry.springproject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);//
    Page<Product> filterProducts(String name, String sku, Pageable pageable);//
    Product getProductById(Long id);

}
