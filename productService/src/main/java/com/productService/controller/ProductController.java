package com.productService.controller;

import com.productService.model.Product;
import com.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/product")
public class ProductController {
@Autowired
    public ProductService productService;
    @GetMapping(value = "/getAllProduct",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProduct(){
        List<Product> prodList=productService.getAllProduct();
        return prodList;
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public   ResponseEntity<Product>  getProdById(@PathVariable("id") int id){
        Product product=productService.getProductById(id);
        if (product==null){
            return new  ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Product>(product,HttpStatus.OK);
        }
}}
