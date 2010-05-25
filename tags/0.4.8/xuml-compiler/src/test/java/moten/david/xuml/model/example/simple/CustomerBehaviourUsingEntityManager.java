package moten.david.xuml.model.example.simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import simple.Customer;
import simple.Customer.EventActivate;
import simple.Customer.EventAddEmail;
import simple.Customer.EventDeactivate;
import simple.Customer.EventNewCustomer;
import simple.Customer.EventRemove;
import simple.actions.CustomerActions;

import com.google.inject.Inject;

public class CustomerBehaviourUsingEntityManager implements CustomerActions {

    private Customer customer;
    private final EntityManager em;

    @Inject
    public CustomerBehaviourUsingEntityManager(EntityManager em) {
        this.em = em;
    }

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

        // an example of using the injected entity manager:
        // do some query like find customers with the same name

        // write a query using JPSQL
        String sql = "select c from Customer c where name=:name";
        Query query = em.createQuery(sql)
                .setParameter(":name", event.getName());

        List<Customer> customersWithSameName = query.getResultList();
        System.out.println("number of customers with the same name = "
                + customersWithSameName.size());
    }
}
