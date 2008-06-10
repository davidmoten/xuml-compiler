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
		activate(true);
	}

	private void activate(boolean activate) {
		customer.setActive(activate);
	}

	@Override
	public void performOnEntryInactive(EventDeactivate event) {
		activate(false);
	}

	@Override
	public void performOnEntryActive(EventAddEmail event) {
		event.getEmail().setCustomer(customer);
		customer.getEmail().add(event.getEmail());
	}

}
