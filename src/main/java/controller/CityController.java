package controller;

import java.util.List;

import POJO.City;
import dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import service.CityService;
import POJO.City;

/**
 * Created by przemek on 2017-03-25.
 */

@RestController
public class CityController {

    @Autowired
    private CityDao cityDao;

    @RequestMapping(value = "/city/", method = RequestMethod.GET)
    public ResponseEntity<List<City>> listAllCities() {
        List<City> cities = cityDao.findAll();
        if(cities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

}