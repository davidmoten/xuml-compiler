package moten.david.uml.xuml.model.example.microwave;

import microwave.actions.MicrowaveActions;

import com.google.inject.AbstractModule;

public class MicrowaveInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MicrowaveActions.class).to(MicrowaveBehaviour.class);
	}

}
