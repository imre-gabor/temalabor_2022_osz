package webshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;
import webshop.service.DiscountService;
import webshop.service.InitDbService;

@SpringBootApplication
@RequiredArgsConstructor
public class WebshopApplication implements CommandLineRunner {
    
    private final InitDbService initDbService;
    private final ProductRepository productRepository;
    private final DiscountService discountService;
    
    public static void main(String[] args) {        
        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initDbService.initSampleData();
        discountService.discountProductsByCategoryName("cat1", 10);
        productRepository.findAll().forEach(p -> System.out.format("%s:%f%n", p.getName(), p.getPrice()));
    }
    
    
    
}
