package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireService {
	
public List<Proprietaire> getAllProprietaires();
	
	public Proprietaire addProprietaire (Proprietaire pr);
	
	public Proprietaire updateProprietaire (Proprietaire pr);
	
	public void deleteProprietaire (long id);
	

	public 	Proprietaire getProprietaireById(long id);
	
	public List<Proprietaire> getProprietaireByName(String nom);

}
