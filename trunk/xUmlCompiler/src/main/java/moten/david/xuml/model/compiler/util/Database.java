package moten.david.xuml.model.compiler.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.SQLTransientConnectionException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import moten.david.util.derby.DerbyUtil;

import org.apache.log4j.Logger;

public class Database {
	private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static Logger log = Logger.getLogger(Database.class);
	private static final String DERBY_SHUTDOWN = ";shutdown=true";
	private static final String HIBERNATE_CONNECTION_URL = "hibernate.connection.url";
	private static final String HIBERNATE_PROPERTIES = "hibernate.properties";
	private static String path = "temp/db";

	private static void deleteDatabase() {
		File dbFolder = new File(path);
		Util.delete(dbFolder);
	}

	public static EntityManagerFactory deleteDatabaseAndCreateEntityManagerFactory()
			throws IOException, SQLException, ClassNotFoundException {
		deleteDatabase();
		return createEntityManagerFactory(true);
	}

	public static EntityManagerFactory createEntityManagerFactory(boolean create)
			throws IOException {
		DerbyUtil.divertLog();
		Properties p = new Properties();
		p.load(Database.class.getResourceAsStream(HIBERNATE_PROPERTIES));
		if (!create)
			p.remove(HIBERNATE_HBM2DDL_AUTO);
		log.info(HIBERNATE_HBM2DDL_AUTO + "="
				+ p.getProperty(HIBERNATE_HBM2DDL_AUTO));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("db",
				p);
		return emf;
	}

	public static void persist(EntityManagerFactory emf, Object... a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for (Object o : a)
			em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

	public static void createNew() throws IOException, SQLException,
			ClassNotFoundException {
		// create a new database using the persistence.xml
		// to create new tables
		EntityManagerFactory emf = Database
				.deleteDatabaseAndCreateEntityManagerFactory();

	}

	public static void shutdown() throws IOException, SQLException {
		Properties p = new Properties();
		p.load(Database.class.getResourceAsStream(HIBERNATE_PROPERTIES));
		String connectionUrl = p.getProperty(HIBERNATE_CONNECTION_URL);
		if (connectionUrl.contains(":derby:")) {
			try {
				DriverManager.getConnection(connectionUrl + DERBY_SHUTDOWN);
			} catch (SQLTransientConnectionException e) {
				// do nothing
			} catch (SQLNonTransientConnectionException e) {
				// do nothing
			}
		}
	}

	public static void main(String[] args) throws IOException, SQLException,
			ClassNotFoundException {
		Database.deleteDatabaseAndCreateEntityManagerFactory();
		shutdown();
	}

	public static Connection getConnection() throws IOException,
			ClassNotFoundException, SQLException {
		DerbyUtil.divertLog();
		Properties p = new Properties();
		p.load(Database.class.getResourceAsStream("hibernate.properties"));
		Class.forName(p.getProperty("hibernate.connection.driver_class"));
		Connection con = DriverManager.getConnection(p
				.getProperty("hibernate.connection.url"));
		return con;
	}

}
