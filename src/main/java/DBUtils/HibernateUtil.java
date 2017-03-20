package DBUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
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

    public List readAll(Class c)
    {
        SessionFactory sessionFactory=getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "FROM "+c.getSimpleName()).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Object readById(Class c,int id)
    {
        SessionFactory sessionFactory=getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Object result = session.get(c,id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List customReadMany(String s)
    {
        SessionFactory sessionFactory=getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery(s).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Object customReadOne(String s)
    {
        SessionFactory sessionFactory=getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Object result = session.createQuery(s).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void deleteById(Class c,int id)
    {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Object result = session.get(c,id);
        session.delete(result);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object obj)
    {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

    public void updateOne(Object obj)
    {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
    }

    public void updateMany(List li)
    {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        for ( Object o : (List<Object>) li) {
            session.update(o);
        }

        session.getTransaction().commit();
        session.close();
    }

    public void customQuery(String s)
    {
        SessionFactory sessionFactory=getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.createQuery(s);
        q.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
