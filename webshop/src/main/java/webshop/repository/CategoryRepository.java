package webshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @EntityGraph(attributePaths = "products")
    @Query("SELECT c FROM Category c WHERE c.name=:name")
    List<Category> findByNameWithProducts(String name);    
}
