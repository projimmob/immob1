package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmo;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

public interface IVisiteDao {

	public Visite ajouterVisite(Visite v);
	public int updateVisite(Visite v);
	public int deleteVisite(long id);
	public List<Visite> getAllVisites();
	public Visite getVisiteById(long id);
	public List<Visite> getVisiteByBien(long id);
	public List<Visite> getVisiteByClient(long id);
	public List<Visite> getVisiteByConseiller(long id);
	
	
}
