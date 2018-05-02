package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Location;

@Repository
public class LocationDaoImpl implements ILocationDao {

	@Autowired
	private SessionFactory sf;
	Session s;
	Query query;

	// RECUPERER LA LISTE DES LOCATIONS
	@Override
	public List<Location> getAllLocation() {
		// REQUETE HQL
		String req = "FROM Location";
		// OUVERTURE DE LA SESSION
		s = sf.getCurrentSession();

		// RECUPERER QUERY
		query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Location addLocation(Location loc) {
		// OUVERTURE DE LA SESSION
		s = sf.getCurrentSession();

		// REQUETE HQL
		s.save(loc);
		return loc;
	}

	@Override
	public Location updateLocation(Location loc) {
		
		//OUVERTURE DE LA SESSION
		s=sf.getCurrentSession();
		
		//REQUETE HQL
		s.update(loc);
		return loc;
	}

	@Override
	public void deleteLocation(Long id_l) {
		//REQUETE HQL
		String req="DELETE FROM Location as loc WHERE loc.id_l=:pId";
		
		//OUVERTURE DE LA SESSION
		s=sf.getCurrentSession();
		
		//RECUPERER QUERY
		query=s.createQuery(req);
		
		//PASSAGE DES PARAMS
		query.setParameter("pId",id_l);
		
		query.executeUpdate();

	}

	@Override
	public Location getLocationById(Long id_l) {
		//REQUETE HQL
				String req="FROM Location AS loc WHERE loc.id=:pId";
				
				//OUVERTURE DE LA SESSION
				
				s=sf.getCurrentSession();
				
				//RECUPERER QUERY
				query=s.createQuery(req);
				
				//PASSAGE DES PARAMS
				query.setParameter("pId",id_l);
				
		return (Location) query.uniqueResult();
	}

}
