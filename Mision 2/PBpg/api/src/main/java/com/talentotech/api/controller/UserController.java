package com.talentotech.api.controller;
import com.talentotech.api.model.User;
import com.talentotech.api.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController //Esto determina que la clase responde peticiones http y devuelve JSON
@RequestMapping("/api/users") //Define la ruta base del controlador

public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User create(@RequestBody User user) {

        return userRepository.save(user);

    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
