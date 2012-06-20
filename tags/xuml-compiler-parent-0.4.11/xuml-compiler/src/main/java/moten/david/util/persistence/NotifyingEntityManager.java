package moten.david.util.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;

public class NotifyingEntityManager implements EntityManager {

	private final EntityManager em;

	private final List<EntityManagerListener> listeners = new ArrayList<EntityManagerListener>();

	public NotifyingEntityManager(EntityManager em) {
		this.em = em;
	}

	public void addListener(EntityManagerListener l) {
		listeners.add(l);
	}

	public void removeListener(EntityManagerListener l) {
		listeners.add(l);
	}

	@Override
	public void clear() {
		em.clear();
	}

	@Override
	public void close() {
		em.close();
		fireClosed();
	}

	private void fireClosed() {
		for (EntityManagerListener l : listeners)
			l.afterClose();
	}

	@Override
	public boolean contains(Object arg0) {
		return em.contains(arg0);
	}

	@Override
	public Query createNamedQuery(String arg0) {
		return em.createNamedQuery(arg0);
	}

	@Override
	public Query createNativeQuery(String arg0) {
		return em.createNativeQuery(arg0);
	}

	@Override
	public Query createNativeQuery(String arg0, Class arg1) {
		return em.createNativeQuery(arg0, arg1);
	}

	@Override
	public Query createNativeQuery(String arg0, String arg1) {
		return em.createNativeQuery(arg0, arg1);
	}

	@Override
	public Query createQuery(String arg0) {
		return em.createQuery(arg0);
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1) {
		return em.find(arg0, arg1);
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public Object getDelegate() {
		return em.getDelegate();
	}

	@Override
	public FlushModeType getFlushMode() {
		return em.getFlushMode();
	}

	@Override
	public <T> T getReference(Class<T> arg0, Object arg1) {
		return em.getReference(arg0, arg1);
	}

	@Override
	public EntityTransaction getTransaction() {
		return em.getTransaction();
	}

	@Override
	public boolean isOpen() {
		return em.isOpen();
	}

	@Override
	public void joinTransaction() {
		em.joinTransaction();
	}

	@Override
	public void lock(Object arg0, LockModeType arg1) {
		em.lock(arg0, arg1);
	}

	@Override
	public <T> T merge(T arg0) {
		return em.merge(arg0);
	}

	@Override
	public void persist(Object arg0) {
		em.persist(arg0);
	}

	@Override
	public void refresh(Object arg0) {
		em.refresh(arg0);
	}

	@Override
	public void remove(Object arg0) {
		em.remove(arg0);
	}

	@Override
	public void setFlushMode(FlushModeType arg0) {
		em.setFlushMode(arg0);
	}

}
