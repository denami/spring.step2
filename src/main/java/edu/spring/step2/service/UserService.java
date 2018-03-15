package edu.spring.step2.service;

import edu.spring.step2.dao.UserDao;
import edu.spring.step2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

}
