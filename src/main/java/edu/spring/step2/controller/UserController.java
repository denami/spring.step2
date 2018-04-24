package edu.spring.step2.controller;

import edu.spring.step2.model.User;
import edu.spring.step2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String check(@ModelAttribute("userFromServer") User user) {

        for ( User u : userService.getAllUsers()) {
            if (u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
                return "Valid";
            }
        }

        return "Invalid";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer", new User());
        modelAndView.setViewName("users_check_page");
        return modelAndView;
    }

}
