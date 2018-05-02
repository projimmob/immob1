package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAdresseDao;
import fr.adaming.model.Adresse;

@Service
@Transactional
public class AdresseServiceImpl implements IAdresseService{

	@Autowired
	private IAdresseDao adDao;
	
	//setter pour l'injection de dependance
	public void setAdDao(IAdresseDao adDao) {
		this.adDao = adDao;
	}

	//Methodes
	@Override
	public Adresse addAdresse(Adresse a) {
		
		return adDao.addAdresse(a);
	}

	@Override
	public List<Adresse> getAllAdresses() {
		
		return adDao.getAllAdresses();
	}

	@Override
	public int updateAdresse(Adresse a) {
		
		return adDao.updateAdresse(a);
	}

	@Override
	public int deleteAdresse(long id) {
		
		return adDao.deleteAdresse(id);
	}

	@Override
	public Adresse getAdresseById(long id) {
		
		return adDao.getAdresseById(id);
	}

}
