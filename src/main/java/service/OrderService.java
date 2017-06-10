package service;

import POJO.Order;
import POJO.Product;

import java.util.List;

/**
 * Created by przemek on 2017-06-10.
 */

public interface OrderService {

    Product findById(long id);
    List<Order> findAllOrders();
    void saveOrder(Order order);
}

