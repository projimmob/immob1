package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	public List<Client> getAllClients();
	
	public Client addClient (Client cl);
	
	public Client updateClient (Client cl);
	
	public void deleteClient (long id);
	

	public 	Client getClietById(long id);

}
