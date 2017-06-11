package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.nio.BufferOverflowException;
import java.util.Set;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_product",unique = true, nullable = false)
    private int id;

    private String name;

    private String description;

    private int amount;

    private String photo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private Category category; // Change to plural form here once, or change in everywhere in the FE.

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_brand")
    private Brand brand;

    private BigDecimal price;

    private double totalRate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="idProductOrder.product",cascade = CascadeType.ALL)
    private Set<ProductOrder> productOrder;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idComment.product",cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idRate.product",cascade = CascadeType.ALL)
    private Set<Rate> rates;

    public Product(){}

    public Product(int id, String name, String description, int amount, Category category, Brand brand, BigDecimal price, double totalRate, Set<ProductOrder> productOrder, Set<Comment> comments, Set<Rate> rates) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.totalRate = totalRate;
        this.productOrder = productOrder;
        this.comments = comments;
        this.rates = rates;
    }

    public int getId() {
        return id;
    }

    public void setId(int idProduct) {
        this.id = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) throws BufferOverflowException{
        if(productName.length()>50)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.name = productName;
        }
    }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal productPrice) throws BufferOverflowException{
        if(productPrice.compareTo(new BigDecimal(9999.99))==1 || productPrice.compareTo(BigDecimal.ZERO)==-1)
        {
            throw new BufferOverflowException();
        }
        else
        {
            this.price =productPrice;
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
