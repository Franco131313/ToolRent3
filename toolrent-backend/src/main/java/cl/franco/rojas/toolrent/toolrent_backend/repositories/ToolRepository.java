package cl.franco.rojas.toolrent.toolrent_backend.repositories;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
}