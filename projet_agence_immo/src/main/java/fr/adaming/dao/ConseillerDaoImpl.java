package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Conseiller;

@Repository
public class ConseillerDaoImpl implements IConseillerDao{
	
	@Autowired
	private SessionFactory sf;
	Session s;

	@Override
	public List<Conseiller> getAllConseiller() {
		// Création de la requête
		String req="FROM Conseiller";
		// Session
		s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		return query.list();
	}

	@Override
	public Conseiller addConseiller(Conseiller c) {
		s=sf.getCurrentSession();
		s.save(c);
		return c;
	}

	@Override
	public Conseiller updateConseiller(Conseiller c) {
		// Création de la requête
		String req="UPDATE Conseiller as c SET c.id_co=:pId, c.mail=:pMail, c.psw=:pPsw WHERE c.id_co=:pId";
		s=sf.getCurrentSession();
		// Création du query
		Query query=s.createQuery(req);
		// Passage des paramètres 
		query.setParameter("pId", c.getId_co());
		query.setParameter("pMail", c.getMail());
		query.setParameter("pPsw", c.getPsw());
		query.executeUpdate();
		return c;
		
	}

	@Override
	public void deleteConseiller(long id) {
		s=sf.getCurrentSession();
		Conseiller cOut=(Conseiller) s.get(Conseiller.class, id);
		s.delete(cOut);
	}

	@Override
	public Conseiller getConseillerById(long id) {
		// Création de la requête
		String req="FROM Conseiller as c WHERE c.id_co=:pId";
		s=sf.getCurrentSession();
		// Création du query
		Query query=s.createQuery(req);
		// Passage des paramètres
		query.setParameter("pId", id);
		return (Conseiller) query.uniqueResult();
	}

/*	@Override
	
		
		public Conseiller isExist(Conseiller c) {
			// la requete jpql
			String req = "From Conseiller as c WHERE c.mail=:pMail, c.psw=:pPsw";
			// creer un objet de type Query pour envoyer la requete *
			s=sf.getCurrentSession();
			Query query=s.createQuery(req);
			// passage de la params
			query.setParameter("pMail", c.getMail());
			query.setParameter("pPsw", c.getPsw());
			
			// envoyer la requte et recup du resultat
			return  (Conseiller) query.uniqueResult();
		
		
		
		
		
	} */

	@Override
	public Conseiller isExist(String mail, String pwd) {
		// la requete jpql
		String req = "From Conseiller as c WHERE c.mail=:pMail and c.psw=:pPsw";
		// creer un objet de type Query pour envoyer la requete *
		s=sf.getCurrentSession();
		Query query=s.createQuery(req);
		// passage de la params
		query.setParameter("pMail", mail);
		query.setParameter("pPsw", pwd);
		
		// envoyer la requte et recup du resultat
		return  (Conseiller) query.uniqueResult();
	}

}
