package moten.david.xuml.model.example.tv;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;

import tv.Channel;
import tv.ObjectFactory;
import tv.ObjectInjector;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Test {
	private static Injector injector = Guice
			.createInjector(new TvInjectorModule());

	private EntityManagerFactory entityManagerFactory;

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
		ObjectInjector.setInjector(injector);
		EntityManager em = entityManagerFactory.createEntityManager();
		Channel channel = ObjectFactory.instance.createChannel();
		channel.setName("SBS");
		channel.setDescription("Special Broadcasting Service");
		em.persist(channel);
		em.close();
	}
}
