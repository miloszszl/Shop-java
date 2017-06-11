package dao;

import POJO.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
@Transactional
public interface RateDao extends CrudRepository<Rate, Integer> {

    Rate findOne(int primaryKey);
    List<Rate> findAll();
    List<Rate> findByIdRate_Product_Id(int idProduct);           //not sure if works
    Rate save(Rate u);
    boolean exists(Integer primaryKey);
    void delete(Rate entity);
    void deleteAll();

}
