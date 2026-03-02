package cl.franco.rojas.toolrent.toolrent_backend.services;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Fine;
import cl.franco.rojas.toolrent.toolrent_backend.repositories.FineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FineService {

    private final FineRepository fineRepository;

    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

    public Fine getFineById(Long id) {
        return fineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fine not found with id: " + id));
    }

    public Fine createFine(Fine fine) {
        return fineRepository.save(fine);
    }

    public void markAsPaid(Long id) {
        Fine fine = getFineById(id);
        fine.setPaid(true);
        fineRepository.save(fine);
    }

    public List<Fine> getUnpaidFinesByClient(Long clientId) {
        return fineRepository.findByClientIdAndPaidFalse(clientId);
    }

    public List<Fine> getFinesByLoan(Long loanId) {
        return fineRepository.findByLoanId(loanId);
    }
}