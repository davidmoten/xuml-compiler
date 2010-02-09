package moten.david.xuml.model.example.self;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.junit.Before;

import self.ObjectInjector;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Test {

	private Logger log = Logger.getLogger(Test.class);

	private static Injector injector = Guice
			.createInjector(new SelfInjectorModule());

	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@Inject
	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Before
	public void prepare() {
		injector.injectMembers(this);
	}

	@org.junit.Test
	public void test() {
		log.info("starting");
		ObjectInjector.setInjector(injector);
		EntityManager em = entityManagerFactory.createEntityManager();
		em.close();
	}

}
