package moten.david.xuml.model.example.simple;

import model.CallEvent;
import model.Class;
import model.Package;
import model.State;
import moten.david.xuml.model.Multiplicity;
import moten.david.xuml.model.util.SystemBase;

import org.junit.Test;

public class Simple extends SystemBase {

	public Simple() {
		// note that we pass a null schema name because hsqldb doesn't create
		// schemas for us
		// during hbm2ddl.SchemaExport and errors occur
		super(null, "Simple");
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
		createAttribute(customer, "name").setUnique(true);
		State inactive = createState(customer, "Inactive");
		State active = createState(customer, "Active");
		CallEvent newCustomer = createCallEvent(customer, "newCustomer");
		createParameter(newCustomer, "name");
		CallEvent activate = createCallEvent(customer, "activate");
		CallEvent deactivate = createCallEvent(customer, "deactivate");
		CallEvent addEmail = createCallEvent(customer, "addEmail");
		createParameter(addEmail, "email", "simple.Email");
		createTransition(inactive, active, activate);
		createTransition(active, inactive, deactivate);
		createTransition(active, active, addEmail);
		createTransition(customer.getStateMachine().getInitialState(),
				inactive, newCustomer);
		CallEvent remove = createCallEvent(customer, "remove");
		createTransition(inactive, customer.getStateMachine().getFinalState(),
				remove);
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

	@Override
	@Test
	public void validate() throws ValidationException {
		super.validate();
	}

}
