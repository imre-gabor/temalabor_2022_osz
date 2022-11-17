package webshop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import webshop.dto.ProductDto;
import webshop.mapper.ProductMapper;
import webshop.model.Product;
import webshop.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    
    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> findAll(){
        return productMapper.productsToDtos(productRepository.findAll());
    }
    
    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productMapper.productToDto(
                productRepository.save(
                        productMapper.dtoToProduct(productDto)));
    }
    
}
