package POJO;

import javax.persistence.*;
import java.security.Timestamp;
import java.sql.Time;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */

@Entity
@Table(name = "Zamowienia")
public class Order {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idZamowienia",unique = true, nullable = false)
    private int idOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUzytkownika")
    private User user;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name ="dataZamowienia")
    private Timestamp orderDatetime;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name ="dataRealizacjiZamowienia")
    private Timestamp orderRealizationDatetime;

    @Column(name ="uwaga")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDostawcy")
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idStatusuZamowienia")
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProductOrder.order")
    private List<ProductOrder> productOrder;

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
