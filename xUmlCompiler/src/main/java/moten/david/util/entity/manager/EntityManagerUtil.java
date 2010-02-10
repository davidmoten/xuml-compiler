package moten.david.util.entity.manager;

import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import junit.framework.Assert;
import moten.david.util.text.StringUtil;
import moten.david.xuml.model.compiler.runtime.InvalidRecordException;

import org.apache.log4j.Logger;

public class EntityManagerUtil {

	private static Logger log = Logger.getLogger(EntityManagerUtil.class);

	public static void persist(EntityManagerFactory emf, Object... objects)
			throws Exception {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		try {
			for (Object o : objects)
				em.persist(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public static void persistExpectInvalidRecordException(
			EntityManagerFactory emf, Object... a) throws Exception {
		try {
			persist(emf, a);
			Assert.fail();
		} catch (InvalidRecordException e) {
			log.info(e);
		}
	}

	public static void persistExpectPropertyValueException(
			EntityManagerFactory emf, Object... a) throws Exception {
		try {
			persist(emf, a);
			Assert.fail();
		} catch (PersistenceException e) {
			log.info(e);
			if (!e.getMessage().contains(
					"not-null property references a null or transient value")) {
				throw new Error(e);
			}
		}
	}

	public static void runScript(EntityManagerFactory emf, InputStream is) {
		String s;
		try {
			s = StringUtil.readString(is);
		} catch (IOException e) {
			throw new Error(e);
		}
		String[] commands = s.split(";");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for (String command : commands) {
			log.info(command);
			if (command != null && command.trim().length() > 0)
				em.createNativeQuery(command.trim()).executeUpdate();
		}
		em.getTransaction().commit();
		em.close();
	}
}
