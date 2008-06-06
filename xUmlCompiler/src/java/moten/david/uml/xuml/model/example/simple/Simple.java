package moten.david.uml.xuml.model.example.simple;

import java.io.IOException;

import model.CallEvent;
import model.Class;
import model.Package;
import model.Primitive;
import model.SignalEvent;
import model.State;
import moten.david.uml.xuml.model.Multiplicity;
import moten.david.uml.xuml.model.util.SystemBase;

public class Simple extends SystemBase {

	public Simple() {
		super("simple", "Simple");
		initialize();
	}

	private void initialize() {
		model.Package pkg = createRootPackage("simple", "a simple system");

		Class customer = createCustomer(pkg);
		Class email = createEmail(pkg);

		createAssociation("R1", createAssociationEndPrimary(customer,
				Multiplicity.ONE, "is used to contact"),
				createAssociationEndSecondary(email, Multiplicity.MANY,
						"is contactable via"));
	}

	private Class createCustomer(Package pkg) {
		Class customer = createClassWithArbitraryId(pkg, "Customer",
				"a customer, possible contactable using multiple emails");
		createAttribute(customer, "name");
		createAttribute(customer, "active", Primitive.BOOLEAN);
		State inactive = createState(customer, "Inactive");
		State active = createState(customer, "Active");
		CallEvent newCustomer = createCallEvent(customer, "newCustomer");
		SignalEvent activate = createSignalEvent(customer, "activate");
		SignalEvent deactivate = createSignalEvent(customer, "deactivate");
		SignalEvent addEmail = createSignalEvent(customer, "addEmail");
		createParameter(newCustomer, "name");
		createParameter(addEmail, "email");
		createTransition(customer.getStateMachine().getInitialState(),
				inactive, newCustomer);
		createTransition(inactive, active, activate);
		createTransition(active, inactive, deactivate);
		createTransition(active, active, addEmail);
		return customer;
	}

	private Class createEmail(Package pkg) {
		Class email = createClassWithArbitraryId(pkg, "Email",
				"an email address belonging to a customer, e.g fred@google.com");
		createAttribute(email, "email");
		createOperation(email, "send", "sends an email", null, false,
				createParameter("subject", "subject line of the email"),
				createParameter("body", "body of the message"),
				createParameter("from", "the sender of the email"));
		return email;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Simple simple = new Simple();
		simple.view("src/viewer/Simple.ini");
	}

}
