package moten.david.uml.xuml.model.example.simple;

import javax.persistence.EntityManagerFactory;

import simple.Email;
import simple.actions.EmailActions;

import com.google.inject.Inject;

public class EmailBehaviour implements EmailActions {

	private Email email;
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void setEmail(Email email) {
		this.email = email;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@Inject
	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public void send(String subject, String body, String from) {
		System.out.println("sending an email to " + email.getEmail() + ": "
				+ subject);
	}

}
