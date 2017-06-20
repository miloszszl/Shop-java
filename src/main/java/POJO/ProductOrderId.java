package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Embeddable
public class ProductOrderId implements java.io.Serializable{

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UserOrder userOrder;
    @ManyToOne(cascade = CascadeType.ALL)
    //@JsonIgnore
    private Product product;

    public ProductOrderId(){}

    public ProductOrderId(UserOrder userOrder, Product product) {
        this.userOrder = userOrder;
        this.product = product;
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString(){
        return "toString";
    }
}
