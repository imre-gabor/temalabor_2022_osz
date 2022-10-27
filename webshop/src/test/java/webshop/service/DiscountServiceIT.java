package webshop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

@SpringBootTest
@AutoConfigureTestDatabase
public class DiscountServiceIT {

    @Autowired
    DiscountService discountService;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    ProductRepository productRepository;
    
    @BeforeEach
    void init() {
        productRepository.deleteAllInBatch();
        categoryRepository.deleteAllInBatch();
    }
    
    
    @Test
    void testDiscountProductsByCategoryName() throws Exception {
        
        //ARRANGE
        Category category = categoryRepository.save(new Category(null, "cat1", null));
        Category othercat = categoryRepository.save(new Category(null, "othercat", null));
        
        productRepository.save(new Product(null, "prod1", 100.0, category));
        productRepository.save(new Product(null, "prod2", 200.0, category));
        productRepository.save(new Product(null, "prod3", 300.0, othercat));
        
        //ACT
        discountService.discountProductsByCategoryName("cat1", 10);
        
        //ASSERT
        assertThat(productRepository.findAll(Sort.by("id"))
                    .stream()
                    .map(Product::getPrice)
                    .toList())
            .containsExactly(90.0, 180.0, 300.0);       
    }
    
    @Test
    void testDiscountProductsByCategoryName2() throws Exception {
        
        //ARRANGE
        Category category = categoryRepository.save(new Category(null, "cat1", null));
        Category othercat = categoryRepository.save(new Category(null, "othercat", null));
        
        productRepository.save(new Product(null, "prod1", 100.0, category));
        productRepository.save(new Product(null, "prod2", 200.0, category));
        productRepository.save(new Product(null, "prod3", 300.0, othercat));
        
        //ACT
        discountService.discountProductsByCategoryName("cat1", 10);
        
        //ASSERT
        assertThat(productRepository.findAll(Sort.by("id"))
                    .stream()
                    .map(Product::getPrice)
                    .toList())
            .containsExactly(90.0, 180.0, 300.0);
        
    }
    
}
