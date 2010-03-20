package au.com.southsky.cashbooks.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import au.com.southsky.cashbooks.utils.CSVutil;
import cashbooks.Customer;
import cashbooks.Email;
import cashbooks.ObjectFactory;
import cashbooks.Customer.EventAddEmail;

public class EmailLoader extends Loader {

	private static final Logger logger = Logger.getLogger(CustomerLoader.class);
	private String[] csvFieldNames = { "Shortname", "Email" };

	public EmailLoader() {
		super();
		injector.injectMembers(this);
	}

	public int load(File f) throws LoaderException {
		NewEmailEventReader eventReader;
		try {
			eventReader = new NewEmailEventReader(f);
		} catch (IOException e) {
			throw new LoaderException(e);
		}
		List<String> fields;

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		int count = 0;
		while (null != (fields = eventReader.getNextRecord())) {

			// look up the customer

			String shortname = fields.get(0);
			Customer customer = Customer.Search.findByShortname(em, shortname);
			if (customer == null) {
				throw new LoaderException(String.format(
						"No customer with shortname of %s", shortname));
			}

			// create the Email object

			Email email = ObjectFactory.instance.createEmail();
			email.setCustomer(customer);
			email.setEmail(fields.get(1));

			// send an AddEmail event to the customer

			EventAddEmail addEmail = new EventAddEmail();
			addEmail.setEmail(email);
			customer.processEvent(addEmail);
			em.persist(email);
			count++;
		}

		em.getTransaction().commit();
		em.close();

		return count;
	}

	public class NewEmailEventReader {
		private final BufferedReader in;
		private int count;

		public NewEmailEventReader(File f) throws IOException, LoaderException {
			super();
			this.in = new BufferedReader(new InputStreamReader(
					new FileInputStream(f)));

			// check that column headings are what we expect

			checkCsvColumnNames(in.readLine());
			count = 1;
		}

		public List<String> getNextRecord() throws LoaderException {
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

			// parse the line into fields

			List<String> fields = CSVutil.parse(rec);

			if (fields.size() < csvFieldNames.length) {
				throw new LoaderException(
						"Insuffient fields to construct event at line " + count);
			}
			return fields;
		}
	}

	@Override
	protected String[] getCsvFieldNames() {
		return csvFieldNames;
	}
}