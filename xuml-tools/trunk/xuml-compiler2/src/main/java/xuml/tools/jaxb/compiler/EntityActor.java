package xuml.tools.jaxb.compiler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import akka.actor.UntypedActor;

public class EntityActor<T extends Entity<T, R>, R> extends UntypedActor {

	private final Class<T> cls;
	private final EntityManagerFactory emf;
	private final R id;

	public EntityActor(EntityManagerFactory emf, Class<T> cls, R id) {
		this.emf = emf;
		this.cls = cls;
		this.id = id;
	}

	@Override
	public void onReceive(Object o) throws Exception {
		try {
			Event<T> event = (Event<T>) o;
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			T t = em.find(cls, id);
			tx.begin();
			t.event(event);
			tx.commit();
			em.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
			// TODO use logger
		}
	}
}
