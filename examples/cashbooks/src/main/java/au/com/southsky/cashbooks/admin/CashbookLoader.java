package au.com.southsky.cashbooks.admin;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;

import cashbooks.CashBook;
import cashbooks.Customer;
import cashbooks.ObjectFactory;
import cashbooks.CashBook.EventNewCashbook;
import cashbooks.Customer.EventAddEmail;

public class CashbookLoader extends Loader {
	
	private static final Logger logger = LoggerFactory.getLogger(CashbookLoader.class);
	private String[] csvFieldNames = { "Shortname", "Name", "Description" };

	public CashbookLoader() {
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

			// create the cashbook object

			CashBook cashBook = ObjectFactory.instance.createCashBook();
			EventNewCashbook newCashBook = new EventNewCashbook();
			newCashBook.setName(fields.get(1));
			newCashBook.setDescription(fields.get(2));
			newCashBook.setCustomer(customer);
			
			
			// send an AddEmail event to the cashbook
			
			cashBook.processEvent(newCashBook);

			em.persist(cashBook);
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
