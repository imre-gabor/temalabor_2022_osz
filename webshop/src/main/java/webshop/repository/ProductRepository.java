package webshop.repository;

import java.util.Optional;

import webshop.model.Product;

public interface ProductRepository {

    Optional<Product> findById(Integer id);
    
    Product save(Product product);
    
    //... további CRUD műveletek
}
