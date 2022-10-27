package webshop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
