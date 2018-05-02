package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IClasseSService;

@RestController
public class ClasseSRest {

	@Autowired
	public IClasseSService csServ;

	//setter pour l'injection de dependance
	public void setCsServ(IClasseSService csServ) {
		this.csServ = csServ;
	}
	
	//Methodes
	@RequestMapping(value="/classeS",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public ClasseStandard ajouterClasseS(@RequestBody ClasseStandard cs){
		return csServ.addClasseS(cs);
	}

	@RequestMapping(value="/classesS",method=RequestMethod.GET,produces="application/json")
	public List<ClasseStandard> listeClassesS(){
		return csServ.getAllClassesS();
	}

	@RequestMapping(value="/classeS",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public int modifierClasseS(@RequestBody ClasseStandard cs){
		return csServ.updateClasseS(cs);
	}

	@RequestMapping(value="/classeS/{pId}",method=RequestMethod.DELETE)
	public int supprimerClasseS(@PathVariable(value="pId") long id){
		return csServ.deleteClasseS(id);
	}

	@RequestMapping(value="classeS",method=RequestMethod.GET,produces={"application/json","application/xml"})
	public ClasseStandard rechercherClasseS(@RequestParam(value="pId") long id){
		return csServ.getClasseSById(id);
	}
	
}
