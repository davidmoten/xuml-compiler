package moten.david.xuml.model.example.specialize;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;

public class SpecializeInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("specialize"));
	}
}
