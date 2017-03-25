package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import POJO.*;
import org.springframework.stereotype.Service;

/**
 * Created by przemek on 2017-03-25.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static {
        users = populateDummyUsers();
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findById(long id) {
        for (User user : users) {
            if (user.getIdUser() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        user.setIdUser(((int) counter.incrementAndGet())); // counter.incrementAndGet() returns long type so our IdUser
        users.add(user);                                   // should be long? For now temp fix is to cast to int.
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {
        users.removeIf(user -> user.getIdUser() == id);
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }

    private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(((int) counter.incrementAndGet()),
                "Adam",
                "Jensen",
                "adamjensen",
                "hunter2",
                "1some@mail.com",
                "123123123",
                "salt",
                new City(1,"Krakuf"),
                "streetname",
                "house number",
                new AccountType(1,"Basic"),
                null,
                null));

        users.add(new User(((int) counter.incrementAndGet()),
                "Gordon",
                "Freeman",
                "half-life",
                "hunter2",
                "2some@mail.com",
                "123123123",
                "salt",
                new City(1,"Krakuf"),
                "streetname",
                "house number",
                new AccountType(1,"Basic"),
                null,
                null));

        users.add(new User(((int) counter.incrementAndGet()),
                "Duke",
                "Nukem",
                "dukenukem",
                "hunter2",
                "3some@mail.com",
                "123123123",
                "salt",
                new City(1,"Krakuf"),
                "streetname",
                "house number",
                new AccountType(1,"Basic"),
                null,
                null));
        return users;
    }

    public void deleteAllUsers() {
        users.clear();
    }
}
