package moten.david.xuml.model.example.mellor;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;

public class BookstoreInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("bookstore"));
	}

}
