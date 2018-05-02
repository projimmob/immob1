package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmo;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

public interface IVisiteService {

	public Visite ajouterVisite(Visite v, Conseiller c, Client cl, BienImmo bien);
	public int updateVisite(Visite v);
	public int deleteVisite(long id);
	public List<Visite> getAllVisites();
	public Visite getVisiteById(long id);
	public List<Visite> getVisiteByBien(long id);
	public List<Visite> getVisiteByClient(long id);
	public List<Visite> getVisiteByConseiller(long id);
	
}
