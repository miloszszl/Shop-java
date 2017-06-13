package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_category",unique = true, nullable = false)
    private int id;

    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;

    public Category(){}

    public Category(int id, String categoryName, List<Product> products) {
        this.id = id;
        this.categoryName = categoryName;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int idCategory) {
        this.id = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setName(String categoryName) throws BufferOverflowException{
        if(categoryName.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.categoryName = categoryName;
        }
    }

    @JsonIgnore
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
