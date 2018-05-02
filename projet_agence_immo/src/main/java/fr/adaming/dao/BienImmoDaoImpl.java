package fr.adaming.dao;


import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmo;

@Repository
public class BienImmoDaoImpl implements IBienImmoDao{

	@Autowired
	private SessionFactory sf;

	// Attributs
	Session s;
	Query q;

	// Methodes
	
	@Override
	public BienImmo addBienImmo(BienImmo b) {
		s=sf.getCurrentSession();
		s.save(b);
		return b;
	}

	@Override
	public List<BienImmo> getAllBiensImmo() {
		String req = "FROM BienImmo";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		List<BienImmo> liste = q.list();
		for(BienImmo b : liste){
			b.setImage("data:image/png);base64," + Base64.encodeBase64String(b.getPhoto()));
		}
		return liste;
	}

	@Override
	public int updateBienImmo(BienImmo b) {
		String req = "UPDATE BienImmo as b SET b.type=:pType, " + "b.statut=:pStatut, "
					+ "b.dateS=:pDS, " + "b.dateD=:pDD, " + "b.revC=:pRev, " 
					+ "b.prix=:pPrix, " + "b.dateE=:pDE, " +"b.photo=:pPhoto, "
					+ "b.proprio.id_p=:pProp, " + "b.adresse.id_a=:pAd, " + "b.classeS.id_cs=:pCS "
					+ "WHERE b.id_b=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pType", b.getType());
		q.setParameter("pStatut", b.getStatut());
		q.setParameter("pDS", b.getDateS());
		q.setParameter("pDD", b.getDateD());
		q.setParameter("pRev", b.getRevC());
		q.setParameter("pPrix", b.getPrix());
		q.setParameter("pDE", b.getDateE());
		q.setParameter("pPhoto", b.getPhoto());
		q.setParameter("pProp", b.getProprio().getId_p());
		q.setParameter("pAd", b.getAdresse().getId_a());
		q.setParameter("pCS", b.getClasseS().getId_cs());
		q.setParameter("pId", b.getId_b());
		return q.executeUpdate();
	}

	@Override
	public int deleteBienImmo(long id) {
		String req = "DELETE FROM BienImmo as b WHERE b.id_b=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pId", id);
		return q.executeUpdate();
	}

	@Override
	public BienImmo getBienImmoById(long id) {
		String req = "FROM BienImmo as b WHERE b.id_b=:pId";
		s=sf.getCurrentSession();
		q=s.createQuery(req);
		q.setParameter("pId", id);
		BienImmo bOut = (BienImmo) q.uniqueResult();
		bOut.setImage("data:image/png);base64," + Base64.encodeBase64String(bOut.getPhoto()));
		return bOut;
	}

}
