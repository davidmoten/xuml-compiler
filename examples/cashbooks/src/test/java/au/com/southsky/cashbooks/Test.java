package au.com.southsky.cashbooks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;

import cashbooks.Account;
import cashbooks.CashBook;
import cashbooks.Customer;
import cashbooks.Email;
import cashbooks.ObjectFactory;
import cashbooks.ObjectInjector;
import cashbooks.Account.EventNewAccount;
import cashbooks.CashBook.EventNewCashbook;
import cashbooks.Customer.EventActivate;
import cashbooks.Customer.EventAddEmail;
import cashbooks.Customer.EventNewCustomer;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Test {

	private final Logger log = Logger.getLogger(Test.class);

	private static Injector injector = Guice
			.createInjector(new CashbooksInjectorModule());

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
	public void testEmail() {
		log.info("starting email test");
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
		log.info("finished email test");
	}
	
	
	
	
	
	@org.junit.Test
	public void testCashbook() {
		log.info("starting cashbook test");
		ObjectInjector.setInjector(injector);
	//	bootstrap();

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		Customer fred = Customer.Search.findByName(em, "Fred");

		// add a couple of cashbooks
		
		CashBook personalCashBook = ObjectFactory.instance.createCashBook();
		EventNewCashbook newCashBook = new EventNewCashbook();
		newCashBook.setName("PersonalCashbook");
		newCashBook.setDescription("Records all personal transactions");
		newCashBook.setCustomer(fred);
		
		personalCashBook.processEvent(newCashBook);
		
		CashBook companyCashBook = ObjectFactory.instance.createCashBook();
		newCashBook = new EventNewCashbook();
		newCashBook.setName("CompanyCashbook");
		newCashBook.setDescription("Records all company-related transactions");
		newCashBook.setCustomer(fred);
		
		companyCashBook.processEvent(newCashBook);
		
	
		em.persist(personalCashBook);
		em.persist(companyCashBook);

		em.getTransaction().commit();
		em.close();

		em = entityManagerFactory.createEntityManager();
		fred = Customer.Search.findByName(em, "Fred");
		
		// check that the customer has 2 cashbooks
		
		Assert.assertEquals("there should be 2 cashbooks",2, fred.getCashBook().size());
		
		em.close();
		log.info("finished cashbook test");
	}
	
	@org.junit.Test
	public void testAccounts() {
		log.info("starting account test");
		ObjectInjector.setInjector(injector);

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		// get the test customer

		Customer fred = Customer.Search.findByName(em, "Fred");

		// get the two cashbooks
		
		CashBook personalCashBook = CashBook.Search.findByName_Customer(em, "PersonalCashbook", fred);
		CashBook companyCashBook = CashBook.Search.findByName_Customer(em, "CompanyCashbook", fred);
		

		// add 3 accounts, two personal and one business
		
		Account personalChequeAccount = ObjectFactory.instance.createAccount();
		EventNewAccount newAccount = new EventNewAccount();
		
		newAccount.setAccountno("123456789");
		newAccount.setBsb("062900");
		newAccount.setName("F J and A H Bloggs");
		newAccount.setShortname("Personal");
		newAccount.setDecription("Account used by Fred and Agnes for their personal transactions");
		newAccount.setType("CHEQUE");
		newAccount.setCustomer(fred);
		newAccount.setCashBook(personalCashBook);
		
		personalChequeAccount.processEvent(newAccount);
		
		Account companyChequeAccount = ObjectFactory.instance.createAccount();
		
		newAccount.setAccountno("98007654");
		newAccount.setBsb("062910");
		newAccount.setName("Bloggs Blogging Systems");
		newAccount.setShortname("Company");
		newAccount.setDecription("Account used by Fred and Agnes for company related transactions");
		newAccount.setType("CHEQUE");
		newAccount.setCustomer(fred);
		newAccount.setCashBook(companyCashBook);
		
		companyChequeAccount.processEvent(newAccount);
		
		
		Account creditAccount = ObjectFactory.instance.createAccount();
		
		newAccount.setAccountno("5353180096256453");
		newAccount.setBsb("1234");
		newAccount.setName("F J and A H Bloggs");
		newAccount.setShortname("Mastercard");
		newAccount.setDecription("Account used by Fred and Agnes for purchases on credit");
		newAccount.setType("CREDITCARD");
		newAccount.setCustomer(fred);
		newAccount.setCashBook(personalCashBook);
		
		creditAccount.processEvent(newAccount);
		
	
		em.persist(personalChequeAccount);
		em.persist(companyChequeAccount);
		em.persist(creditAccount);

		em.getTransaction().commit();
		em.close();

		em = entityManagerFactory.createEntityManager();
		fred = Customer.Search.findByName(em, "Fred");
		
		// check that the customer has 3 accounts
		
		Assert.assertEquals("there should be 3 accounts",3, fred.getAccount().size());
		
		em.close();
		log.info("finished cashbook test");
	}

	public static void main(String[] args) {
		Test test = injector.getInstance(Test.class);
		test.testEmail();
		test.testCashbook();
	}

}
