package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ILocationDao;
import fr.adaming.model.Achat;
import fr.adaming.model.Location;

@Service
@Transactional
public class LocationServiceImpl implements ILocationService{
	
	// INJECTION DE DEPENDANCE
	
	@Autowired
	private ILocationDao locDao;
	
	// SETTERS DE L'INJECTION DE DEPENDANCE

	public void setLocDao(ILocationDao locDao) {
		this.locDao = locDao;
	}

	// RECUPERER LA LISTE DES LOCATIONS
	@Override
	public List<Location> getAllLocation() {
		
		return locDao.getAllLocation();
	}
	
	// AJOUTER UNE LOCATION

	@Override
	public Location addLocation(Location loc) {
		
		return locDao.addLocation(loc);
	}

	//MODIFIER UNE LOCATION
	@Override
	public Location updateLocation(Location loc) {
		
		return locDao.updateLocation(loc);
	}

	
	//SUPPRIMER UNE LOCATION
	
	@Override
	public void deleteLocation(Long id_l) {
		locDao.deleteLocation(id_l);
		
	}

	@Override
	public Location getLocationById(Long id_l) {
		
		return locDao.getLocationById(id_l);
	}



}
