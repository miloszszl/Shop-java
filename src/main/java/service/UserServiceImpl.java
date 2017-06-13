package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import POJO.*;
import DBUtils.DBUtil;
import DBUtils.HibernateUtil;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by przemek on 2017-03-25.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    private DBUtil dbUtil = new HibernateUtil();

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers() {

        return userDao.findAll();
        //return dbUtil.readAll(User.class);
    }

    public User findById(long id) {

        List<User> users = dbUtil.readAll(User.class);

        for (User user : users) {
            if (user.getIdUser() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for (User user : users) {
            if (user.getFirstName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByLogin(String login) {
        List<User> users = dbUtil.readAll(User.class);

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        user.setIdUser(((int) counter.incrementAndGet())); // counter.incrementAndGet() returns long type so our IdUser
        //users.add(user);                                   // should be long? For now temp fix is to cast to int.

        System.out.println("Tworzenie usera w bazie: " + user.getLogin() + " " + user.getEmail());
        dbUtil.create(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {
        users.removeIf(user -> user.getIdUser() == id);
    }

    public boolean isUserExist(User user) {
        return findByLogin(user.getLogin()) != null;
    }

    @Override
    public boolean isEmailTaken(String email) {
        List<User> users = dbUtil.readAll(User.class);

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void deleteAllUsers() {
        users.clear();
    }
}
