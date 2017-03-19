package DBUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * Created by Miłosz on 19.03.2017.
 */
public class HibernateUtil implements DBUtil {

    private SessionFactory getSessionFactory() {


        /////////////////////first option
        SessionFactory sessionFactory=null;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );

        }
        //////////////////////////////////////////////////
        //////////////////////////second option
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ///////////////////////////
        return sessionFactory;
    }


    public void create(Object obj)
    {
        SessionFactory sessionFactory=getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    public List read(Class c)
    {
        SessionFactory sessionFactory=getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "FROM "+c.getSimpleName()).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void update(Object obj)
    {

    }

}
