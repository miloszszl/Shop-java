package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */

@Entity
@Table(name = "order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_order_status",unique = true, nullable = false)
    private int idOrderStatus;

    private String orderStatusName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderStatus", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<UserOrder> userOrders;

    public OrderStatus(){}

    public OrderStatus(int idOrderStatus, String orderStatusName,List<UserOrder> userOrders) {
        this.idOrderStatus = idOrderStatus;
        this.orderStatusName = orderStatusName;
        this.userOrders = userOrders;
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

    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }
}
