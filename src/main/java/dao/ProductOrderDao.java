package dao;

import POJO.ProductOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by przemek on 2017-06-18.
 */
@Transactional
public interface ProductOrderDao extends CrudRepository<ProductOrder, Integer> {

    ProductOrder findOne(int primaryKey);
    List<ProductOrder> findAll();
    ProductOrder save(ProductOrder u);
}
