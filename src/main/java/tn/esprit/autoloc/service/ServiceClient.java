package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceClient implements IServiceClient {

    ClientRepository clientRepository;
    VehiculeRepository vehiculeRepository;

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

    @Override
    @Transactional
    public Client affecterVehicule(Long idClient, Long idVehicule) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client introuvable : " + idClient));
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable : " + idVehicule));

        if (!client.getVehicules().contains(vehicule)) {
            client.getVehicules().add(vehicule);
        }

        return clientRepository.save(client);
    }
}