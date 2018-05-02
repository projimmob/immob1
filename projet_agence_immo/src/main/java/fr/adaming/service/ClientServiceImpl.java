package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientDao clDao;

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clDao.getAllClients();
	}

	@Override
	public Client addClient(Client cl) {
		// TODO Auto-generated method stub
		return clDao.addClient(cl);
	}

	@Override
	public Client updateClient(Client cl) {
		// TODO Auto-generated method stub
		return clDao.updateClient(cl);
	}

	@Override
	public void deleteClient(long id) {
		clDao.deleteClient(id);
		
	}

	@Override
	public Client getClietById(long id) {
		// TODO Auto-generated method stub
		return clDao.getClietById(id);
	}

}
