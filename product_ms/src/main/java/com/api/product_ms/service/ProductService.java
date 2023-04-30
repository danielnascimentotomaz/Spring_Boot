package com.api.product_ms.service;

import com.api.product_ms.dto.ProductDto;
import com.api.product_ms.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDto> create(ProductDto productDto);

    List<ProductDto> getAll();

    Optional<ProductDto> getById(Long id);

    boolean inactive(Long id);

    void delete(Long id);
}


