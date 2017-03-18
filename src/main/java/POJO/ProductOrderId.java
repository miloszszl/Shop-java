package POJO;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class ProductOrderId {

    private Order order;
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
