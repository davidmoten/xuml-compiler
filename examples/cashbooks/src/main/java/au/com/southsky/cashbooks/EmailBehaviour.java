package au.com.southsky.cashbooks;

import cashbooks.Email;
import cashbooks.actions.EmailActions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailBehaviour implements  EmailActions {

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

