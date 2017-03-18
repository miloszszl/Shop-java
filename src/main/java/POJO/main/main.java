package POJO.main;


import POJO.City;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class main {

    public static void main(String[] args) {

        City c=new City();
        c.setCityName("bleeeee");
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + c.toString());

    }

    public static SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(City.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }

}
