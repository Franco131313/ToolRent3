package cl.franco.rojas.toolrent.toolrent_backend.controllers;

import cl.franco.rojas.toolrent.toolrent_backend.entities.User;
import cl.franco.rojas.toolrent.toolrent_backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //GET all users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //GET user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    //POST create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //DELETE user
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
