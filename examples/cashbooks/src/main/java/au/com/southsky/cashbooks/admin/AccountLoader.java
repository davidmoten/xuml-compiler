package au.com.southsky.cashbooks.admin;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;

import cashbooks.Account;
import cashbooks.CashBook;
import cashbooks.Customer;
import cashbooks.ObjectFactory;
import cashbooks.Account.EventNewAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountLoader extends Loader {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountLoader.class);	
	private final String [] csvFieldNames = {"CustShortname","AccountShortname","BSB","AccountNo","AccountName","Type ","Description","CashBookName"};

	public AccountLoader() {
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
			
			String cashbookName = fields.get(7);
			CashBook cashBook = CashBook.Search.findByName_Customer(em, cashbookName, customer);
			if (cashBook == null) {
				throw new LoaderException(String.format(
						"No cashbook called %s for customer with shortname of %s", cashbookName, shortname));
			}
			

			// create the Account object

			Account account = ObjectFactory.instance.createAccount();
			EventNewAccount newAccountEvent = new EventNewAccount();
			newAccountEvent.setAccountno(fields.get(3));
			newAccountEvent.setBsb(fields.get(2));
			newAccountEvent.setCashBook(cashBook);
			newAccountEvent.setCustomer(customer);
			newAccountEvent.setDecription(fields.get(6));
			newAccountEvent.setName(fields.get(4));
			newAccountEvent.setShortname(fields.get(1));
			newAccountEvent.setType(fields.get(5));
					
			// send  event to the account
			
			account.processEvent(newAccountEvent);

			em.persist(account);
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
