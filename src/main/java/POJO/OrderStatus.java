package POJO;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class OrderStatus {
    private int idOrderStatus;
    private String orderStatusName;

    public OrderStatus(){}

    public OrderStatus(int idOrderStatus, String orderStatusName) {
        this.idOrderStatus = idOrderStatus;
        this.orderStatusName = orderStatusName;
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
}
