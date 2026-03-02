package cl.franco.rojas.toolrent.toolrent_backend.controllers;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Fine;
import cl.franco.rojas.toolrent.toolrent_backend.services.FineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fines")
@RequiredArgsConstructor
public class FineController {

    private final FineService fineService;

    // GET all fines
    @GetMapping
    public List<Fine> getAllFines() {
        return fineService.getAllFines();
    }

    // GET fine by id
    @GetMapping("/{id}")
    public Fine getFineById(@PathVariable Long id) {
        return fineService.getFineById(id);
    }
    // GET unpaid fines by client
    @GetMapping("/client/{clientId}/unpaid")
    public List<Fine> getUnpaidFinesByClient(@PathVariable Long clientId) {
        return fineService.getUnpaidFinesByClient(clientId);
    }

    // GET fines by loan
    @GetMapping("/loan/{loanId}")
    public List<Fine> getFinesByLoan(@PathVariable Long loanId) {
        return fineService.getFinesByLoan(loanId);
    }
    //POST create fine
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fine createFine(@RequestBody Fine fine) {
        return fineService.createFine(fine);
    }

    // Mark fine as paid
    @PutMapping("/{id}/pay")
    public void payFine(@PathVariable Long id) {
        fineService.markAsPaid(id);
    }


}