package cl.franco.rojas.toolrent.toolrent_backend.services;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Tool;
import cl.franco.rojas.toolrent.toolrent_backend.repositories.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolService {

    private final ToolRepository toolRepository;

    //Get all tools
    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    //Get tool by ID
    public Tool getToolById(Long id) {
        return toolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool not found with id: " + id));
    }

    //Create tool
    public Tool createTool(Tool tool) {
        return toolRepository.save(tool);
    }

    //Delete tool
    public void deleteTool(Long id) {
        toolRepository.deleteById(id);
    }
}