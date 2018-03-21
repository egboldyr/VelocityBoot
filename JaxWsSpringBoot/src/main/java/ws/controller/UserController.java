package ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by EGBoldyr on 21.03.18.
 */

@RestController
public class UserController {

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
}
