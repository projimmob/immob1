package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
public class ClientRest {
	
	@Autowired
	private IClientService clService;
	
	@RequestMapping(value="/listeCl", method=RequestMethod.GET,produces="application/json")
	public List<Client> findAllClients()
	{
		
		return clService.getAllClients();
	}
	
	
	@RequestMapping(value="/client",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public Client ajouterClient(@RequestBody Client cl)
	{
		
		return clService.addClient(cl);
	}
	
	
	@RequestMapping(value="/client", method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public Client modifierClient(@RequestBody Client cl)
	{
		return clService.updateClient(cl);
	}
	
	
	@RequestMapping(value="/client/{pId}",method=RequestMethod.DELETE)
	public void supprimerClient(@PathVariable("pId") long id)
	{
		clService.deleteClient(id);
		return;
	}
	
	@RequestMapping(value="/client",method=RequestMethod.GET,produces="application/json")
	public Client findClient(@RequestParam("pId") long id)
	{
		return clService.getClietById(id);
	}

}
