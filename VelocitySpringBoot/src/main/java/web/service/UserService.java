package web.service;

import web.entity.User;

import java.util.List;

/**
 * Created by kpetkov on 05.03.18.
 */

public interface UserService {
    User saveUser(User user);
    List<User> findAll();
}
