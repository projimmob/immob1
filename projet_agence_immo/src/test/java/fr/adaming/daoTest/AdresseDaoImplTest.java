package fr.adaming.daoTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.IAdresseDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class AdresseDaoImplTest {

	@Autowired
	private IAdresseDao adresseDao;
	
	
	
	
	
}
