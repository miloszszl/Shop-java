package POJO;

import java.security.Timestamp;
import java.sql.Time;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class Order {

    private int idOrder;
    private User user;
    private Timestamp orderDatetime;
    private Timestamp orderRealizationDatetime;
    private String note;
    private Provider provider;
    private OrderStatus orderStatus;
    private List productOrder;

    public Order(){}

    public Order(int idOrder, User user, Timestamp orderDatetime, Timestamp orderRealizationDatetime, String note, Provider provider, OrderStatus orderStatus,List productOrder) {
        this.idOrder = idOrder;
        this.user = user;
        this.orderDatetime = orderDatetime;
        this.orderRealizationDatetime = orderRealizationDatetime;
        this.note = note;
        this.provider = provider;
        this.orderStatus = orderStatus;
        this.productOrder=productOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Timestamp orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public Timestamp getOrderRealizationDatetime() {
        return orderRealizationDatetime;
    }

    public void setOrderRealizationDatetime(Timestamp orderRealizationDatetime) {
        this.orderRealizationDatetime = orderRealizationDatetime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List productOrder) {
        this.productOrder = productOrder;
    }
}
