package moten.david.xuml.model.example.shop;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import shop.ObjectFactory;
import shop.Order;
import shop.Shipment;
import shop.Order.EventAddProduct;
import shop.Order.EventCancel;
import shop.Order.EventChangeProductQuantity;
import shop.Order.EventCreateOrder;
import shop.Order.EventRemoveProduct;
import shop.Order.EventShip;
import shop.Shipment.EventCreateShipment;

import com.google.inject.Inject;

public class OrderBehaviour implements shop.actions.OrderActions {

	private Order order;

	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@Inject
	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public void performOnEntryBeingPreparedAndShipped(EventShip event) {
		Shipment shipment = ObjectFactory.instance.createShipment();
		EventCreateShipment createShipment = new EventCreateShipment();
		createShipment.setShippingName(order.getCustomer().getShippingName());
		createShipment.setShippingAddress(order.getCustomer()
				.getShippingAddress());
		createShipment.setEmail(order.getCustomer().getEmail());
		createShipment.setOrder(order);
		shipment.processEvent(createShipment);
	}

	@Override
	public void performOnEntryCancelled(EventCancel event) {
		if (order.getShipment() != null) {
			shop.Shipment.EventCancel cancel = new shop.Shipment.EventCancel();
			cancel.setTime(new Date());
			order.getShipment().processEvent(cancel);
		}
	}

	@Override
	public void performOnEntryOpen(EventCreateOrder event) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		// establish R1
		order.setCustomer(event.getCustomer());
		em.persist(order);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void performOnEntryOpen(EventAddProduct event) {

	}

	@Override
	public void performOnEntryOpen(EventRemoveProduct event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void performOnEntryOpen(EventChangeProductQuantity event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOrder(Order order) {
		this.order = order;
	}

}
