package service;

import DBUtils.DBUtil;
import DBUtils.HibernateUtil;
import POJO.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by przemek on 2017-04-09.
 */

@Service("cityService")
public class CityServiceImpl implements CityService {

    private DBUtil dbUtil = new HibernateUtil();

    @Override
    public City findById(long id) {
        return null;
    }

    @Override
    public City findByName(String name) {
        return null;
    }

    @Override
    public void saveCity(City city) {

    }

    @Override
    public void updateCity(City city) {

    }

    @Override
    public void deleteCityById(long id) {

    }

    @Override
    public List<City> findAllCities() {
        return dbUtil.readAll(City.class);
    }

    @Override
    public void deleteAllCities() {

    }

    @Override
    public boolean isCityExist(City city) {
        return false;
    }
}
