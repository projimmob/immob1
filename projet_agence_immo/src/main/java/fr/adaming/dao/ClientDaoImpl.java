package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;
	Session s;
	
	@Override
	public List<Client> getAllClients() {
		
		String req = "FROM Client";
		
		//ouvrir la session : 
		s=sf.getCurrentSession();
		
		//r�cup le query :
		Query query= s.createQuery(req);
		
		return query.list();
	}

	@Override
	public Client addClient(Client cl) {
		
		//ouvrir la session
		s=sf.getCurrentSession();
		
		//appel de la  methode save pour ajouter un �l�ment dans la liste
		s.save(cl);
		
		return  cl;
	}

	@Override
	public Client updateClient(Client cl) {

		//ouverture de la session :
		s=sf.getCurrentSession();

		s.update(cl);
		return cl;
	}

	@Override
	public void deleteClient(long id) {
		
		//requete hql :
		String req="DELETE FROM Client as cl where cl.id_cl=:pIdCl";
		
		// ouvrir une session
				s = sf.getCurrentSession();

				// r�cup query
				Query query = s.createQuery(req);
				
		//passage des parametres :
				query.setParameter("pIdCl", id);
				
				query.executeUpdate();
		
	}

	@Override
	public Client getClietById(long id) {

		//requete hql :
		String req="From Client as cl where cl.id_cl=:pIdCl";
				
		//Ouvrir la session
				s=sf.getCurrentSession();
		
				//R�cup�rer le query
				Query query=s.createQuery(req);
				
				//Passage des param�tres
				query.setParameter("pIdCl", id);		
				
		return (Client) query.uniqueResult();
	}

}
