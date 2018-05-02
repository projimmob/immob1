package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao {
	
	@Autowired
	private SessionFactory sf;
	Session s;
	
	
	@Override
	public List<Proprietaire> getAllProprietaires() {
		String req = "from Proprietaire";
		
		//ouvrir la session : 
		s=sf.getCurrentSession();
				
		//récup le query :
		Query query= s.createQuery(req);
				
		return query.list();
	}
	@Override
	public Proprietaire addProprietaire(Proprietaire pr) {
		
		//ouvrir la session
				s=sf.getCurrentSession();
				
				//appel de la  methode save pour ajouter un élément dans la liste
				s.save(pr);
				
				return pr;
	}
	@Override
	public Proprietaire updateProprietaire(Proprietaire pr) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteProprietaire(long id) {
		//requete hql :
		String req="DELETE FROM Proprietaire as pr where pr.id_p=:pIdP";
		
		// ouvrir une session
		s = sf.getCurrentSession();

		// récup query
		Query query = s.createQuery(req);
		
//passage des parametres :
		query.setParameter("pIdP", id);
		
		query.executeUpdate();
		
	}
	@Override
	public Proprietaire getProprietaireById(long id) {
		//requete hql :
		String req="From Proprietaire as pr where pr.id_p=:pIdP";
		
		//Ouvrir la session
		s=sf.getCurrentSession();

		//Récupérer le query
		Query query=s.createQuery(req);
		
		//Passage des paramètres
		query.setParameter("pIdP", id);
		
		return (Proprietaire) query.uniqueResult();
	}

}
