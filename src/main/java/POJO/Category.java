package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name="Kategorie")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idKategorii",unique = true, nullable = false)
    private int id;
    @Column(name = "nazwa")
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categories")
    private List<Product> products;

    public Category(){}

    public Category(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int idCategory) {
        this.id = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String categoryName) throws BufferOverflowException{
        if(categoryName.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.name = categoryName;
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
