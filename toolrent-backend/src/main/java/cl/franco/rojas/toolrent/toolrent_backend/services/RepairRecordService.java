package cl.franco.rojas.toolrent.toolrent_backend.services;

import cl.franco.rojas.toolrent.toolrent_backend.entities.RepairRecord;
import cl.franco.rojas.toolrent.toolrent_backend.repositories.RepairRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairRecordService {

    private final RepairRecordRepository repairRecordRepository;

    //Get all repair records
    public List<RepairRecord> getAll() {
        return repairRecordRepository.findAll();
    }

    //Get repair records by ID
    public RepairRecord getById(Long id) {
        return repairRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repair record not found"));
    }

    //Create repair record
    public RepairRecord create(RepairRecord repairRecord) {
        return repairRecordRepository.save(repairRecord);
    }

    //Update repair record
    public RepairRecord update(Long id, RepairRecord updatedRecord) {
        RepairRecord existing = getById(id);

        existing.setStatus(updatedRecord.getStatus());
        existing.setDescription(updatedRecord.getDescription());
        existing.setRepairCost(updatedRecord.getRepairCost());

        return repairRecordRepository.save(existing);
    }
    //Delete repair record
    public void delete(Long id) {
        repairRecordRepository.deleteById(id);
    }
}