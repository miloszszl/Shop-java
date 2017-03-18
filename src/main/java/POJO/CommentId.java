package POJO;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class CommentId {

    private Product product;
    private Order order;

    public CommentId(){}

    public CommentId(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
