package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Location;
import fr.adaming.service.ILocationService;

@RestController
public class LocationRest {
	
	
	// INJECTION DE DEPENDANCE
	@Autowired
	private ILocationService locService;
	
	//RECUPERER LA LISTE DES LOCATIONS
	@RequestMapping(value="/location", method=RequestMethod.GET, produces={"application/json"})
	public List<Location> findAllLocation(){
		return locService.getAllLocation();
	}
	
	//AJOUTER UNE LOCATION
	@RequestMapping(value="/location",method=RequestMethod.POST, produces={"application/json"},consumes={"application/json"})
	public Location ajouterLocation(@RequestBody Location loc){
		return locService.addLocation(loc);
	}
	
	//MODIFIER UNE LOCATION
	
	@RequestMapping(value="/location", method=RequestMethod.PUT, produces={"application/json"}, consumes={"application/json"})
	public Location modifierLocation(@RequestBody Location loc){
		return locService.updateLocation(loc);
	}
	
	//SUPPRIMER UNE LOCATION
	@RequestMapping(value="/location/{pId}", method=RequestMethod.DELETE)
	public void supprimerLocation(@PathVariable("pId") long id_l){
		locService.deleteLocation(id_l);
	}
	
	@RequestMapping(value="/locationId", method=RequestMethod.GET, produces={"application/json"})
	public Location findLocationById(@RequestParam("pId") long id_l){
		return locService.getLocationById(id_l);
	}
	
}
