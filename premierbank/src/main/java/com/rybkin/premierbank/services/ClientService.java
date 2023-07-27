package com.rybkin.premierbank.services;

import org.springframework.stereotype.Service;
import com.rybkin.premierbank.repositories.ClientRepository;
import com.rybkin.premierbank.entities.Client;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService
{
    private ClientRepository clientRepository;

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public Client getClient(int id) {
        Client client = null;
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            client = clientOptional.get();
        }
        return client;
    }

    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }
}
