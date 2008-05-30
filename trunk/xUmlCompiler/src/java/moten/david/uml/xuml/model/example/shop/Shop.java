package moten.david.uml.xuml.model.example.shop;

import java.io.IOException;

import model.AssociationClass;
import model.Class;
import model.Primitive;
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
		createAttribute(shipment, "timePacked", Primitive.TIMESTAMP);
		createAttribute(shipment, "timeSent", Primitive.TIMESTAMP);
		createAttribute(shipment, "timeUnpacked", Primitive.TIMESTAMP);
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
		createState(order, "Created");
		createCallEvent(order, "createOrder");
		createState(order, "Open");
		createSignalEvent(order, "addProduct");
		createSignalEvent(order, "createShipment");
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Shop shop = new Shop();
		shop.view("src/viewer/Shop.ini");
	}

}
