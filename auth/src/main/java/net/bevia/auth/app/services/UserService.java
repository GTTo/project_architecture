package net.bevia.auth.app.services;

import net.bevia.auth.domain.entities.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User save(User user);
    String login(String username, String password, HttpServletRequest request);
}
