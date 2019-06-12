package com.productService.controller;

import com.productService.model.Product;
import com.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
    @PostMapping(value = "/add",headers = "Accept=application/json")
    public ResponseEntity<Void> createUser(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}",headers = "Accept=application/json")
    public ResponseEntity<Product> delete(@PathVariable("id") int id){
        Product product=productService.getProductById(id);
        if(product==null){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "/update",headers = "Accept=application/json")
    public ResponseEntity<String> update(@RequestBody Product currentProduct){
        Product product=productService.getProductById(currentProduct.getProdId());
        if(product==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        productService.updateProduct(currentProduct,currentProduct.getProdId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
