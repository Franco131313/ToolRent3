package cl.franco.rojas.toolrent.toolrent_backend.controllers;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Kardex;
import cl.franco.rojas.toolrent.toolrent_backend.entities.Tool;
import cl.franco.rojas.toolrent.toolrent_backend.services.KardexService;
import cl.franco.rojas.toolrent.toolrent_backend.services.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/kardex")
@RequiredArgsConstructor
public class KardexController {

    private final KardexService kardexService;
    private final ToolService toolService;

    // GET all the kardex movements
    @GetMapping
    public List<Kardex> getAll() {
        return kardexService.getAllMovements();
    }

    // GET kardex movements by tool
    @GetMapping("/tool/{toolId}")
    public List<Kardex> getByTool(@PathVariable Long toolId) {
        Tool tool = toolService.getToolById(toolId);
        return kardexService.getMovementsByTool(tool);
    }

    // GET kardex movements by date range
    @GetMapping("/between")
    public List<Kardex> getByDateRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end
    ) {
        return kardexService.getMovementsByDateRange(start, end);
    }
}