package cl.franco.rojas.toolrent.toolrent_backend.repositories;


import cl.franco.rojas.toolrent.toolrent_backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByRut(String rut);

    boolean existsByRut(String rut);
}
