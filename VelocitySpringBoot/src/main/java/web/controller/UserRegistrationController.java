package web.controller;

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

    private static final String URL_USER_FORM   = "/user_form";
    private static final String URL_USER_ADD   = "/user_add";
    private static final String URL_USERS_LIST = "/users_list";

    @Autowired
    private UserService service;

    @RequestMapping(value = URL_USER_FORM, method = RequestMethod.GET)
    public String addUserForm() {
        return "user_add";
    }

    @RequestMapping(value = URL_USER_ADD, method = RequestMethod.POST)
    public String addUser(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("email") String email) {
        User newUser = new User(login, password, email);
        /* Поля из WEB-формы приходят но дальше ломаемся по SQLException (NOT NULL)
         * проблема пока не диагностирована, переключился временно на JAX-WS + Boot*/
        service.saveUser(newUser);
        return "redirect:/users_list";
    }

    @RequestMapping(value = URL_USERS_LIST, method = RequestMethod.GET)
    public String getUsers(@ModelAttribute("model") ModelMap model) {
        List<User> users = service.findAll();
        model.addAttribute("users", users);
        return "users_list";
    }

}
