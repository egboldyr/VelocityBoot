package web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserRepository;
import web.entity.User;
import web.service.UserService;

import java.util.List;

/**
 * Created by EGBoldyr on 05.03.18.
 */

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private Logger logger = LogManager.getLogger(UserRegistrationController.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getUsers(@ModelAttribute("model") ModelMap model) {
        List<User> users = repository.findAll();
        model.addAttribute("users", users);
        return "users_list";
    }

}
