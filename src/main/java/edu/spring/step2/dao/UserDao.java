package edu.spring.step2.dao;

import edu.spring.step2.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {

    private List<User> userList = Arrays.asList(
            new User("admin", "admin"),
            new User("user1", "user1"));

    public List<User> getAllUsers() {
        return userList;
    }
}
