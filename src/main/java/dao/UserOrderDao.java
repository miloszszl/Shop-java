package dao;

import POJO.UserOrder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Miłosz on 09.06.2017.
 */
@Transactional
public interface UserOrderDao extends CrudRepository<UserOrder, Integer> {

    UserOrder findOne(int primaryKey);
    List<UserOrder> findAll();
    List<UserOrder> findByUser_IdUser(int primaryKey);
    List<UserOrder> findAllByOrderByOrderRealizationDatetimeAsc();    //not sure if works
    UserOrder save(UserOrder u);
    boolean exists(Integer primaryKey);
    void delete(UserOrder entity);
    void deleteAll();
    UserOrder findByIdUserOrder(int primaryKey);

}
