package POJO.main;

import DBUtils.DBUtil;
import DBUtils.HibernateUtil;
import POJO.City;
import POJO.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class main {

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        DBUtil dbUtil=new HibernateUtil();

        //create
        City c=new City();
        c.setCityName("test123");

        List<User> u=new ArrayList<User>();
        u.add(new User());
        //c.setUsers(u);
        dbUtil.create(c);
        System.out.println("Successfully created " + c.getCityName());

        //readAll
        for ( City city : (List<City>) dbUtil.readAll(City.class)) {
            System.out.println( "City1 (" + city.getCityName() + ") ");
        }

        //readById
        System.out.println( "City2 (" + ((City)dbUtil.readById(City.class,c.getIdCity())).getCityName()+ ") ");

        //customReadMany
        List<City> cList=dbUtil.customReadMany("FROM City WHERE cityName LIKE '%a%'");
        for ( City city : cList) {
            System.out.println( "City3 (" + city.getCityName() + ") ");
        }

        //customReadOne
        City ci=(City)dbUtil.customReadOne("FROM City WHERE idCity=1");
        System.out.println( "City4 (" + ci.getCityName() + ") ");

        //deleteById
        System.out.println("DELETE BY ID");
        dbUtil.deleteById(City.class,c.getIdCity());

        //delete
        System.out.println("DELETE");
        City c2=new City();
        c2.setCityName("bbb2");
        dbUtil.create(c2);  //first create record
        dbUtil.delete(c2);  //delete it

        //updateOne
        System.out.println("UPDATE ONE");
        City c3=(City)dbUtil.readById(City.class,1);//select from database
        c3.setCityName("a1c2v3");       //change object
        dbUtil.updateOne(c3);           //update it

        //updateMany
        System.out.println("UPDATE MANY");
        cList=dbUtil.customReadMany("FROM City WHERE cityName LIKE '%a%'"); //select some objects
        cList.get(1).setCityName("millll"); //modify previously selected object
        cList.get(2).setCityName("przeee"); //modify previously selected object
        dbUtil.updateMany(cList);           //update them

        //customQuery
        System.out.println("CUSTOM QUERY");
        dbUtil.customQuery("INSERT INTO City(cityName) SELECT cityName FROM City WHERE id=1");




        //update


    }

}
