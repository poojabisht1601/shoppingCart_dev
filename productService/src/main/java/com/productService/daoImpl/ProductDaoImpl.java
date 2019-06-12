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
}
