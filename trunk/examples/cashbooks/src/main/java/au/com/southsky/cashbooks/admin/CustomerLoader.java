package au.com.southsky.cashbooks.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import au.com.southsky.cashbooks.CashbooksInjectorModule;
import au.com.southsky.cashbooks.utils.CVSutil;
import cashbooks.Customer;
import cashbooks.ObjectFactory;
import cashbooks.Customer.EventNewCustomer;

/**
 * Load customers from a CSV file
 * 
 * usage: java LoadCustomers <csvFilePath>
 * 
 * @author smr
 * 
 */
public class CustomerLoader {

	private static final Logger logger = Logger.getLogger(CustomerLoader.class);

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
	
	

	public CustomerLoader() {
		super();
		injector.injectMembers(this);
	}

	public void load(File f) throws IOException {
		NewCustomerEventReader eventReader = new NewCustomerEventReader(f);
		EventNewCustomer event;

		EntityManager em = entityManagerFactory.createEntityManager();

		while (null != (event = eventReader.next())) {
			Customer c = ObjectFactory.instance.createCustomer();
			EventNewCustomer newCustomer = new EventNewCustomer();
			c.processEvent(event);
			em.persist(c);
		}

		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
	}

	public class NewCustomerEventReader {
		private final BufferedReader in;
		private int count;

		public NewCustomerEventReader(File f) throws IOException {
			super();
			this.in = new BufferedReader(new InputStreamReader(
					new FileInputStream(f)));

			// throw away the first line

			in.readLine();
			count = 1;
		}

		public EventNewCustomer next() throws IOException {
			String rec = in.readLine();

			if (rec == null) {
				in.close();
				return null;
			}

			count++;
			System.out.println(rec);

			// parse the line into fields

			List<String> fields = CVSutil.parse(rec);

			if (fields.size() < 2) {
				throw new IOException(
						"Insuffient fields to construct event at line " + count);
			}
			EventNewCustomer event = new EventNewCustomer();
			event.setName(fields.get(0));
			event.setShortname(fields.get(1));

			return event;

		}

	}

	public static void main(String[] args) {

		BasicConfigurator.configure();

		if (args.length < 1) {
			usage("Path to csv file is missing");
			System.exit(1);
		}

		File csvFile = new File(args[0]);
		if (!csvFile.exists()) {
			usage(String
					.format("File %s is missing", csvFile.getAbsolutePath()));
			System.exit(1);
		}

		CustomerLoader loader = new CustomerLoader();
		try {
			loader.load(csvFile);
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}

	}

	public static void usage(String msg) {
		if (msg != null) {
			logger.error(msg);
		}
		logger.info("usage: java LoadCustomers <csvFilePath>");
	}

}
