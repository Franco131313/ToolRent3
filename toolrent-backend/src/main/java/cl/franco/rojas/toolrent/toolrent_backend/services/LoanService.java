package cl.franco.rojas.toolrent.toolrent_backend.services;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Loan;
import cl.franco.rojas.toolrent.toolrent_backend.repositories.LoanRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    //Get all loans
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    //Get loan by ID
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));
    }

    //Create loan
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    //Delete loan
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}

