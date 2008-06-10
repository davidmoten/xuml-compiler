package moten.david.xuml.model.example.simple;

import javax.persistence.EntityManagerFactory;

import simple.actions.CustomerActions;
import simple.actions.EmailActions;

import com.google.inject.AbstractModule;

public class SimpleInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CustomerActions.class).to(CustomerBehaviour.class);
		bind(EmailActions.class).to(EmailBehaviour.class);
		bind(EntityManagerFactory.class).to(SimpleEntityManagerFactory.class);
		bind(TestSimple.class);
	}
}
