package dao;

import POJO.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
public interface BrandDao extends CrudRepository<Brand, Integer> {

    Brand findOne(Integer primaryKey);
    List<Brand> findAll();
    Brand save(Brand brand);
    Brand findByBrandName(String brandName);
    boolean exists(Integer primaryKey);
    void delete(Brand entity);

}
