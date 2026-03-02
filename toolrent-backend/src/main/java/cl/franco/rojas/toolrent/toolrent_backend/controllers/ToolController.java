package cl.franco.rojas.toolrent.toolrent_backend.controllers;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Tool;
import cl.franco.rojas.toolrent.toolrent_backend.services.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tools")
@RequiredArgsConstructor
public class ToolController {

    private final ToolService toolService;

    // GET all tools
    @GetMapping
    public List<Tool> getAllTools() {
        return toolService.getAllTools();
    }

    // GET tool by ID
    @GetMapping("/{id}")
    public Tool getToolById(@PathVariable Long id) {
        return toolService.getToolById(id);
    }

    // POST create tool
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tool createTool(@RequestBody Tool tool) {
        return toolService.createTool(tool);
    }

    // DELETE tool
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
    }
}