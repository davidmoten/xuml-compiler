package moten.david.xuml.model.example.simple;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import simple.Customer;
import simple.Email;
import simple.ObjectFactory;
import simple.ObjectInjector;
import simple.Customer.EventActivate;
import simple.Customer.EventAddEmail;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class TestSimple {

	private Logger log = Logger.getLogger(TestSimple.class);

	private static Injector injector = Guice
			.createInjector(new SimpleInjectorModule());

	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@Inject
	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	private void bootstrap() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Customer c = ObjectFactory.instance.createCustomer();
		c.setName("Fred");
		c.setActive(false);
		em.persist(c);
		em.getTransaction().commit();
		em.close();

	}

	public void run() {
		ObjectInjector.setInjector(injector);
		bootstrap();

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		Customer fred = Customer.Search.findByName(em, "Fred");
		fred.processEvent(new EventActivate());

		Email email = ObjectFactory.instance.createEmail();
		email.setEmail("fred.smith@googlecode.com");

		EventAddEmail addEmail = new EventAddEmail();
		addEmail.setEmail(email);
		fred.processEvent(addEmail);

		em.persist(email);
		em.getTransaction().commit();
		em.close();

		em = entityManagerFactory.createEntityManager();
		fred = Customer.Search.findByName(em, "Fred");
		for (Email mail : fred.getEmail()) {
			mail.send("Hi", "This is a test message", "xUmlCompiler");
		}
		em.close();
		log.info("finished run");

	}

	public static void main(String[] args) {

		TestSimple test = injector.getInstance(TestSimple.class);
		test.run();
	}

}
