package net.bevia.auth.app.services;

import net.bevia.auth.domain.entities.User;
import net.bevia.auth.domain.repositories.UserRepository;
import net.bevia.auth.infrastructure.services.jwt.JwtService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public User save(User user) {
        String encodedPass = Base64.getEncoder().encodeToString(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(encodedPass);
        return userRepository.save(user);
    }

    @Override
    public String login(String username, String password, HttpServletRequest request) {
        Optional<User> user= userRepository.findByUsername(username);
        if(!user.isPresent()) return "El usuario no existe";
        String receivedPassword = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
        return (user.get().getPassword().equals(receivedPassword)) ? jwtService.getJwt(username, request) : "Error LOGIN";
    }
}
