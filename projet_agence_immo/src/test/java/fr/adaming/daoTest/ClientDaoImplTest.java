package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class ClientDaoImplTest {
	
	@Autowired
	private IClientDao clientDao;
	
	
	@Test
	@Transactional(readOnly=true)
	public void testGetAllClient()  //par l'id (pour la taille de la liste)
	{
		assertEquals(7, clientDao.getAllClients().size());
	}
	
	
	@Test
	@Transactional(readOnly=true)
	public void testGetAllClient2()     //pour comparer nom 
	{
		assertEquals("yoyo", clientDao.getAllClients().get(3).getNom());
	}
	
	
	//test pour savoir si il ajoute vraiment le nom du nouveau client :
	@Test
    @Transactional
    @Rollback(true)
	public void testAddClient()
	{
		Client clIn=new Client("rara", "0625239632", "acquereur");
		
		int tailleAvant=clientDao.getAllClients().size();
		
		clientDao.addClient(clIn);
		
		int tailleApres=clientDao.getAllClients().size();
		
		assertEquals("rara", clientDao.getAllClients().get(tailleApres-1).getNom());
	}
	
	
	//test pour la suppression :
	@Test
    @Transactional
    @Rollback(true)
	public void testDeleteClient()
	{
		
		Client clIn= new Client("fafa", "0605896321", 9, "acquéreur");
		
		int tailleAvant=clientDao.getAllClients().size();
		
		//clientDao.deleteClient(clIn.getId_cl());
		
		clientDao.deleteClient(4);
		
		
		//int tailleApres=clientDao.getAllClients().size();
		
		assertEquals(tailleAvant-1, clientDao.getAllClients().size());
				
	}
	
	
	//test pour le findById
	@Test
	@Transactional(readOnly=true)
	public void testGetClientById()     //pour comparer nom 
	{
		clientDao.getClietById(6);
		assertEquals("titi", clientDao.getAllClients().get(4).getNom());
	}
	

}
