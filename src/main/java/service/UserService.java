package service;

import POJO.User;
import java.util.List;

/**
 * Created by przemek on 2017-03-25.
 */

public interface UserService {

    User findById(long id);
    User findByName(String name);
    User findByLogin(String login);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    List<User> findAllUsers();
    void deleteAllUsers();
    boolean isUserExist(User user);
    boolean isEmailTaken(String user);
}
