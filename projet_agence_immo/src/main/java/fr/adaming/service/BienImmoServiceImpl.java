package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdresseDao;
import fr.adaming.dao.IBienImmoDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.BienImmo;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class BienImmoServiceImpl implements IBienImmoService{

	@Autowired
	private IBienImmoDao bienDao;
	
	//setter pour l'injection de dependance
	public void setBienDao(IBienImmoDao bienDao) {
		this.bienDao = bienDao;
	}

	//Methodes
	@Override
	public BienImmo addBienImmo(BienImmo b, Proprietaire p, Adresse a, ClasseStandard cs) {
		b.setProprio(p);
		b.setAdresse(a);
		b.setClasseS(cs);
		return bienDao.addBienImmo(b);
	}

	
	@Override
	public List<BienImmo> getAllBiensImmo() {
		
		return bienDao.getAllBiensImmo();
	}

	@Override
	public int updateBienImmo(BienImmo b, Proprietaire p, Adresse a, ClasseStandard cs) {
		b.setProprio(p);
		b.setAdresse(a);
		b.setClasseS(cs);
		return bienDao.updateBienImmo(b);
	}

	@Override
	public int deleteBienImmo(long id) {
		
		return bienDao.deleteBienImmo(id);
	}

	@Override
	public BienImmo getBienImmoById(long id) {
		
		return bienDao.getBienImmoById(id);
	}

	@Override
	public List<BienImmo> getAllBiensByProprio(long idProprio) {
		List<BienImmo> liste = bienDao.getAllBiensImmo();
		List<BienImmo> listeRech = new ArrayList<BienImmo>();
		for(BienImmo b: liste){
			if(b.getProprio().getId_p()==idProprio){
				listeRech.add(b);
			}
		}
		return listeRech;
	}

	@Override
	public List<BienImmo> getAllBiensByStatut(String statut) {
		List<BienImmo> liste = bienDao.getAllBiensImmo();
		List<BienImmo> listeDispo = new ArrayList<BienImmo>();
		for(BienImmo b: liste){
			if(b.getStatut().contains(statut)){
				listeDispo.add(b);
			}
		}
		return listeDispo;
	}

	@Override
	public List<BienImmo> getAllBiensByCS(long idCS) {
		List<BienImmo> liste = bienDao.getAllBiensImmo();
		List<BienImmo> listeCS = new ArrayList<BienImmo>();
		for(BienImmo b: liste){
			if(b.getClasseS().getId_cs()==idCS){
				listeCS.add(b);
			}
		}
		return listeCS;
	}

}
