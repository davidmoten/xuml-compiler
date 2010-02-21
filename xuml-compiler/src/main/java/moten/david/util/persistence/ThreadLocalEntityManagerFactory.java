package moten.david.util.persistence;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.Inject;

public class ThreadLocalEntityManagerFactory implements EntityManagerFactory {

	private ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
	private EntityManagerFactory emf;

	@Inject
	public ThreadLocalEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void close() {
		emf.close();
	}

	private EntityManager _createEntityManager(Map map) {
		if (threadLocal.get() == null)
			createNewEntityManager(null);
		else if (!threadLocal.get().isOpen()) {
			createNewEntityManager(map);
		}
		return threadLocal.get();
	}

	private void createNewEntityManager(Map map) {
		EntityManager em;
		if (map == null)
			em = emf.createEntityManager();
		else
			em = emf.createEntityManager(map);

		NotifyingEntityManager nem = new NotifyingEntityManager(em);

		// after close is called on the entitymanager remove it from
				// threadLocal
		nem.addListener(new EntityManagerListener() {
			@Override
			public void afterClose() {
				threadLocal.remove();
			}
		});
		threadLocal.remove();
		threadLocal.set(nem);
	}

	@Override
	public EntityManager createEntityManager() {
		return _createEntityManager(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public EntityManager createEntityManager(Map map) {
		return _createEntityManager(map);
	}

	@Override
	public boolean isOpen() {
		return emf.isOpen();
	}

}