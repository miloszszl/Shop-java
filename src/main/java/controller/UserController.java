package controller;

import java.util.List;

import POJO.AccountType;
import dao.AccountTypeDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import service.UserService;
import POJO.User;

/**
 * Created by przemek on 2017-03-25.
 */

@RestController
public class UserController {

    private UserService userService; // Service which will do all data retrieval/manipulation work.

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountTypeDao accountTypeDao;

    @Autowired
    public UserController(UserService userService) { // Constructor injection, field injection is not recommended.
        this.userService = userService;
    }

    @RequestMapping(value = "/api/users/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userDao.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users/{login}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("login") String login) {

        System.out.println("Fetching User with login " + login);
        User user = userDao.findByLoginIgnoreCase(login);

        if (user == null) {
            System.out.println("User with id " + login + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!principal.equals(user.getLogin())) { // Check for admin later
            System.out.println("This user can access only himself");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {

        AccountType accountType=accountTypeDao.findByAccountTypeNameIgnoreCase("ROLE_USER");
        user.setAccountType(accountType);

        if(userDao.findByLoginIgnoreCase(user.getLogin())!=null){
            System.out.println("A User with name --- " + user.getLogin() + " --- already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        if(userDao.findByEmailIgnoreCase(user.getEmail())!=null){
            System.out.println("A User with email --- " + user.getEmail() + " --- already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userDao.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getIdUser()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);

        User currentUser=userDao.findOne((int) id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getFirstName());
        //currentUser.setAge(user.getAge());
        //currentUser.setSalary(user.getSalary());

        userService.updateUser(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {

        System.out.println("Fetching & Deleting User with id " + id);

        User user = userDao.findOne((int)id);//userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userDao.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/api/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");

        userDao.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // SECURITY TEST ONLY
    @RequestMapping("/users")
    public @ResponseBody
    String getUsers() {
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }
}