package au.com.southsky.cashbooks.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import au.com.southsky.cashbooks.utils.CSVutil;
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
public class CustomerLoader extends Loader {

	private static final Logger logger = Logger.getLogger(CustomerLoader.class);
	private String [] csvFieldNames = {"Name", "Shortname"};


	public CustomerLoader() {
		super();
		injector.injectMembers(this);
	}

	public int load(File f) throws LoaderException {
		NewCustomerEventReader eventReader;
		try {
			eventReader = new NewCustomerEventReader(f);
		} catch (IOException e) {
			throw new LoaderException(e);
		}
		EventNewCustomer event;

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		int count = 0;
		while (null != (event = eventReader.next())) {
			Customer c = ObjectFactory.instance.createCustomer();
			c.processEvent(event);
			em.persist(c);
			count++;
		}

		em.getTransaction().commit();
		em.close();

		return count;
	}

	public class NewCustomerEventReader {
		private final BufferedReader in;
		private int count;

		public NewCustomerEventReader(File f) throws IOException, LoaderException {
			super();
			this.in = new BufferedReader(new InputStreamReader(
					new FileInputStream(f)));

			// check that column headings are what we expect

			checkCsvColumnNames(in.readLine());			
			count = 1;
		}

		public EventNewCustomer next() throws LoaderException {
			String rec = null;
			try {
				rec = in.readLine();

				if (rec == null) {
					in.close();
					return null;
				}
			} catch (IOException e) {
				throw new LoaderException(e);
			}

			count++;
			System.out.println(rec);

			// parse the line into fields

			List<String> fields = CSVutil.parse(rec);

			if (fields.size() < 2) {
				throw new LoaderException(
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
		} catch (Exception e) {
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

	@Override
	protected String[] getCsvFieldNames() {
		return csvFieldNames;
	}

}
