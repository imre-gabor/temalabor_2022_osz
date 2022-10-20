package webshop.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    
    private Integer id;
    private String name;
    
    private List<Product> products;
}
