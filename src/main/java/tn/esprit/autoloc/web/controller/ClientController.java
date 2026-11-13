package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IServiceClient;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    IServiceClient serviceClient;

    @GetMapping("/retrieve-all-clients")
    public List<Client> getClients() {
        return serviceClient.retrieveAllClients();
    }

    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long id) {
        return serviceClient.retrieveClient(id);
    }

    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client client) {
        return serviceClient.addClient(client);
    }

    @DeleteMapping("/remove-client/{client-id}")
    public void removeClient(@PathVariable("client-id") Long id) {
        serviceClient.removeClient(id);
    }

    @PutMapping("/modify-client")
    public Client modifyClient(@RequestBody Client client) {
        return serviceClient.modifyClient(client);
    }
}