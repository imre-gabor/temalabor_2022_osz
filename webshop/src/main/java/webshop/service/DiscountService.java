package webshop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    
    @Transactional
    public void discountProductsByCategoryName(String catName, int percent) {
        
        List<Category> foundCategories = categoryRepository.findByNameWithProducts(catName);
        
        foundCategories
            .forEach(
                cat -> cat.getProducts()
                .forEach(p -> {
                    setDiscountedPrice(p, percent);
                    //productRepository.save(p); --> not needed because of Transactional
                }));        
    }

    private void setDiscountedPrice(Product product, int percent) {
        product.setPrice(product.getPrice()*(100-percent)/100);
    }
    
}
