package dao;

import POJO.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
@Transactional
public interface ProviderDao extends CrudRepository<Provider, Integer> {

    List<Provider> findAll();
    Provider findOne(Integer primaryKey);
    Provider save(Provider c);
    boolean exists(Integer primaryKey);
    void delete(Provider entity);

}
