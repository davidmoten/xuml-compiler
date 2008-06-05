package moten.david.uml.xuml.model.example.shop;

import shop.Customer;
import shop.actions.CustomerActions;

public class CustomerBehaviour implements CustomerActions {

	private Customer customer;

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void sendMessage(String subject, String body) {
		String destination = customer.getEmail();
		sendEmail(subject, body, destination);
	}

	private void sendEmail(String subject, String body, String destination) {
		// TODO
	}
}
