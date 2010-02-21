package au.com.southsky.cashbooks;

import cashbooks.Customer;
import cashbooks.Customer.EventActivate;
import cashbooks.Customer.EventAddEmail;
import cashbooks.Customer.EventDeactivate;
import cashbooks.Customer.EventNewCustomer;
import cashbooks.Customer.EventRemove;
import cashbooks.actions.CustomerActions;

public class CustomerBehaviour implements CustomerActions {

	private Customer customer;

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void performOnEntryActive(EventActivate event) {
	}

	@Override
	public void performOnEntryInactive(EventDeactivate event) {
	}

	@Override
	public void performOnEntryActive(EventAddEmail event) {
		// establish R1
		event.getEmail().setCustomer(customer);
	}

	@Override
	public void performOnEntryFinalState(EventRemove event) {
		// TODO remove an entity (will need to inject an entity manager)
	}

	@Override
	public void performOnEntryInactive(EventNewCustomer event) {
		customer.setName(event.getName());
		customer.setShortname(event.getName());
	}

}
