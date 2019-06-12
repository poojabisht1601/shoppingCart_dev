package com.productService.service;

import com.productService.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(int productId);
}
