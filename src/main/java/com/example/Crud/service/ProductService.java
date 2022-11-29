package com.example.Crud.service;

import com.example.Crud.entity.Product;
import com.example.Crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
//Post
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    //Post all
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
//get
    public List<Product> getProducts(){
        return repository.findAll();
    }
//getAll
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
//get by name
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
         repository.deleteById(id);
         return "Product Removed" + id;

    }
    public Product updateProduct(Product product){
       Product existingProduct=repository.findById(product.getId()).orElse(null);
       existingProduct.setName(product.getName());
       existingProduct.setQuantity(product.getQuantity());
       existingProduct.setPrice(product.getPrice());
       return repository.save(existingProduct);
    }
}
