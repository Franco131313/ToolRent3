package cl.franco.rojas.toolrent.toolrent_backend.repositories;

import cl.franco.rojas.toolrent.toolrent_backend.entities.RepairRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRecordRepository extends JpaRepository<RepairRecord, Long> {

    List<RepairRecord> findByToolId(Long toolId);

    List<RepairRecord> findByStatus(String status);
}