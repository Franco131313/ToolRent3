package cl.franco.rojas.toolrent.toolrent_backend.repositories;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Kardex;
import cl.franco.rojas.toolrent.toolrent_backend.entities.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface KardexRepository extends JpaRepository<Kardex, Long> {

    // Movement history by tool
    List<Kardex> findByTool(Tool tool);

    // Movement history by date range
    List<Kardex> findByMovementDateBetween(
            LocalDateTime start,
            LocalDateTime end
    );
}
