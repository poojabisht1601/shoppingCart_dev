package com.productService.serviceImpl;

import com.productService.dao.ProductDao;
import com.productService.model.Product;
import com.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductDao productDao;
    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }
    public Product getProductById(int productId){
        return productDao.getProductById(productId);
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void delete(int prodId) {
        productDao.delete(prodId);
    }

    @Override
    public Product updateProduct(Product product, int id) {
        return  productDao.updateProduct(product,id);
    }

}
