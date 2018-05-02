package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Achat;
import fr.adaming.service.IAchatService;

@RestController
public class AchatRest {
	
	
	// INJECTION DE DEPENDANCE
	@Autowired
	private IAchatService acService;
	
	
	//RECUPERER LA LISTE DES ACHATS
	@RequestMapping(value="/achat", method=RequestMethod.GET, produces={"application/json"})
	public List<Achat> findAllAchats(){
		return acService.getAllAchat();
	}
	
	//AJOUTER UN ACHAT
	
	@RequestMapping(value="/achat",method=RequestMethod.POST, produces={"application/json"},consumes={"application/json"})
	public Achat ajouterAchat(@RequestBody Achat ac){
		return acService.addAchat(ac);
	}

	
	//MODIFIER UN ACHAT
	
	@RequestMapping(value="/achat", method=RequestMethod.PUT, produces={"application/json"}, consumes={"application/json"})
	public Achat modifierAchat(@RequestBody Achat ac){
		return acService.updateAchat(ac);
	}
	
	//SUPPRIMER UN ACHAT
	
	@RequestMapping(value="/achat/{pId}", method=RequestMethod.DELETE)
	public void supprimerAchat(@PathVariable("pId") long id_ac){
		acService.deleteAchat(id_ac);
	}
	
	@RequestMapping(value="/achatId", method=RequestMethod.GET, produces={"application/json"})
	public Achat findAchatById(@RequestParam("pId") long id_ac){
		return acService.getAchatById(id_ac);
	}
}
