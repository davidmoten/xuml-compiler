package moten.david.util.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.Inject;

public class ThreadLocalEntityManagerProvider implements EntityManagerProvider {

	private final EntityManagerFactory entityManagerFactory;

	/**
	 * expects a ThreadLocalEntityManagerFactory
	 * 
	 * @param entityManagerFactory
	 */
	@Inject
	public ThreadLocalEntityManagerProvider(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}