package moten.david.uml.xuml.model.example.simple;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SimpleEntityManagerFactory implements EntityManagerFactory {

	private EntityManagerFactory emf;

	public SimpleEntityManagerFactory() {
		Persistence.createEntityManagerFactory("simple");
	}

	@Override
	public void close() {
		emf.close();
	}

	@Override
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	@Override
	public EntityManager createEntityManager(Map arg0) {
		return emf.createEntityManager(arg0);
	}

	@Override
	public boolean isOpen() {
		return emf.isOpen();
	}

}
