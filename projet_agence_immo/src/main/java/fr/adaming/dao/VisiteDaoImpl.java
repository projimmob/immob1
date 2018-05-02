package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmo;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

@Repository
public class VisiteDaoImpl implements IVisiteDao{

	@Autowired
	private SessionFactory sf;
	private Session s;
	
	@Override
	public Visite ajouterVisite(Visite v) {
		s=sf.getCurrentSession();
		s.save(v);
		System.out.println("JE suis dans dao ajouter visite ");
		return v;
	}

	@Override
	public int updateVisite(Visite v) {
		String req = "UPDATE Visite as v SET v.date=:pDate, v.heure=:pHeure, v.bien=:pBien, v.conseiller=:pCons, v.client=:pClient WHERE v.id_v=:pId";
	s=sf.getCurrentSession();
	Query query=s.createQuery(req);
	query.setParameter("pDate", v.getDate());
	query.setParameter("pHeure", v.getHeure());
	query.setParameter("pBien", v.getBien());
	query.setParameter("pCons", v.getConseiller());
	query.setParameter("pClient", v.getClient());
	query.setParameter("pId", v.getId_v());
	return query.executeUpdate();
	}

	@Override
	public int deleteVisite(long id) {
		// Création de la requête
		String req="DELETE FROM Visite as v WHERE v.id_v=:pId";
		s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		// Passage des paramètres
		query.setParameter("pId", id);
		return query.executeUpdate();
		
	}



	@Override
	public List<Visite> getAllVisites() {
		// création de la requête
		String req="FROM Visite";
		s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		System.out.println("JE SUIS DANS DAO GET ALL VISITE");
			return query.list();
	}

	@Override
	public Visite getVisiteById(long id) {
		// Création de la requête
		String req="FROM Visite as v WHERE v.id_v=:pIdV";
		s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		// Passage des paramètres 
		query.setParameter("pIdV", id);
		Visite vOut=(Visite) query.uniqueResult();
		return vOut;
	}

	@Override
	public List<Visite> getVisiteByBien(long id) {
		// Création de la requete
		String req="FROM Visite as v WHERE v.bien.id_b=:pIdBien";
		s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		query.setParameter("pIdBien", id);
		return query.list();
	}

	@Override
	public List<Visite> getVisiteByClient(long id) {
		// Création de la requete
		String req="FROM Visite as v WHERE v.client.id_cl=:pIdClient";
		s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		query.setParameter("pIdClient", id);
		return query.list();
	}

	@Override
	public List<Visite> getVisiteByConseiller(long id) {
		// Création de la requete
		String req="FROM Visite as v WHERE v.conseiller.id_co=:pIdCo";
		s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		query.setParameter("pIdCo", id);
		return query.list();
	}


	
	
}
