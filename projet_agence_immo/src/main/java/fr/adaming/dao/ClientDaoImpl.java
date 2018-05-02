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
		
		String req = "from Client";
		
		//ouvrir la session : 
		s=sf.getCurrentSession();
		
		//récup le query :
		Query query= s.createQuery(req);
		
		return query.list();
	}

	@Override
	public Client addClient(Client cl) {
		
		//ouvrir la session
		s=sf.getCurrentSession();
		
		//appel de la  methode save pour ajouter un élément dans la liste
		s.save(cl);
		
		return  cl;
	}

	@Override
	public Client updateClient(Client cl) {
		// requete hql :
		String req = "UPDATE Client as cl set cl.nom=:pNom , cl.telP=:pTelP ,cl.statut=:pStatut "
				/*+ ", cl.adresse.id_a=:pIdAd,  cl.adresse.rue=:pRueAd, cl.adresse.num=:pNumAd,"
				+ " cl.adresse.cp=:pCpAd, cl.adresse.ville=:pViAd, cl.adresse.pays=:pPaAd "*/
				+ " where cl.id_cl=:pIdCl";  //, cl.adresse.id_a=:pIdAdresse
		
		//ouverture de la session :
		s=sf.getCurrentSession();
		
		//création et récupération du query :
		Query query = s.createQuery(req);
		
		//passage des paramètres :
		query.setParameter("pNom", cl.getNom());
		query.setParameter("pTelP", cl.getTelP());
		query.setParameter("pStatut", cl.getStatut());
		//query.setParameter("pIdAd", cl.getAdresse().getId_a());
		/*query.setParameter("pRueAd", cl.getAdresse().getRue());
		query.setParameter("pNumAd", cl.getAdresse().getNum());
		query.setParameter("pCpAd", cl.getAdresse().getCp());
		query.setParameter("pViAd", cl.getAdresse().getVille());
		query.setParameter("pPaAd", cl.getAdresse().getPays()); */
		query.setParameter("pIdCl", cl.getId_cl());
		
		return cl;
	}

	@Override
	public void deleteClient(long id) {
		
		//requete hql :
		String req="DELETE FROM Client as cl where cl.id_cl=:pIdCl";
		
		// ouvrir une session
				s = sf.getCurrentSession();

				// récup query
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
		
				//Récupérer le query
				Query query=s.createQuery(req);
				
				//Passage des paramètres
				query.setParameter("pIdCl", id);		
				
		return (Client) query.uniqueResult();
	}

}
