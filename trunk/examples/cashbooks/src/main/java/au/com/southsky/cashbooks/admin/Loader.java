package au.com.southsky.cashbooks.admin;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import au.com.southsky.cashbooks.CashbooksInjectorModule;
import au.com.southsky.cashbooks.utils.CSVutil;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public abstract class Loader {
	

	protected static Injector injector = Guice
			.createInjector(new CashbooksInjectorModule());

	protected EntityManagerFactory entityManagerFactory;

	protected EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@Inject
	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	abstract protected String[] getCsvFieldNames();

	protected void checkCsvColumnNames(String rec) throws LoaderException {
		List<String> fileFieldNames = CSVutil.parse(rec);
		String [] csvFieldNames = getCsvFieldNames();

		if (csvFieldNames.length > fileFieldNames.size()) {
			new LoaderException("Insufficient fields in file");
		}

		if (csvFieldNames.length < fileFieldNames.size()) {
			new LoaderException("Too many fields in file");
		}

		for (int i = 0; i < csvFieldNames.length; i++) {
			if (!(csvFieldNames[i].equals(fileFieldNames.get(i)))) {
				throw new LoaderException(String.format(
						"In field %d, was expection '%s' but got '%s'", i,
						csvFieldNames[i], fileFieldNames.get(i)));

			}
		}
	}

}
