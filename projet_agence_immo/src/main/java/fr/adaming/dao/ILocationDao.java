package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Location;



public interface ILocationDao {
	
	public List<Location> getAllLocation();
	public Location addLocation(Location loc);
	public Location updateLocation(Location loc);
	public void deleteLocation(Long id_l);
	public Location getLocationById(Long id_l);

}
