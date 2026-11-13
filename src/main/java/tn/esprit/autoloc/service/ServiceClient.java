package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceClient implements IServiceClient {

    ClientRepository clientRepository;

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public Client modifyClient(Client client) {
        return clientRepository.save(client);
    }
}