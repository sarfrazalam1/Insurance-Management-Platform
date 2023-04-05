package com.policy.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.policy.insurance.dao.ClientRepository;
import com.policy.insurance.entities.Client;

@Component
public class ClientServices {
	
	@Autowired
	private ClientRepository clientRepository;

	//get all books
	public List<Client> getAllClient(){ 
		List<Client> list = (List<Client>)this.clientRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Client getClientById(int id) {
		Client client =null;
		try {
			client = this.clientRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return client;
	}
	
	//adding the book
	public Client addClient(Client c) {
		Client result =clientRepository.save(c);
		return result;
	}
 
	//delete book
	public void deleteClient(int cid) {
		clientRepository.deleteById(cid);
	}
	
	//update book
	public void updateClient(Client client, int clientId) {
		client.setId(clientId);
		clientRepository.save(client);
	}
	

}
