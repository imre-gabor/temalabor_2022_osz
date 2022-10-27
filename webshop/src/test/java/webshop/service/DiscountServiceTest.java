package webshop.service;

import java.util.Arrays;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import webshop.model.Category;
import webshop.model.Product;
import webshop.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class DiscountServiceTest {

    @InjectMocks
    DiscountService discountService;
    
    @Mock
    CategoryRepository categoryRepository;
    

    @Test
    void testDiscountProductsByCategoryName() throws Exception {
        
        //ARRANGE
        Category cat1 = new Category(null, "test", Arrays.asList(new Product(null, "name1", 100.0, null)));
        Category cat2 = new Category(null, "test", Arrays.asList(new Product(null, "name2", 200.0, null)));
        when(categoryRepository.findByNameWithProducts("test"))
            .thenReturn(Arrays.asList(cat1, cat2));
        
        //ACT
        discountService.discountProductsByCategoryName("test", 10);
        
        //ASSERT
        assertThat(cat1.getProducts().get(0).getPrice()).isCloseTo(90.0, Offset.offset(0.0000001));
        assertThat(cat2.getProducts().get(0).getPrice()).isCloseTo(180.0, Offset.offset(0.0000001));
    }
    
}
