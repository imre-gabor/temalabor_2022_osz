package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
       
}
