package service;

import POJO.City;

import java.util.List;

/**
 * Created by przemek on 2017-04-09.
 */
public interface CityService {

    City findById(long id);
    City findByName(String name);
    void saveCity(City city);
    void updateCity(City city);
    void deleteCityById(long id);
    List<City> findAllCities();
    void deleteAllCities();
    boolean isCityExist(City city);
}
