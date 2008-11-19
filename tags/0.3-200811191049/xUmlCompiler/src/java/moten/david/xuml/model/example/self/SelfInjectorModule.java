package moten.david.xuml.model.example.self;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;

public class SelfInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("self"));
		bind(Test.class);
	}
}
