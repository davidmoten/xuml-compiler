package moten.david.util.persistence;

import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import com.google.inject.Inject;

public class ThreadLocalEntityManagerFactory implements EntityManagerFactory {

    private ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();
    private EntityManagerFactory emf;

    @Inject
    public ThreadLocalEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void close() {
        emf.close();
    }

    private EntityManager _createEntityManager(@SuppressWarnings("rawtypes") Map map) {
        if (threadLocal.get() == null)
            createNewEntityManager(null);
        else if (!threadLocal.get().isOpen()) {
            createNewEntityManager(map);
        }
        return threadLocal.get();
    }

    private void createNewEntityManager(@SuppressWarnings("rawtypes") Map map) {
        EntityManager em;
        if (map == null)
            em = emf.createEntityManager();
        else
            em = emf.createEntityManager(map);

        NotifyingEntityManager nem = new NotifyingEntityManager(em);

        // after close is called on the entitymanager remove it from
        // threadLocal
        nem.addListener(new EntityManagerListener() {
            @Override
            public void afterClose() {
                threadLocal.remove();
            }
        });
        threadLocal.remove();
        threadLocal.set(nem);
    }

    @Override
    public EntityManager createEntityManager() {
        return _createEntityManager(null);
    }

    @Override
    public EntityManager createEntityManager(@SuppressWarnings("rawtypes") Map map) {
        return _createEntityManager(map);
    }

    @Override
    public boolean isOpen() {
        return emf.isOpen();
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return emf.getCriteriaBuilder();
    }

    @Override
    public Metamodel getMetamodel() {
        return emf.getMetamodel();
    }

    @Override
    public Map<String, Object> getProperties() {
        return emf.getProperties();
    }

    @Override
    public Cache getCache() {
        return emf.getCache();
    }

    @Override
    public PersistenceUnitUtil getPersistenceUnitUtil() {
        return emf.getPersistenceUnitUtil();
    }

    @Override
    public EntityManager createEntityManager(SynchronizationType synchronizationType) {
        return emf.createEntityManager(synchronizationType);
    }

    @Override
    public EntityManager createEntityManager(SynchronizationType synchronizationType, Map map) {
        return emf.createEntityManager(synchronizationType, map);
    }

    @Override
    public void addNamedQuery(String name, Query query) {
        emf.addNamedQuery(name, query);
    }

    @Override
    public <T> T unwrap(Class<T> cls) {
        return emf.unwrap(cls);
    }

    @Override
    public <T> void addNamedEntityGraph(String graphName, EntityGraph<T> entityGraph) {
        emf.addNamedEntityGraph(graphName, entityGraph);
    }

}