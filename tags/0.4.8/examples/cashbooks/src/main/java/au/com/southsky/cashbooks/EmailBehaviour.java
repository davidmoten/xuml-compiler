package au.com.southsky.cashbooks;

import org.apache.log4j.Logger;

import cashbooks.Email;
import cashbooks.actions.EmailActions;

public class EmailBehaviour implements  EmailActions {

        private static Logger log = Logger.getLogger(EmailBehaviour.class);
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

