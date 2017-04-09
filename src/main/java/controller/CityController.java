package controller;

import java.util.List;

import POJO.City;
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

    private CityService cityService; // Service which will do all data retrieval/manipulation work.

    @Autowired
    public CityController(CityService cityService) { // Constructor injection, field injection is not recommended.
        this.cityService = cityService;
    }

    @RequestMapping(value = "/city/", method = RequestMethod.GET)
    public ResponseEntity<List<City>> listAllCities() {
        List<City> cities = cityService.findAllCities();
        if(cities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }


}