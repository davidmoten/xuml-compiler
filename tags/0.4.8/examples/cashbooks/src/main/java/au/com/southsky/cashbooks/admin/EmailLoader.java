package au.com.southsky.cashbooks.admin;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

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
		prepareReader(f);

		List<String> fields;

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		int count = 0;
		while (null != (fields = getNextRecord())) {

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

	@Override
	protected String[] getCsvFieldNames() {
		return csvFieldNames;
	}
}