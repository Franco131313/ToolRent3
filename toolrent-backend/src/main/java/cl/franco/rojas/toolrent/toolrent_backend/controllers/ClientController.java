package cl.franco.rojas.toolrent.toolrent_backend.controllers;


import cl.franco.rojas.toolrent.toolrent_backend.entities.Client;
import cl.franco.rojas.toolrent.toolrent_backend.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    //GET all clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    //GET client by ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    //POST create client
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    //DELETE client
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
