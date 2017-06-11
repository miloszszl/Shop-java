package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name="brand")
public class Brand {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_brand",unique = true, nullable = false)
    private int idBrand;

    private String brandName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "brand",cascade = CascadeType.ALL)
    private List<Product> products;

    public Brand(){}

    public Brand(int idBrand,String brandName, List<Product> products) {
        this.idBrand=idBrand;
        this.brandName = brandName;
        this.products = products;
    }

    //@JsonIgnore
    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) throws BufferOverflowException{

        if(brandName.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.brandName = brandName;
        }
    }

    //@JsonIgnore
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
