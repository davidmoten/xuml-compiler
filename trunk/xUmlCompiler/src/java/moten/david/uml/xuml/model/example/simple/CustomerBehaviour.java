package moten.david.uml.xuml.model.example.simple;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import simple.Customer;
import simple.Email;
import simple.ObjectFactory;
import simple.Customer.EventActivate;
import simple.Customer.EventAddEmail;
import simple.Customer.EventDeactivate;
import simple.Customer.EventNewCustomer;
import simple.actions.CustomerActions;

import com.google.inject.Inject;

public class CustomerBehaviour implements CustomerActions {

	private EntityManagerFactory entityManagerFactory;
	private Customer customer;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@Inject
	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public void performOnEntryActive(EventActivate event) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		customer.setActive(true);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void performOnEntryActive(EventAddEmail event) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		Email email = ObjectFactory.instance.createEmail();
		email.setEmail(event.getEmail());
		em.persist(email);
		customer.getEmail().add(email);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void performOnEntryInactive(EventNewCustomer event) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		customer.setName(event.getName());
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void performOnEntryInactive(EventDeactivate event) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		customer.setActive(false);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
