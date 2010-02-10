package moten.david.xuml.model.example.microwave;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import microwave.actions.MicrowaveActions;

import com.google.inject.AbstractModule;

public class MicrowaveInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MicrowaveActions.class).to(MicrowaveBehaviour.class);
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("microwave"));
	}

}
