package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import java.util.List;

public interface IServiceClient {

    List<Client> retrieveAllClients();

    Client retrieveClient(Long idClient);

    Client addClient(Client client);

    void removeClient(Long idClient);

    Client modifyClient(Client client);

    Client affecterVehicule(Long idClient, Long idVehicule);
}