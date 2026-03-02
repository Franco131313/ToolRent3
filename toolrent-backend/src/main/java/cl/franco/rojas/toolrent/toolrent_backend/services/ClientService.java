package cl.franco.rojas.toolrent.toolrent_backend.services;

import cl.franco.rojas.toolrent.toolrent_backend.entities.Client;
import cl.franco.rojas.toolrent.toolrent_backend.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    //Get all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    //Get client by ID
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    //Create client
    public Client createClient(Client client) {
        if (clientRepository.existsByRut(client.getRut())) {
            throw new RuntimeException("Client with this RUT already exists");
        }
        return clientRepository.save(client);
    }

    //Delete client
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


}
