package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Adresse;
import fr.adaming.model.BienImmo;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Proprietaire;

public interface IBienImmoService {

	public BienImmo addBienImmo(BienImmo b, Proprietaire p, Adresse a, ClasseStandard cs);

	public List<BienImmo> getAllBiensImmo();

	public int updateBienImmo(BienImmo b,Proprietaire p, Adresse a, ClasseStandard cs);

	public int deleteBienImmo(long id);

	public BienImmo getBienImmoById(long id);
	
	public List<BienImmo> getAllBiensByProprio(long idProprio);
	
	public List<BienImmo> getAllBiensByStatut(String statut);
	
	public List<BienImmo> getAllBiensByCS(long idCS);
}
