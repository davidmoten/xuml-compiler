package moten.david.util.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ThreadLocalEntityManagerProvider implements Provider<EntityManager>{

	private final ThreadLocalEntityManagerFactory emf;

	@Inject
	public ThreadLocalEntityManagerProvider(EntityManagerFactory emf) {
		this.emf = new ThreadLocalEntityManagerFactory(emf);
	}
	
	@Override
	public EntityManager get() {
		return emf.createEntityManager();
	}
	
}
