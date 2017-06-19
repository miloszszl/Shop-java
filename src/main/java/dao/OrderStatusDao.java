package dao;

import POJO.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by przemek on 2017-06-18.
 */
@Transactional
public interface OrderStatusDao extends CrudRepository<OrderStatus, Integer> {

    OrderStatus findOne(int primaryKey);
}
