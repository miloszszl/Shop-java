package POJO.main;

import DBUtils.DBUtil;
import DBUtils.HibernateUtil;
import POJO.City;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class main {

    public static void main(String[] args) {

        DBUtil dbUtil=new HibernateUtil();
        //create
        City c=new City();
        c.setCityName("mmm3");
        dbUtil.create(c);
        System.out.println("Successfully created " + c.getCityName());

        //read
        for ( City city : (List<City>) dbUtil.read(City.class)) {
            System.out.println( "City (" + city.getCityName() + ") ");
        }

        //update


    }

}
