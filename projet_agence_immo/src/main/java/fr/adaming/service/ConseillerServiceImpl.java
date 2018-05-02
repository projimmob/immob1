package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;

@Service
@Transactional
public class ConseillerServiceImpl implements IConseillerService {

	// Transformation de l'association 
	@Autowired
	private IConseillerDao cDao;

	@Override
	public List<Conseiller> getAllConseiller() {
		return cDao.getAllConseiller();
	}

	@Override
	public Conseiller addConseiller(Conseiller c) {
		cDao.addConseiller(c);
		return c;
	}

	@Override
	public Conseiller updateConseiller(Conseiller c) {
		return cDao.updateConseiller(c);
	}

	@Override
	public void deleteConseiller(long id) {
		cDao.deleteConseiller(id);
	}

	@Override
	public Conseiller getConseillerById(long id) {
		return cDao.getConseillerById(id);
	}

	/*@Override
	public Conseiller isExist(Conseiller c) {
		return cDao.isExist(c);
	}*/

	@Override
	public Conseiller isExist(String mail, String pwd) {
		// TODO Auto-generated method stub
		return cDao.isExist(mail, pwd);
	}


	
	
	

//	@Override
//	public boolean isExist(Conseiller c) {
//	
//		if(c.getMail()=="a@a"&& c.getPsw()=="admin"){
//			return true;
//		}else{
//		return false;
//	}

	
	
	
	
	
	

}