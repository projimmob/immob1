package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Client;
import fr.adaming.model.Proprietaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class ProprietaireDaoImplTest {

	@Autowired
	private IProprietaireDao proprietaireDao;
	
	@Test
	@Transactional(readOnly=true)
	public void testGetAllProprietaire()  //par l'id (pour la taille de la liste)
	{
		assertEquals(2, proprietaireDao.getAllProprietaires().size());
	}
	
	
	@Test
	@Transactional(readOnly=true)
	public void testGetAllProprietaire2()     //pour comparer nom 
	{
		assertEquals("tata", proprietaireDao.getAllProprietaires().get(1).getNom());
	}
	
	//test pour savoir si il ajoute vraiment le nom du nouveau client :
	@Test
    @Transactional
    @Rollback(true)
	public void testAddProprietaire()
	{
		Proprietaire prIn=new Proprietaire("rara", "0625239632", "0528986522");
		
		int tailleAvant=proprietaireDao.getAllProprietaires().size();
		
		proprietaireDao.addProprietaire(prIn);
		
		int tailleApres=proprietaireDao.getAllProprietaires().size();
		
		assertEquals("rara", proprietaireDao.getAllProprietaires().get(tailleApres-1).getNom());
	}
	
	
	//test pour la suppression :
		@Test
	    @Transactional
	    @Rollback(true)
		public void testDeleteProprietaire()
		{
			
			Proprietaire prIn= new Proprietaire("fafa", "0605896321", 4, "0585963214");
			
			int tailleAvant=proprietaireDao.getAllProprietaires().size();
			
			proprietaireDao.deleteProprietaire(3);
			
			//int tailleApres=proprietaireDao.getAllProprietaires().size();
			
			assertEquals(tailleAvant-1, proprietaireDao.getAllProprietaires().size());
					
		}
		
		
		//test pour le findById
		@Test
		@Transactional(readOnly=true)
		public void testGetProprietairetById()     //pour comparer nom 
		{
			proprietaireDao.getProprietaireById(3);
			assertEquals("tata", proprietaireDao.getAllProprietaires().get(1).getNom());
		}
		
		
		
		
	
}
