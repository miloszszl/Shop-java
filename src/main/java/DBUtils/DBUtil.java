package DBUtils;

import java.util.List;

/**
 * Created by Miłosz on 19.03.2017.
 */
public interface DBUtil {
    void create(Object obj);
    List read(Class c);
    void update(Object obj);
}
