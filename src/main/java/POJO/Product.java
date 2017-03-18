package POJO;

import java.math.BigDecimal;
import java.nio.BufferOverflowException;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class Product {
    private int idProduct;
    private String productName;
    private String description;
    private int amount;
    private Category category;
    private Brand brand;
    private BigDecimal productPrice;
    private double totalRate;
    private List productOrder;
    private Comment comment;
    private Rate rate;

    public Product(){}

    public Product(int idProduct, String productName, String description, int amount, Category category, Brand brand, BigDecimal productPrice, double totalRate, List<ProductOrder> productOrder, Comment comment, Rate rate) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.brand = brand;
        this.productPrice = productPrice;
        this.totalRate = totalRate;
        this.productOrder = productOrder;
        this.comment = comment;
        this.rate = rate;
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

    public List getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List productOrder) {
        this.productOrder = productOrder;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}
