package moten.david.uml.xuml.model.example.shop;

import shop.actions.CustomerActions;
import shop.actions.OrderActions;
import shop.actions.ShipmentActions;

import com.google.inject.AbstractModule;

public class ShopInjectorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(OrderActions.class).to(OrderBehaviour.class);
		bind(ShipmentActions.class).to(ShipmentBehaviour.class);
		bind(CustomerActions.class).to(CustomerBehaviour.class);
	}

}
