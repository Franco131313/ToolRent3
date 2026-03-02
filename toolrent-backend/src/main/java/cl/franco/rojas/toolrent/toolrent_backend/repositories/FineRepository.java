package cl.franco.rojas.toolrent.toolrent_backend.repositories;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {

    // Unpaid fines of a client
    List<Fine> findByClientIdAndPaidFalse(Long clientId);

    // Fines of a loan
    List<Fine> findByLoanId(Long loanId);
}