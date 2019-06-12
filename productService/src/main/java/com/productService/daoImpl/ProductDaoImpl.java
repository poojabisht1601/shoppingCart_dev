package com.productService.daoImpl;

import com.productService.dao.ProductDao;
import com.productService.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public List<Product> getAllProduct() {
        List<Product> list= getSession().createCriteria(Product.class).list();
        return list;
    }

    @Override
    public Product getProductById(int productId) {
        Product product=(Product) getSession().get(Product.class,productId);
        return  product;
    }

    @Override
    public void addProduct(Product product) {
     getSession().save(product);
    }

    @Override
    public void delete(int prodId) {
        Product product=getProductById(prodId);
        getSession().delete(product);
    }

    @Override
    public Product updateProduct(Product product, int id) {
        Product prod=(Product) getSession().get(Product.class,id);
        prod.setDescription(product.getDescription());
        getSession().update(prod);
        return prod;
    }
}
