package cl.franco.rojas.toolrent.toolrent_backend.services;

import cl.franco.rojas.toolrent.toolrent_backend.entities.User;
import cl.franco.rojas.toolrent.toolrent_backend.enums.UserRole;
import cl.franco.rojas.toolrent.toolrent_backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //Get all  users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    //Get user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    //Create User
    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        //Defaul value
        if (user.getRole() == null){
            user.setRole(UserRole.ADMIN);
        }

        return userRepository.save(user);
    }

    //Delete user
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

}
