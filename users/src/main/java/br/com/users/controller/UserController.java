package br.com.users.controller;

import br.com.users.model.User;
import br.com.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        User u = userRepository.save(user);

        URI uri = uriComponentsBuilder.path("/api/users/{id}").buildAndExpand(u.getId()).toUri();

        return ResponseEntity.created(uri).body(u);
    }
}
