package moten.david.xuml.model.example.shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import shop.Shipment;
import shop.Shipment.EventCancel;
import shop.Shipment.EventCreateShipment;
import shop.Shipment.EventDelivered;
import shop.Shipment.EventLost;
import shop.Shipment.EventPrepared;
import shop.Shipment.EventReturned;
import shop.Shipment.EventShipped;
import shop.actions.ShipmentActions;

import com.google.inject.Inject;

public class ShipmentBehaviour implements ShipmentActions {

	private Shipment shipment;
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
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	@Override
	public void performOnEntryBeingPrepared(EventCreateShipment event) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		// initialise shipment
		shipment.setShippingName(event.getShippingName());
		shipment.setShippingAddress(event.getShippingAddress());
		shipment.setEmail(event.getEmail());

		// establish R2
		shipment.setOrder(event.getOrder());
		em.persist(shipment);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void performOnEntryCancelled(EventCancel event) {

	}

	@Override
	public void performOnEntryDelivered(EventDelivered event) {
		shipment.setTimeDelivered(event.getTime());
	}

	@Override
	public void performOnEntryLost(EventLost event) {
		shipment.setTimeLost(event.getTime());
	}

	@Override
	public void performOnEntryReadyForShipping(EventPrepared event) {

	}

	@Override
	public void performOnEntryReturned(EventReturned event) {
		shipment.setTimeReturned(event.getTime());
	}

	@Override
	public void performOnEntryShipped(EventShipped event) {
		shipment.setTimeShipped(event.getTime());
	}

}
