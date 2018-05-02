package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Adresse;

@Repository
public class AdresseDaoImpl implements IAdresseDao {

	@Autowired
	private SessionFactory sf;

	// Attributs
	Session s;
	Query q;

	// Methodes

	@Override
	public Adresse addAdresse(Adresse a) {
		s = sf.getCurrentSession();
		s.save(a);
		return a;
	}

	@Override
	public List<Adresse> getAllAdresses() {
		String req = "FROM Adresse";
		s = sf.getCurrentSession();
		q = s.createQuery(req);
		return q.list();
	}

	@Override
	public int updateAdresse(Adresse a) {
		String req = "UPDATE Adresse as a SET a.rue=:pRue, " 
					+ "a.num=:pNum, " + "a.cp=:pCp, " + "a.ville=:pVille, "
					+ "a.pays=:pPays " + "WHERE a.id_a=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pRue", a.getRue());
		q.setParameter("pNum", a.getNum());
		q.setParameter("pCp", a.getCp());
		q.setParameter("pVille", a.getVille());
		q.setParameter("pPays", a.getPays());
		q.setParameter("pId", a.getId_a());
		return q.executeUpdate();
	}

	@Override
	public int deleteAdresse(long id) {
		String req = "DELETE FROM Adresse as a WHERE a.id_a=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pId", id);
		return q.executeUpdate();
	}

	@Override
	public Adresse getAdresseById(long id) {
		String req = "FROM Adresse as a WHERE a.id_a=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pId", id);
		return (Adresse) q.uniqueResult();
	}

}
