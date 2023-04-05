package com.policy.insurance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.policy.insurance.entities.Client;
import com.policy.insurance.services.ClientServices;

@RestController
public class ClientController {
	
	@Autowired
	public ClientServices clientservices;
	
	//get all the clients
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getClients() {
		
		List<Client> list=clientservices.getAllClient();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
     	return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//get single client 
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") int id) {
		
		Client client = clientservices.getClientById(id);
		
		if(client==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(client));
	}
	
	//add client
	@PostMapping("/clients")
	public ResponseEntity <Client> addClient(@RequestBody Client client) {
	     Client c = null;
	     try {
	    	 c = this.clientservices.addClient(client);
             System.out.println(client);
             return ResponseEntity.status(HttpStatus.CREATED).build();
	     }catch (Exception e) {
	    	 e.printStackTrace();
	    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	 
	     }           
	    
	}
	
	//delete Client handler
	@DeleteMapping("/clients/{clientId}")
	public ResponseEntity<Void> deleteClient(@PathVariable("clientId") int clientId) {
		
		try {
			this.clientservices.deleteClient(clientId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	//update clients handler
	@PutMapping("/clients/{clientId}")
	public ResponseEntity <Client> updateClient(@RequestBody Client client,@PathVariable("clientId") int clientId)
	{
		try {
			this.clientservices.updateClient(client, clientId);
			return ResponseEntity.ok().body(client);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	
	}
}