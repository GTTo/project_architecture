package net.bevia.auth.infrastructure.ui.rest;

import net.bevia.auth.app.services.UserService;
import net.bevia.auth.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletRequest request){
        return userService.login(user.getUsername(), user.getPassword(), request);

    }
}
