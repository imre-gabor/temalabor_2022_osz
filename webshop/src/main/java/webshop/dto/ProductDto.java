package webshop.dto;

import lombok.Data;
import webshop.model.Category;

@Data
public class ProductDto {
    
    private Integer id;
    private String name;
    private double price;
    private CategoryDto category;
    
}
