package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface IConseillerService {

	public List<Conseiller> getAllConseiller();
	
	public Conseiller addConseiller (Conseiller c);
	
	public Conseiller updateConseiller (Conseiller c);

	public void deleteConseiller (long id);
	
	public Conseiller getConseillerById (long id);
	
}
