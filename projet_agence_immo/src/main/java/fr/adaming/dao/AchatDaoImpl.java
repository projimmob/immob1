package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Achat;


@Repository
public class AchatDaoImpl implements IAchatDao{
	
	@Autowired
	private SessionFactory sf;
	Session s;
	
	Query query;
	
	//RECUP LA LISTE DES ACHATS
	@Override
	public List<Achat> getAllAchat() {
		
		//REQUETE HQL
		String req="From Achat";
		
		//OUVERTURE DE LA SESSION
		s=sf.getCurrentSession();
		
		//RECUPERER QUERY
		query=s.createQuery(req);
		
		return query.list();
	}


//AJOUTER UN ACHAT
	@Override
	public Achat addAchat(Achat ac) {
		//OUVERTURE DE LA SESSION
		s=sf.getCurrentSession();
		
		//REQUETE HQL
		s.save(ac);
		return ac;
	}

	
	//MODIFIER UN ACHAT
	@Override
	public Achat updateAchat(Achat ac) {
		
		//OUVERTURE DE LA SESSION
		s=sf.getCurrentSession();
		
		//REQUETE HQL
		s.update(ac);
		return ac;
	}

	@Override
	public void deleteAchat(Long id_ac) {
		
		//REQUETE HQL
	String req="DELETE FROM Achat as ac WHERE ac.id_ac=:pId";
	
	//OUVERTURE DE LA SESSION
	s=sf.getCurrentSession();
	
	//RECUPERER QUERY
	query=s.createQuery(req);
	
	//PASSAGE DES PARAMS
	query.setParameter("pId",id_ac);
	
	query.executeUpdate();
		
	}
	
	
	//RECUPERER UN ACHAT PAR ID

	@Override
	public Achat getAchatById(Long id_ac) {
		
		//REQUETE HQL
		String req="FROM Achat AS ac WHERE ac.id=:pId";
		
		//OUVERTURE DE LA SESSION
		
		s=sf.getCurrentSession();
		
		//RECUPERER QUERY
		query=s.createQuery(req);
		
		//PASSAGE DES PARAMS
		query.setParameter("pId",id_ac);
		
		return (Achat) query.uniqueResult();
	}

	
	
	

}
