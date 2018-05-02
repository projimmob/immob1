package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmo;

public interface IBienImmoDao {

	public BienImmo addBienImmo(BienImmo b);
	
	public List<BienImmo> getAllBiensImmo();
	
	public int updateBienImmo(BienImmo b);
	
	public int deleteBienImmo(long id);
	
	public BienImmo getBienImmoById(long id);
}
