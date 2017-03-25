package POJO;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */

@Entity
@Table(name = "StatusyZamowien")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idStatusuZamowienia",unique = true, nullable = false)
    private int idOrderStatus;

    @Column(name = "nazwaStatusuZamowienia")
    private String orderStatusName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderStatus", cascade=CascadeType.ALL)
    private List<Order> orders;

    public OrderStatus(){}

    public OrderStatus(int idOrderStatus, String orderStatusName,List<Order> orders) {
        this.idOrderStatus = idOrderStatus;
        this.orderStatusName = orderStatusName;
        this.orders=orders;
    }

    public int getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(int idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
