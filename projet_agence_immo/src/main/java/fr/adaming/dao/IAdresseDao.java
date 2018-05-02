package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Adresse;

public interface IAdresseDao {

	public Adresse addAdresse(Adresse a);
	
	public List<Adresse> getAllAdresses();
	
	public int updateAdresse(Adresse a);
	
	public int deleteAdresse(long id);
	
	public Adresse getAdresseById(long id);
}
