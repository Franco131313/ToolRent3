package cl.franco.rojas.toolrent.toolrent_backend.services;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Kardex;
import cl.franco.rojas.toolrent.toolrent_backend.entities.Tool;
import cl.franco.rojas.toolrent.toolrent_backend.repositories.KardexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KardexService {

    private final KardexRepository kardexRepository;

    // Get all the kardex movements
    public List<Kardex> getAllMovements() {
        return kardexRepository.findAll();
    }

    // Get kardex movements by tool
    public List<Kardex> getMovementsByTool(Tool tool) {
        return kardexRepository.findByTool(tool);
    }

    // Get kardex movements by date range
    public List<Kardex> getMovementsByDateRange(
            LocalDateTime start,
            LocalDateTime end
    ) {
        return kardexRepository.findByMovementDateBetween(start, end);
    }

    // Record kardex movement(internal use)
    public Kardex save(Kardex kardex) {
        return kardexRepository.save(kardex);
    }
}