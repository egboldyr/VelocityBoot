package web.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserRepository;
import web.entity.User;
import web.service.UserService;

/**
 * Created by EGBoldyr on 05.03.18.
 */

@Service
public class UserServiceImpl implements UserService {

    private Logger log = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
