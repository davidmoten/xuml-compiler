package au.com.southsky.cashbooks;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cashbooks.actions.AccountActions;
import cashbooks.actions.CashBookActions;
import cashbooks.actions.CustomerActions;
import cashbooks.actions.EmailActions;

import com.google.inject.AbstractModule;

public class CashbooksInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CustomerActions.class).to(CustomerBehaviour.class);
		bind(EmailActions.class).to(EmailBehaviour.class);
		bind(CashBookActions.class).to(CashbookBehaviour.class);
		bind(AccountActions.class).to(AccountBehaviour.class);
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("cashbooks-derby"));
	}
}
