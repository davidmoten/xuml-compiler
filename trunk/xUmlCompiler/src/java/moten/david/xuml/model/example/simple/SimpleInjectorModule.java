package moten.david.xuml.model.example.simple;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import simple.actions.CustomerActions;
import simple.actions.EmailActions;

import com.google.inject.AbstractModule;

public class SimpleInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CustomerActions.class).to(CustomerBehaviour.class);
		bind(EmailActions.class).to(EmailBehaviour.class);
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("simple"));
		bind(Test.class);
	}
}
