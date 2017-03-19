package DBUtils;

import java.util.List;

/**
 * Created by Miłosz on 19.03.2017.
 */
public interface DBUtil {

    void create(Object obj);//insert

    List readAll(Class c);
    Object readById(Class c,int id);
    List customReadMany(String s);
    Object customReadOne(String s);

    void deleteById(Class c,int id);
    void delete(Object obj);

    void updateOne(Object obj);
    void updateMany(List li);

    void customQuery(String s); //only insert,update,delete
}
