package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IAchatDao;
import fr.adaming.model.Achat;

@Service
@Transactional
public class AchatServiceImpl implements IAchatService {

	// INJECTION DE DEPENDANCE
	@Autowired
	private IAchatDao acDao;

	// SETTERS DE L'INJECTION DE DEPENDANCE
	public void setAcDao(IAchatDao acDao) {
		this.acDao = acDao;
	}

	// RECUPERER LA LISTE DES ACHATS
	@Override
	public List<Achat> getAllAchat() {

		return acDao.getAllAchat();
	}

	// AJOUTER UN ACHAT
	@Override
	public Achat addAchat(Achat ac) {

		return acDao.addAchat(ac);
	}

	// MODIFIER UN ACHAT
	@Override
	public Achat updateAchat(Achat ac) {
		
		return acDao.updateAchat(ac);
	}

	// SUPPRIMER UN ACHAT
	@Override
	public void deleteAchat(Long id_ac) {
		acDao.deleteAchat(id_ac);

	}

	// RECUPERER UN ACHAT PAR SON ID
	@Override
	public Achat getAchatById(Long id_ac) {
		
		return acDao.getAchatById(id_ac);
	}

}
