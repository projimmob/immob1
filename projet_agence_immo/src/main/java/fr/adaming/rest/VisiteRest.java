package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmo;
import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
public class VisiteRest {

	@Autowired
	private IVisiteService vService;


	public void setvService(IVisiteService vService) {
		this.vService = vService;
	}



	@RequestMapping(value="/ajouterVis", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Visite ajouterVisite(@RequestBody Visite v){
		System.out.println("JE suis dans REST ajouter visite ");
		return vService.ajouterVisite(v, v.getConseiller(), v.getClient(), v.getBien());
	}
	
	@RequestMapping(value="/supprimerVis/{id}", method=RequestMethod.DELETE)
	public int deleteVisite(@PathVariable long id){
		return vService.deleteVisite(id);
	}
	
	
	@RequestMapping(value="/findOneVis", method=RequestMethod.GET, produces="application/json")
	public Visite getVisiteById(@RequestParam("pId") long id){
		return vService.getVisiteById(id);
	}
	
	@RequestMapping(value="/listeVis", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getAllVisites(){
		System.out.println("JE SUIS DANS REST GETALL");
		return vService.getAllVisites();
	}
	
	
	@RequestMapping(value="/updateVis", method=RequestMethod.PUT, consumes="application/json")
	public int updateVisite(@RequestBody Visite v){
		return vService.updateVisite(v);
	}
	
	@RequestMapping(value="/visByBien", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getVisiteByBien(@RequestParam("pIdBien") long id){
		return vService.getVisiteByBien(id);
	}
	
	@RequestMapping(value="/visByClient", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getVisiteByClient(@RequestParam("pIdClient") long id){
		return vService.getVisiteByClient(id);
	}
	
	
	@RequestMapping(value="/visByCons", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getVisiteByConseiller(@RequestParam("pIdCo") long id){
		return vService.getVisiteByConseiller(id);
	}
	
}
