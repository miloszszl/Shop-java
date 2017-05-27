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
    private int idCategory;
    @Column(name = "nazwa")
    private String categoryName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category")
    private List<Product> products;

    public Category(){}

    public Category(int idCategory,String categoryName, List<Product> products) {
        this.idCategory=idCategory;
        this.categoryName = categoryName;
        this.products = products;
    }

    @JsonIgnore
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) throws BufferOverflowException{
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
