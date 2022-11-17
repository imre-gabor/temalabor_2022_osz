package webshop.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import webshop.model.Product;
import webshop.repository.ProductRepository;

@Controller
public class ProductController {
    
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        List<Product> products = productRepository.findAll();
        model.put("allproducts", products);
        model.put("product", new Product());
        return "products";
    }
    
    @PostMapping("/products")
    public String createProduct(Product product) {
        productRepository.save(product);
        return "redirect:/";
    }
    
}
