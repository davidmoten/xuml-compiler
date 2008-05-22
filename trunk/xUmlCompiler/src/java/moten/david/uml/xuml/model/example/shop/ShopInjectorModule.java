package moten.david.uml.xuml.model.example.shop;

import shop.actions.RequestActions;

import com.google.inject.AbstractModule;

public class ShopInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RequestActions.class).to(RequestBehaviour.class);
	}

}
