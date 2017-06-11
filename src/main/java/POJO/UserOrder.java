package POJO;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */

@Entity
@Table(name = "user_order")
public class UserOrder {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user_order",unique = true, nullable = false)
    private int idUserOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    //@Temporal(TemporalType.TIMESTAMP)
    private Date orderDatetime;

    //@Temporal(TemporalType.TIMESTAMP)
    private Date orderRealizationDatetime;

    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_provider")
    private Provider provider;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order_status")
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idProductOrder.userOrder",cascade = CascadeType.ALL)
    private List<ProductOrder> productOrder;

    public UserOrder(){}

    public UserOrder(User user, Timestamp orderDatetime, Timestamp orderRealizationDatetime, String note, Provider provider, OrderStatus orderStatus, List productOrder) {

        this.user = user;
        this.orderDatetime = orderDatetime;
        this.orderRealizationDatetime = orderRealizationDatetime;
        this.note = note;
        this.provider = provider;
        this.orderStatus = orderStatus;
        this.productOrder=productOrder;
    }

    public int getIdOrder() {
        return idUserOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idUserOrder = idOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public Date getOrderRealizationDatetime() {
        return orderRealizationDatetime;
    }

    public void setOrderRealizationDatetime(Date orderRealizationDatetime) {
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

    public List<ProductOrder> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<ProductOrder> productOrder) {
        this.productOrder = productOrder;
    }
}
