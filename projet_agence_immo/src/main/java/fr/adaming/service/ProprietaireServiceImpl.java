package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class ProprietaireServiceImpl implements IProprietaireService {
	
	@Autowired
	private IProprietaireDao prDao;

	@Override
	public List<Proprietaire> getAllProprietaires() {
		// TODO Auto-generated method stub
		return prDao.getAllProprietaires();
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire pr) {
		// TODO Auto-generated method stub
		return prDao.addProprietaire(pr);
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire pr) {
		// TODO Auto-generated method stub
		return prDao.updateProprietaire(pr);
	}

	@Override
	public void deleteProprietaire(long id) {
		prDao.deleteProprietaire(id);		
	}

	@Override
	public Proprietaire getProprietaireById(long id) {
		// TODO Auto-generated method stub
		return prDao.getProprietaireById(id);
	}

	@Override
	public List<Proprietaire> getProprietaireByName(String nom) {
		
		List<Proprietaire> listeProp=prDao.getAllProprietaires();
		
		//initialiser une liste qui va permettre de récupérer les noms :
		List<Proprietaire> listeName=new ArrayList<Proprietaire>();
		
		for(Proprietaire pr : listeProp)
		{
			if(pr.getNom().contains(nom))
			{
				listeName.add(pr);
			}
		}
		return listeName;
	}


}
