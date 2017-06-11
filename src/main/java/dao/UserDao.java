package dao;

import POJO.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    User findOne(int primaryKey);
    List<User> findAll();
    User findByEmailIgnoreCase(String email);
    User save(User u);
    User findByLoginIgnoreCase(String login);
    User findByLogin(String login);
    boolean exists(Integer primaryKey);
    @Query("select count(*) from User u where u.login = :login")
    int findByLoginReturnInt(@Param("login") String login);
    void delete(User entity);
    void deleteAll();

}
