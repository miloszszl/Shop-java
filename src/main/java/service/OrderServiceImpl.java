package service;

import DBUtils.DBUtil;
import DBUtils.HibernateUtil;
import POJO.Order;
import POJO.Product;
import POJO.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by przemek on 2017-06-10.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private DBUtil dbUtil = new HibernateUtil();


    @Override
    public Product findById(long id) {
        return null;
    }

    @Override
    public List<Order> findAllOrders() {
        return null;
    }

    @Override
    public void saveOrder(Order order) {
        dbUtil.create(order);
    }

}
