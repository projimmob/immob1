package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Conseiller;
import fr.adaming.service.IConseillerService;

@RestController
public class ConseillerRest {

	
	@Autowired
	private IConseillerService cService;
	
	
	@RequestMapping (value="/liste", method=RequestMethod.GET, produces="application/json")
	public List<Conseiller> getAllConseiller(){
		return cService.getAllConseiller();
	}
	
	
	@RequestMapping(value="/ajouterCons", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Conseiller ajouterConseiller(@RequestBody Conseiller c){
		return cService.addConseiller(c);
	}

	
	@RequestMapping(value="/supprimer/{id_co}", method=RequestMethod.DELETE)
	public void supprimerConseiller(@PathVariable(value="id_co") long id){
		cService.deleteConseiller(id);
	}
	
	
	@RequestMapping(value="/findCons", method=RequestMethod.GET, produces="application/json")
	public Conseiller getConseillerById (@RequestParam("pId") long id){
		return cService.getConseillerById(id);
	}
	
	@RequestMapping(value="/updateCons", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Conseiller updateConseiller (@RequestBody Conseiller c){
		System.out.println("||||||||||||||||| méthode update Conseiller du Rest ||||||||||||||||||||||| ");
		return cService.updateConseiller(c);
	}
	
	
}
