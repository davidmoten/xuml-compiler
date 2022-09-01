package moten.david.xuml.model.example.simple;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Assert;
import org.junit.Before;

import simple.Customer;
import simple.Email;
import simple.ObjectFactory;
import simple.ObjectInjector;
import simple.Customer.EventActivate;
import simple.Customer.EventAddEmail;
import simple.Customer.EventNewCustomer;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Test.class);

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

	@Before
	public void prepare() {
		injector.injectMembers(this);
	}

	private void bootstrap() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Customer c = ObjectFactory.instance.createCustomer();
		EventNewCustomer newCustomer = new EventNewCustomer();
		newCustomer.setName("Fred");
		c.processEvent(newCustomer);
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	@org.junit.Test
	public void test() {
		log.info("starting");
		ObjectInjector.setInjector(injector);
		bootstrap();

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		Email email = ObjectFactory.instance.createEmail();
		email.setEmail("fred.smith@googlecode.com");

		EventAddEmail addEmail = new EventAddEmail();
		addEmail.setEmail(email);

		Customer fred = Customer.Search.findByName(em, "Fred");
		fred.processEvent(addEmail);
		// no email should be added till the customer is activated
		Assert.assertEquals(0, fred.getEmail().size());

		fred.processEvent(new EventActivate());
		fred.processEvent(addEmail);

		em.persist(email);
		em.getTransaction().commit();
		em.close();

		em = entityManagerFactory.createEntityManager();
		fred = Customer.Search.findByName(em, "Fred");
		// now that the customer has been activated, the email can be added
		Assert.assertEquals(1, fred.getEmail().size());
		for (Email mail : fred.getEmail())
			mail.send("Hi", "This is a test message", "xUmlCompiler");
		em.close();
		log.info("finished");
	}

	public static void main(String[] args) {
		Test test = injector.getInstance(Test.class);
		test.test();
	}

}
