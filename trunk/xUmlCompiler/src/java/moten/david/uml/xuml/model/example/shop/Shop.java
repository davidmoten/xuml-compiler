package moten.david.uml.xuml.model.example.shop;

import java.io.IOException;

import model.AssociationClass;
import model.Class;
import model.Primitive;
import moten.david.uml.xuml.model.Generator;
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
		Class request = createClass(pkg, "Request", "a purchase request");
		createPrimaryKey(
				createAttribute(request, "id", Primitive.ARBITRARY_ID),
				Generator.GENERATED_VALUE);
		createAttribute(request, "whenReceived", Primitive.TIMESTAMP);
		createAttribute(request, "prepaid", Primitive.BOOLEAN);
		createAttribute(request, "number", Primitive.INTEGER);
		createAttribute(request, "price", Primitive.DECIMAL);

		AssociationClass customerRequest = createAssociationClass(pkg,
				"CustomerRequest", "");
		createPrimaryKey(createAttribute(customerRequest, "id",
				Primitive.ARBITRARY_ID), Generator.GENERATED_VALUE);

		Class customer = createClass(pkg, "ShopCustomer", "shop customer");
		createPrimaryKey(
				createAttribute(customer, "id", Primitive.ARBITRARY_ID),
				Generator.GENERATED_VALUE);
		createAttribute(customer, "name", Primitive.STRING);
		createAttribute(customer, "address", Primitive.STRING);
		createAssociation(
				"R1",
				createAssociationEndPrimary(request, Multiplicity.MANY,
						"places"),
				createAssociationEndSecondary(customer, Multiplicity.MANY,
						"is placed by")).setAssociationClass(customerRequest);

		createOperation(request, "dispatch", "dispatches the order", null,
				false);
		createOperation(
				customer,
				"getCreditRating",
				"gets the credit rating for this customer as an integer 1-5, 1 is most trusted",
				"Integer", false);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Shop shop = new Shop();
		shop.view("src/viewer/Shop.ini");
	}

}
