package cl.franco.rojas.toolrent.toolrent_backend.repositories;

import cl.franco.rojas.toolrent.toolrent_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}
