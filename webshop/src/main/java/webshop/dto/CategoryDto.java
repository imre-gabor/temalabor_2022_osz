package webshop.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDto {
    private Integer id;
    private String name;
    private List<ProductDto> products;
}
