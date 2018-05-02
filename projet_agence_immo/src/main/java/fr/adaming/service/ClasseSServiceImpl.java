package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseSDao;
import fr.adaming.model.ClasseStandard;

@Service
@Transactional
public class ClasseSServiceImpl implements IClasseSService{

	@Autowired
	public IClasseSDao csDao;
	
	//setter pour l'injection de dependance
	public void setCsDao(IClasseSDao csDao) {
		this.csDao = csDao;
	}

	//Methodes
	@Override
	public ClasseStandard addClasseS(ClasseStandard cs) {
		
		return csDao.addClasseS(cs);
	}

	@Override
	public List<ClasseStandard> getAllClassesS() {
		
		return csDao.getAllClassesS();
	}

	@Override
	public int updateClasseS(ClasseStandard cs) {
		
		return csDao.updateClasseS(cs);
	}

	@Override
	public int deleteClasseS(long id) {
		
		return csDao.deleteClasseS(id);
	}

	@Override
	public ClasseStandard getClasseSById(long id) {
		
		return csDao.getClasseSById(id);
	}

}
