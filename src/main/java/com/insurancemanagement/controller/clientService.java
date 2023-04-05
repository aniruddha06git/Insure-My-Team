package com.insurancemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.aniruddha.client.Client;
import com.aniruddha.client.ClientRepository;

public class clientService {
	
	
	@Autowired
    private static ClientRepository clientRepository;

    public static List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public static Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public static Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public static Client updateClient(Long id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            client.setId(id);
            return clientRepository.save(client);
        }
        return null;
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}

	

