package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
public class ProprietaireRest {
	
	@Autowired
	private IProprietaireService prService;
	
	
	@RequestMapping(value="/listePr" , method=RequestMethod.GET, produces="application/json")
	public List<Proprietaire> findAllProprietaires()
	{
		return prService.getAllProprietaires();
	}

	
	@RequestMapping(value="/prop",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public Proprietaire ajouterProprietaire(@RequestBody Proprietaire pr)
	{
		return prService.addProprietaire(pr);
	}
	
	
	@RequestMapping(value="/prop",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public Proprietaire modifierProprietaire(@RequestBody Proprietaire pr)
	{
		return prService.updateProprietaire(pr);
	}
	
	
	@RequestMapping(value="/prop/{pId}", method=RequestMethod.DELETE)
	public void supprimerProprietaire(@PathVariable("pId") long id)
	{
		prService.deleteProprietaire(id);
	}
	
	
	@RequestMapping(value="/prop", method=RequestMethod.GET,produces="application/json")
	public Proprietaire findProprietaire(@RequestParam("pId") long id)
	{
		return prService.getProprietaireById(id);
	}
	
	
	@RequestMapping(value="/propName", method=RequestMethod.GET, produces="application/json")
	public List<Proprietaire> findProprietairesByName (@RequestParam("pNom") String nom)
	{
		return prService.getProprietaireByName(nom);
	}
}
