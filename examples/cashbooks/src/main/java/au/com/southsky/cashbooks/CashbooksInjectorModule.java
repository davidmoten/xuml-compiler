package au.com.southsky.cashbooks;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cashbooks.actions.CustomerActions;
import cashbooks.actions.EmailActions;

import com.google.inject.AbstractModule;

public class CashbooksInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CustomerActions.class).to(CustomerBehaviour.class);
		bind(EmailActions.class).to(EmailBehaviour.class);
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("cashbooks-derby"));
	}
}
