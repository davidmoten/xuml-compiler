package moten.david.xuml.model.example.shop;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		bind(EntityManagerFactory.class).toInstance(
				Persistence.createEntityManagerFactory("shop"));
	}

}
