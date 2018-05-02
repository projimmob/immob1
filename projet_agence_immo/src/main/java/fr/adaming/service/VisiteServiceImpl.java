package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.BienImmo;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService {

	// Transformation de l'association 
	@Autowired
	private IVisiteDao vDao;
	
	
	@Override
	public Visite ajouterVisite(Visite v, Conseiller c, Client cl, BienImmo bien) {
		v.setConseiller(c);
		v.setClient(cl);
		v.setBien(bien);
		System.out.println("JE suis dans service ajouter visite ");
		return vDao.ajouterVisite(v);
	}

	@Override
	public int updateVisite(Visite v) {
		return vDao.updateVisite(v);
	}

	@Override
	public int deleteVisite(long id) {
		return vDao.deleteVisite(id);
		
	}


	@Override
	public List<Visite> getAllVisites() {
		System.out.println("JE SUIS DANS SERVICE GET ALL VISITE");
		return vDao.getAllVisites();
	}

	@Override
	public Visite getVisiteById(long id) {
		return vDao.getVisiteById(id);
	}

	@Override
	public List<Visite> getVisiteByBien(long id) {
		return vDao.getVisiteByBien(id);
	}

	@Override
	public List<Visite> getVisiteByClient(long id) {
		return vDao.getVisiteByClient(id);
	}

	@Override
	public List<Visite> getVisiteByConseiller(long id) {
		return vDao.getVisiteByConseiller(id);
	}

}
