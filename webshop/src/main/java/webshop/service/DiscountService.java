package webshop.service;

import java.util.List;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

public class DiscountService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    
    public void discountProductsByCategoryName(String catName, int percent) {
        
        List<Category> foundCategories = categoryRepository.findyByName(catName);
        
        foundCategories
            .forEach(
                cat -> cat.getProducts()
                .forEach(p -> {
                    setDiscountedPrice(p, percent);
                    productRepository.save(p);
                }));
        
        foundCategories
        .forEach(System.out::println);
    }

    private void setDiscountedPrice(Product product, int percent) {
        product.setPrice(product.getPrice()*(100-percent)/100);
    }
    
}
