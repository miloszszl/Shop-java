package POJO;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Embeddable
public class ProductOrderId implements java.io.Serializable{

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public ProductOrderId(){}

    public ProductOrderId(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
