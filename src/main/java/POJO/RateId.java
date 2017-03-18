package POJO;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class RateId {
    private User user;
    private Product product;

    public RateId(){}

    public RateId(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
