package dao;

import POJO.City;
import POJO.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
@Transactional
public interface CityDao extends CrudRepository<City, Integer> {

    Product findOne(int primaryKey);
    List<City> findAll();
    City findByCityNameIgnoreCase(String cityName);
    City save(City p);
    boolean exists(Integer primaryKey);
    void delete(City entity);

}
