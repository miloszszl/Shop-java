package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.nio.BufferOverflowException;
import java.util.List;
import java.util.Set;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "Produkty")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idProduktu",unique = true, nullable = false)
    private int idProduct;

    @Column(name="nazwa")
    private String productName;

    @Column(name="opis")
    private String description;

    @Column(name="ilosc")
    private int amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idKategorii")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMarki")
    private Brand brand;

    @Column(name="cena")
    private BigDecimal productPrice;

    @Column(name="ocena")
    private double totalRate;

    //@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="idProductOrder.product")
    private Set<ProductOrder> productOrder;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idComment.product")
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idRate.product")
    private Set<Rate> rates;

    public Product(){}

    public Product(int idProduct, String productName, String description, int amount, Category category, Brand brand, BigDecimal productPrice, double totalRate, Set<ProductOrder> productOrder, Set<Comment> comments, Set<Rate> rates) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.brand = brand;
        this.productPrice = productPrice;
        this.totalRate = totalRate;
        this.productOrder = productOrder;
        this.comments = comments;
        this.rates = rates;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) throws BufferOverflowException{
        if(productName.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.productName = productName;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) throws BufferOverflowException{
        if(amount>999999 || amount<0)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.amount = amount;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) throws BufferOverflowException{
        if(productPrice.compareTo(new BigDecimal(9999.99))==1 || productPrice.compareTo(BigDecimal.ZERO)==-1)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.productPrice=productPrice;
        }
    }

    @JsonIgnore
    public double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(double TotalRate) throws BufferOverflowException{
        if(totalRate>10 || totalRate<0)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.totalRate = totalRate;
        }
    }

    @JsonIgnore
    public Set getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Set productOrder) {
        this.productOrder = productOrder;
    }

    @JsonIgnore
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @JsonIgnore
    public Set<Rate> getRates() {
        return rates;
    }

    public void setRates(Set<Rate> rates) {
        this.rates = rates;
    }
}
