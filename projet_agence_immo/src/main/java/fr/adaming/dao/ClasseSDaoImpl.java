package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;

@Repository
public class ClasseSDaoImpl implements IClasseSDao{

	@Autowired
	private SessionFactory sf;

	// Attributs
	Session s;
	Query q;

	// Methodes
	@Override
	public ClasseStandard addClasseS(ClasseStandard cs) {
		s=sf.getCurrentSession();
		s.save(cs);
		return cs;
	}

	@Override
	public List<ClasseStandard> getAllClassesS() {
		String req = "FROM ClasseStandard";
		s = sf.getCurrentSession();
		q = s.createQuery(req);
		return q.list();
	}

	@Override
	public int updateClasseS(ClasseStandard cs) {
		String req = "UPDATE ClasseStandard as cs SET cs.type=:pType, "
					+ "cs.modeO=:pMode, " + "cs.prixMax=:pPrix, " + "cs.supMin=:pSup "
					+ "WHERE cs.id_cs=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pType", cs.getType());
		q.setParameter("pMode", cs.getModeO());
		q.setParameter("pPrix", cs.getPrixMax());
		q.setParameter("pSup", cs.getSupMin());
		q.setParameter("pId", cs.getId_cs());
		return q.executeUpdate();
	}

	@Override
	public int deleteClasseS(long id) {
		String req = "DELETE FROM ClasseStandard as cs WHERE cs.id_cs=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pId", id);
		return q.executeUpdate();
	}

	@Override
	public ClasseStandard getClasseSById(long id) {
		String req = "FROM ClasseStandard as cs WHERE cs.id_cs=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pId", id);
		return (ClasseStandard) q.uniqueResult();
	}

}
