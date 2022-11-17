package webshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import webshop.dto.ProductDto;
import webshop.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category.products", ignore = true)
    ProductDto productToDto(Product product);
    
    List<ProductDto> productsToDtos(List<Product> product);

    Product dtoToProduct(ProductDto productDto);
}
