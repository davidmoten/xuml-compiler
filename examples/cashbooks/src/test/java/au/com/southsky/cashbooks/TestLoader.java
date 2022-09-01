package au.com.southsky.cashbooks;
import java.io.File;

import javax.persistence.EntityManagerFactory;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import au.com.southsky.cashbooks.admin.AccountLoader;
import au.com.southsky.cashbooks.admin.CashbookColumnLoader;
import au.com.southsky.cashbooks.admin.CashbookLoader;
import au.com.southsky.cashbooks.admin.CustomerLoader;
import au.com.southsky.cashbooks.admin.EmailLoader;
import cashbooks.ObjectInjector;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLoader {

	private static final Logger logger = LoggerFactory
			.getLogger(TestLoader.class);
	
	// Input files with data for these tests
	
	private static String customerCsvPath = "./src/test/resources/loaderTestData/customers.csv";
	private static String emailCsvPath = "./src/test/resources/loaderTestData/email.csv";
	private static String cashbookCsvPath = "./src/test/resources/loaderTestData/cashbooks.csv";
	private static String accountCsvPath = "./src/test/resources/loaderTestData/accounts.csv";
	private static String cashbookColumnsCsvPath = "./src/test/resources/loaderTestData/cashbookColumns.csv";
	
	
	private static Injector injector = Guice
			.createInjector(new CashbooksInjectorModule());
//
//	private EntityManagerFactory entityManagerFactory;
//
//	public EntityManagerFactory getEntityManagerFactory() {
//		return entityManagerFactory;
//	}
//
//	@Inject
//	public void setEntityManagerFactory(
//			EntityManagerFactory entityManagerFactory) {
//		this.entityManagerFactory = entityManagerFactory;
//	}

	@BeforeClass
	public static void setup() {
	}

	@Before
	public void prepare() {
		injector.injectMembers(this);
	}

	@Test
	public void testCustomerLoad() throws Exception {

		logger.info("starting customer load test");
		ObjectInjector.setInjector(injector);

		File csvFile = new File(customerCsvPath);
		Assert.assertTrue(customerCsvPath + " must exist", csvFile.exists());

		CustomerLoader loader = new CustomerLoader();
		int count = loader.load(csvFile);
		
		logger.info(String.format("finished customer load test- %d customers loaded",count));

	}
	
	@Test
	public void testEmailLoad() throws Exception {

		logger.info("starting email load test");
		ObjectInjector.setInjector(injector);

		File csvFile = new File(emailCsvPath);
		Assert.assertTrue(emailCsvPath + " must exist", csvFile.exists());

		EmailLoader loader = new EmailLoader();
		int count = loader.load(csvFile);
		
		logger.info(String.format("finished email load test- %d emails loaded",count));

	}
	
	
	@Test
	public void testCashbookLoad() throws Exception {

		logger.info("starting Cashbook load test");
		ObjectInjector.setInjector(injector);

		File csvFile = new File(cashbookCsvPath);
		Assert.assertTrue(csvFile.getAbsolutePath() + " must exist", csvFile.exists());

		CashbookLoader loader = new CashbookLoader();
		int count = loader.load(csvFile);
		
		logger.info(String.format("finished Cashbook load test- %d Cashbooks loaded",count));

	}
	

	@Test
	public void testAccountLoad() throws Exception {

		logger.info("starting Account load test");
		ObjectInjector.setInjector(injector);

		File csvFile = new File(accountCsvPath);
		Assert.assertTrue(csvFile.getAbsolutePath() + " must exist", csvFile.exists());

		AccountLoader loader = new AccountLoader();
		int count = loader.load(csvFile);
		
		logger.info(String.format("finished Account load test- %d Cashbooks loaded",count));

	}
	
	@Test
	public void testCashbookColumnLoad() throws Exception {

		logger.info("starting CashbookColumn load test");
		ObjectInjector.setInjector(injector);

		File csvFile = new File(cashbookColumnsCsvPath);
		Assert.assertTrue(csvFile.getAbsolutePath() + " must exist", csvFile.exists());

		CashbookColumnLoader loader = new CashbookColumnLoader();
		int count = loader.load(csvFile);
		
		logger.info(String.format("finished CashbookColumn load test- %d CashbookColumns loaded",count));

	}
}
