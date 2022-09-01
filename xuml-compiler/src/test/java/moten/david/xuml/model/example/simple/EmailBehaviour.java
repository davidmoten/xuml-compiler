package moten.david.xuml.model.example.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.Email;
import simple.actions.EmailActions;

public class EmailBehaviour implements EmailActions {

	private static Logger log = LoggerFactory.getLogger(EmailBehaviour.class);
	private Email email;

	@Override
	public void setEmail(Email email) {
		this.email = email;
	}

	@Override
	public void send(String subject, String body, String from) {
		log.info("sending an email to " + email.getEmail() + ": " + subject);
		log.info("body: " + body);
	}

}
