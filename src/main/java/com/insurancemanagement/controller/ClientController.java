package com.insurancemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddha.client.Client;

@RestController
public class ClientController {
	@GetMapping("/api/clients")
	public List<Client> getAllClients() {
	    return clientService.getAllClients();
	}
	@GetMapping("/api/clients/{id}")
	public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id){
		
	    Optional<Client> client = java.util.Optional.empty();
		try {
			client = clientService.getClientById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if (client == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(client);
	}
	@PostMapping("/api/clients")
	public Client createClient(@RequestBody Client client) {
	    try {
			try {
				return clientService.createClient(client);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return client;
	}
	@PutMapping("/api/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
	    Client updatedClient = null;
		try {
			updatedClient = clientService.updateClient(id, client);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    if (updatedClient == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(updatedClient);
	}
	@DeleteMapping("/api/clients/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
	    clientService clientService = new clientService();
		clientService.deleteClient(id);
	    return ResponseEntity.noContent().build();
	}

	
}