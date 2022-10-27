package webshop.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class InitDbService {
    
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    

    public void initSampleData() {
        Category category = categoryRepository.save(new Category(null, "cat1", null));
        Category othercat = categoryRepository.save(new Category(null, "othercat", null));
        
        productRepository.save(new Product(null, "prod1", 100.0, category));
        productRepository.save(new Product(null, "prod2", 200.0, category));
        productRepository.save(new Product(null, "prod3", 300.0, othercat));
    }

}
