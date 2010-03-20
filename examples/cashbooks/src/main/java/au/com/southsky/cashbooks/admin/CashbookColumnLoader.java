package au.com.southsky.cashbooks.admin;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import cashbooks.CashBook;
import cashbooks.CashbookColumn;
import cashbooks.Customer;
import cashbooks.ObjectFactory;

public class CashbookColumnLoader extends Loader {
	
	private static final Logger logger = Logger.getLogger(AccountLoader.class);	
	private final String [] csvFieldNames = {"CustShortname","CashBookName","Name","Description","Cash"};

	
	public CashbookColumnLoader() {
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
			
			// lookup the cashbook
			
			String cashbookName = fields.get(1);
			CashBook cashBook = CashBook.Search.findByName_Customer(em, cashbookName, customer);
			if (cashBook == null) {
				throw new LoaderException(String.format(
						"No cashbook called %s for customer with shortname of %s", cashbookName, shortname));
			}
			

			// create the CashbookColumn object

			CashbookColumn cbColumn = ObjectFactory.instance.createCashbookColumn();
			
			cbColumn.setCashBook(cashBook);
			cbColumn.setName(fields.get(2));
			cbColumn.setDescription(fields.get(3));
			cbColumn.setCash(fields.get(4).equals("TRUE"));
					
			em.persist(cbColumn);
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
