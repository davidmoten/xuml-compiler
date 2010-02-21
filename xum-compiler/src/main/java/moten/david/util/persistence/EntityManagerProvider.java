package moten.david.util.persistence;

import javax.persistence.EntityManager;

public interface EntityManagerProvider {

	EntityManager getEntityManager();
}
