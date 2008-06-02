package moten.david.uml.xuml.model.example.shop;

import java.io.IOException;

import model.AssociationClass;
import model.CallEvent;
import model.Class;
import model.Primitive;
import model.SignalEvent;
import model.State;
import moten.david.uml.xuml.model.Multiplicity;
import moten.david.uml.xuml.model.util.SystemBase;

public class Shop extends SystemBase {

	private static final String schema = "SHOP";
	private static final String systemName = "Shop";

	public Shop() {
		super(schema, systemName);
		initialize();
	}

	private void initialize() {
		model.Package pkg = createRootPackage("shop", "shop system");
		Class customer = createClassWithArbitraryId(pkg, "Customer",
				"a shop customer, a potential or actual purchaser of products from the shop");
		createAttribute(customer, "name");
		createAttribute(customer, "email");
		createAttribute(customer, "billingName");
		createAttribute(customer, "billingAddress");
		createAttribute(customer, "shippingName");
		createAttribute(customer, "shippingAddress");

		Class order = createClassWithArbitraryId(pkg, "Order",
				"an order of products made by a customer");
		createAttribute(order, "timeCreated", Primitive.TIMESTAMP);

		Class product = createClassWithArbitraryId(pkg, "Product", "products");
		createAttribute(product, "numberInStock", Primitive.INTEGER);
		createAttribute(product, "numberCommitted", Primitive.INTEGER);

		AssociationClass orderProduct = createAssociationClassWithArbitraryId(
				pkg, "OrderProduct", "products on an order");
		createAttribute(orderProduct, "itemCount", Primitive.INTEGER);

		Class shipment = createClassWithArbitraryId(pkg, "Shipment",
				"shipment of an order");
		createAttribute(shipment, "shippingName");
		createAttribute(shipment, "shippingAddress");
		createAttribute(shipment, "email");
		createAttribute(shipment, "timePacked", Primitive.TIMESTAMP);
		createAttribute(shipment, "timeShipped", Primitive.TIMESTAMP);
		createAttribute(shipment, "timeDelivered", Primitive.TIMESTAMP);
		createAttribute(shipment, "timeReturned", Primitive.TIMESTAMP);
		createAttribute(shipment, "timeUnpacked", Primitive.TIMESTAMP);
		createAttribute(shipment, "timeLost", Primitive.TIMESTAMP);
		createAttribute(shipment, "comment");

		createAssociation("R1", createAssociationEndPrimary(customer,
				Multiplicity.ONE, "is made by"), createAssociationEndSecondary(
				order, Multiplicity.MANY, "makes"));
		createAssociation("R2", createAssociationEndPrimary(order,
				Multiplicity.ONE, "delivers"), createAssociationEndSecondary(
				shipment, Multiplicity.ZERO_ONE, "is delivered by"));

		createAssociation(
				"R3",
				createAssociationEndPrimary(order, Multiplicity.MANY,
						"is included in"),
				createAssociationEndSecondary(product, Multiplicity.MANY,
						"includes")).setAssociationClass(orderProduct);

		createOrderStateMachine(order);
		createShipmentStateMachine(shipment);
	}

	public void createOrderStateMachine(Class order) {
		State open = createState(order, "Open");
		State delivered = createState(order, "Delivered");
		State cancelled = createState(order, "Cancelled");
		State beingPreparedAndShipped = createState(order,
				"BeingPreparedAndShipped");
		CallEvent createOrder = createCallEvent(order, "createOrder");
		SignalEvent addProduct = createSignalEvent(order, "addProduct");
		createParameter(addProduct, "product", "Product");
		SignalEvent removeProduct = createSignalEvent(order, "removeProduct");
		createParameter(removeProduct, "product", "Product");
		SignalEvent changeQuantity = createSignalEvent(order,
				"changeProductQuantity");
		createParameter(changeQuantity, "product", "Product");
		createParameter(changeQuantity, "newQuantity",
				"new quantity of product", Primitive.INTEGER);
		SignalEvent ship = createSignalEvent(order, "ship");
		SignalEvent cancel = createSignalEvent(order, "cancel");

		createTransition(order.getStateMachine().getInitialState(), open,
				createOrder);
		createTransition(open, open, addProduct);
		createTransition(open, open, changeQuantity);
		createTransition(open, open, removeProduct);
		createTransition(open, cancelled, cancel);
		createTransition(beingPreparedAndShipped, cancelled, cancel);
		createTransition(open, beingPreparedAndShipped, ship);
	}

	private void createShipmentStateMachine(Class shipment) {
		State beingPrepared = createState(shipment, "BeingPrepared");
		State beingShipped = createState(shipment, "BeingShipped");
		State shippedState = createState(shipment, "Shipped");
		State cancelled = createState(shipment, "Cancelled");
		State deliveredState = createState(shipment, "Delivered");
		State lostState = createState(shipment, "Lost");
		State returnedState = createState(shipment, "Returned");
		CallEvent ship = createCallEvent(shipment, "createShipment");
		createParameter(ship, "order", "Order");
		SignalEvent prepared = createSignalEvent(shipment, "prepared");
		createParameter(prepared, "time", "time prepared", Primitive.TIMESTAMP);
		SignalEvent shipped = createSignalEvent(shipment, "shipped");
		createParameter(shipped, "time", "time shipped", Primitive.TIMESTAMP);
		SignalEvent delivered = createSignalEvent(shipment, "delivered");
		createParameter(delivered, "time", "time delivered",
				Primitive.TIMESTAMP);
		SignalEvent cancel = createSignalEvent(shipment, "cancel");
		createParameter(cancel, "time", "time cancelled", Primitive.TIMESTAMP);
		SignalEvent lost = createSignalEvent(shipment, "lost");
		createParameter(lost, "time", "time lost", Primitive.TIMESTAMP);
		createParameter(cancel, "comment");
		SignalEvent returned = createSignalEvent(shipment, "returned");
		createParameter(returned, "time", "time returned", Primitive.TIMESTAMP);
		createParameter(returned, "comment");

		createTransition(shipment.getStateMachine().getInitialState(),
				beingPrepared, ship);
		createTransition(beingPrepared, beingShipped, prepared);
		createTransition(beingShipped, shippedState, shipped);
		createTransition(beingPrepared, cancelled, cancel);
		createTransition(beingShipped, cancelled, cancel);
		createTransition(shippedState, deliveredState, delivered);
		createTransition(shippedState, lostState, lost);
		createTransition(shippedState, returnedState, returned);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Shop shop = new Shop();
		shop.view("src/viewer/Shop.ini");
	}

}
