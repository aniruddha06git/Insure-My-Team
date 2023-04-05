package com.insurancemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.aniruddha.exception.DatabaseException;
import com.aniruddha.exception.InvalidInputException;
import com.aniruddha.exception.MissingDataException;
import com.aniruddha.model.Client;
import com.aniruddha.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<com.aniruddha.client.Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<com.aniruddha.client.Client> getClientById(Long id) throws DatabaseException, MissingDataException {
        if (id == null) {
            throw new MissingDataException("Client ID is missing");
        }
        try {
            return clientRepository.findById(id);
        } catch (DataAccessException ex) {
            throw new DatabaseException("Failed to access data", ex);
        }
    }

    public com.aniruddha.client.Client createClient(Client client) throws InvalidInputException, DatabaseException {
        if (client == null || client.getName() == null || ((List<com.aniruddha.client.Client>) client.getName()).isEmpty()) {
            throw new InvalidInputException("Invalid client data");
        }
        try {
            return clientRepository.save(client);
        } catch (DataAccessException ex) {
            throw new DatabaseException("Failed to access data", ex);
        }
    }

    public com.aniruddha.client.Client updateClient(Long id, Client client) throws InvalidInputException, DatabaseException {
        if (id == null || client == null || client.getName() == null || ((List<com.aniruddha.client.Client>) client.getName()).isEmpty()) {
            throw new InvalidInputException("Invalid client data");
        }
        Optional<com.aniruddha.client.Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            client.setId(id);
            try {
                return clientRepository.save(client);
            } catch (DataAccessException ex) {
                throw new DatabaseException("Failed to access data", ex);
            }
        } else {
            throw new MissingDataException("Client not found");
        }
    }

    public void deleteClient(Long id) throws DatabaseException, MissingDataException {
        if (id == null) {
            throw new MissingDataException("Client ID is missing");
        }
        try {
            clientRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new DatabaseException("Failed to access data", ex);
        }
    }
}
