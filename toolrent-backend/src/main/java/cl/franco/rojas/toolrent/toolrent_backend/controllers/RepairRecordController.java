package cl.franco.rojas.toolrent.toolrent_backend.controllers;

import cl.franco.rojas.toolrent.toolrent_backend.entities.RepairRecord;
import cl.franco.rojas.toolrent.toolrent_backend.services.RepairRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repair-records")
@RequiredArgsConstructor
public class RepairRecordController {

    private final RepairRecordService repairRecordService;

    //GET all repair records
    @GetMapping
    public List<RepairRecord> getAll() {
        return repairRecordService.getAll();
    }

    //GET repair record by ID
    @GetMapping("/{id}")
    public RepairRecord getById(@PathVariable Long id) {
        return repairRecordService.getById(id);
    }

    //CREATE repair record
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RepairRecord create(@RequestBody RepairRecord repairRecord) {
        return repairRecordService.create(repairRecord);
    }


    //UPDATE repair record
    @PutMapping("/{id}")
    public RepairRecord update(
            @PathVariable Long id,
            @RequestBody RepairRecord repairRecord
    ) {
        return repairRecordService.update(id, repairRecord);
    }


    //DELETE repair record
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repairRecordService.delete(id);
    }
}
