package com.productService.dao;

import com.productService.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct();
    Product getProductById(int productId);
}
