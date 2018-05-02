package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

public interface IClasseSService {

	public ClasseStandard addClasseS(ClasseStandard cs);

	public List<ClasseStandard> getAllClassesS();

	public int updateClasseS(ClasseStandard cs);

	public int deleteClasseS(long id);

	public ClasseStandard getClasseSById(long id);
}
