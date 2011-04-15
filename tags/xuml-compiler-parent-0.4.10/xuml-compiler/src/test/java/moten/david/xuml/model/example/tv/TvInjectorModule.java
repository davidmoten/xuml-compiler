package moten.david.xuml.model.example.tv;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;

public class TvInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("tv"));
	}
}
