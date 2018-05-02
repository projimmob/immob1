package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface IConseillerDao {

	public List<Conseiller> getAllConseiller();
	
	public Conseiller addConseiller (Conseiller c);
	
	public Conseiller updateConseiller (Conseiller c);

	public void deleteConseiller (long id);
	
	public Conseiller getConseillerById (long id);

	//public Conseiller isExist(Conseiller c);
	
	
	public Conseiller isExist(String mail, String pwd);
}
