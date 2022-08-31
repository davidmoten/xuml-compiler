package moten.david.util.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

public class NotifyingEntityManager implements EntityManager {

    private final EntityManager em;

    private final List<EntityManagerListener> listeners = new ArrayList<>();

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
    public Query createNativeQuery(String arg0, @SuppressWarnings("rawtypes") Class arg1) {
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

    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
        return em.find(entityClass, primaryKey, properties);
    }

    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
        return em.find(entityClass, primaryKey, lockMode);
    }

    @Override
    public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
        return em.find(entityClass, primaryKey, lockMode, properties);
    }

    @Override
    public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
        em.lock(entity, lockMode, properties);
    }

    @Override
    public void refresh(Object entity, Map<String, Object> properties) {
        em.refresh(entity, properties);
    }

    @Override
    public void refresh(Object entity, LockModeType lockMode) {
        em.refresh(entity, lockMode);
    }

    @Override
    public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
        em.refresh(entity, lockMode, properties);
    }

    @Override
    public void detach(Object entity) {
        em.detach(entity);
    }

    @Override
    public LockModeType getLockMode(Object entity) {
        return em.getLockMode(entity);
    }

    @Override
    public void setProperty(String propertyName, Object value) {
        em.setProperty(propertyName, value);
    }

    @Override
    public Map<String, Object> getProperties() {
        return em.getProperties();
    }

    @Override
    public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return em.createQuery(criteriaQuery);
    }

    @Override
    public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
        return em.createQuery(qlString, resultClass);
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
        return em.createNamedQuery(name, resultClass);
    }

    @Override
    public <T> T unwrap(Class<T> cls) {
        return em.unwrap(cls);
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return em.getEntityManagerFactory();
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return em.getCriteriaBuilder();
    }

    @Override
    public Metamodel getMetamodel() {
        return em.getMetamodel();
    }

    @Override
    public Query createQuery(CriteriaUpdate updateQuery) {
        return em.createQuery(updateQuery);
    }

    @Override
    public Query createQuery(CriteriaDelete deleteQuery) {
        return em.createQuery(deleteQuery);
    }

    @Override
    public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
        return em.createNamedStoredProcedureQuery(name);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
        return em.createStoredProcedureQuery(procedureName);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
        return em.createStoredProcedureQuery(procedureName, resultClasses);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
        return em.createStoredProcedureQuery(procedureName, resultSetMappings);
    }

    @Override
    public boolean isJoinedToTransaction() {
        return em.isJoinedToTransaction();
    }

    @Override
    public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
        return em.createEntityGraph(rootType);
    }

    @Override
    public EntityGraph<?> createEntityGraph(String graphName) {
        return em.createEntityGraph(graphName);
    }

    @Override
    public EntityGraph<?> getEntityGraph(String graphName) {
        return em.getEntityGraph(graphName);
    }

    @Override
    public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
        return em.getEntityGraphs(entityClass);
    }

}
