package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Achat;

public interface IAchatDao {

	public List<Achat> getAllAchat();
	public Achat addAchat(Achat ac);
	public Achat updateAchat(Achat ac);
	public void deleteAchat(Long id_ac);
	public Achat getAchatById(Long id_ac);

	
}
