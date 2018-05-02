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
import fr.adaming.service.IBienImmoService;

@RestController
public class BienImmoRest {

	
	@Autowired
	private IBienImmoService bienServ;

	//setter pour l'injection de dependance
	public void setBienServ(IBienImmoService bienServ) {
		this.bienServ = bienServ;
	}
	
	//Methodes
	@RequestMapping(value="/bien",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public BienImmo ajouterBienImmo(@RequestBody BienImmo b){
		return bienServ.addBienImmo(b, b.getProprio(), b.getAdresse(), b.getClasseS());
	}

	@RequestMapping(value="/biens",method=RequestMethod.GET,produces="application/json")
	public List<BienImmo> listerBiensImmo(){
		return bienServ.getAllBiensImmo();
	}

	@RequestMapping(value="/bien",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public int modifierBienImmo(@RequestBody BienImmo b){
		return bienServ.updateBienImmo(b, b.getProprio(), b.getAdresse(), b.getClasseS());
	}

	@RequestMapping(value="/bien/{pId}",method=RequestMethod.DELETE,produces="application/json")
	public int supprimerBienImmo(@PathVariable(value="pId") long id){
		return bienServ.deleteBienImmo(id);
	}

	@RequestMapping(value="/bien",method=RequestMethod.GET,produces="application/json")
	public BienImmo getBienImmoById(@RequestParam(value="pId") long id){
		return bienServ.getBienImmoById(id);
	}
	
	@RequestMapping(value="/biensProprio",method=RequestMethod.GET,produces="application/json")
	public List<BienImmo> listerBiensParProprio(@RequestParam(value="pIdProprio") long idProprio){
		return bienServ.getAllBiensByProprio(idProprio);
	}
	
	@RequestMapping(value="/biensStatut",method=RequestMethod.GET, produces="application/json")
	public List<BienImmo> listerBiensParStatut(@RequestParam(value="pStatut") String statut){
		return bienServ.getAllBiensByStatut(statut);
	}
	
	@RequestMapping(value="/biensCS",method=RequestMethod.GET,produces="application/json")
	public List<BienImmo> listerBiensParCS(@RequestParam(value="pIdCS") long idCS){
		return bienServ.getAllBiensByCS(idCS);
	}
}
