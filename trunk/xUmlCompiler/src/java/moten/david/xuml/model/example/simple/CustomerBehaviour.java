package moten.david.xuml.model.example.simple;

import simple.Customer;
import simple.Customer.EventActivate;
import simple.Customer.EventAddEmail;
import simple.Customer.EventDeactivate;
import simple.actions.CustomerActions;

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
		event.getEmail().setCustomer(customer);
	}

}
