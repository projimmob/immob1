package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Adresse;
import fr.adaming.service.IAdresseService;

@RestController
public class AdresseRest {

	@Autowired
	private IAdresseService adServ;

	//setter pour l'injection de dependance
	public void setAdServ(IAdresseService adServ) {
		this.adServ = adServ;
	}
	
	//Methodes
	@RequestMapping(value="/adresse",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Adresse ajouterAdresse(@RequestBody Adresse a){
		return adServ.addAdresse(a);
	}
	
	@RequestMapping(value="/adresses",method=RequestMethod.GET,produces="application/json")
	public List<Adresse> listerAdresses(){
		return adServ.getAllAdresses();
	}
	
	@RequestMapping(value="/adresse",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public int modifierAdresse(@RequestBody Adresse a){
		return adServ.updateAdresse(a);
	}
	
	@RequestMapping(value="/adresse/{pId}",method=RequestMethod.DELETE)
	public int supprimerAdresse(@PathVariable(value="pId") long id){
		return adServ.deleteAdresse(id);
	}

	@RequestMapping(value="/adresse",method=RequestMethod.GET,produces="application/json")
	public Adresse rechercherAdresse(@RequestParam(value="pId") long id){
		return adServ.getAdresseById(id);
	}
}
