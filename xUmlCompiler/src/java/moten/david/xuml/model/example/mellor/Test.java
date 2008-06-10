package moten.david.xuml.model.example.mellor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import junit.framework.Assert;
import moten.david.util.derby.DerbyUtil;
import moten.david.util.entity.manager.EntityManagerUtil;
import moten.david.util.jdbc.DatabaseUtil;
import moten.david.xuml.model.compiler.util.Database;

import org.apache.log4j.Logger;

import bookstore.Author;
import bookstore.Authorship;
import bookstore.Book;
import bookstore.ObjectFactory;
import bookstore.Publisher;

public class Test {
	private static Logger log = Logger.getLogger(Test.class);

	public static Author createAuthor(String name) {
		Author author = ObjectFactory.instance.createAuthor();
		author.setName(name);
		return author;
	}

	public static Book createBook(String title) {
		Book book = ObjectFactory.instance.createBook();
		book.setTitle(title);
		return book;
	}

	public static Authorship createAuthorship(Author author, Book book) {
		Authorship authorship = ObjectFactory.instance.createAuthorship();
		author.getAuthorship().add(authorship);
		book.getAuthorship().add(authorship);
		authorship.setAuthor(author);
		authorship.setBook(book);
		return authorship;
	}

	public void test() throws Exception {

		DerbyUtil.divertLog();
		EntityManagerFactory emf = Database
				.deleteDatabaseAndCreateEntityManagerFactory();

		Author author = createAuthor("Fred Smith");
		EntityManagerUtil.persistExpectInvalidRecordException(emf, author);

		Book book = createBook("Jumbos throughout history");
		Authorship authorship = createAuthorship(author, book);

		EntityManagerUtil.persistExpectPropertyValueException(emf, author,
				book, authorship);

		author = createAuthor("Fred Smith");
		book = createBook("Jumbos throughout history");
		book.setBookNumber("II45fgh");
		book.setProductId("hello");
		Publisher publisher = createPublisher("Allen Unwin");
		book.setPublisher(publisher);
		publisher.getBook().add(book);
		authorship = createAuthorship(author, book);

		EntityManagerUtil.persist(emf, publisher, book, author, authorship);

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		author = (Author) em.createQuery("from Author where id=1")
				.getSingleResult();
		log.info(author.getName());
		em.getTransaction().commit();
		em.close();

	}

	private Publisher createPublisher(String name) {
		Publisher publisher = ObjectFactory.instance.createPublisher();
		publisher.setName(name);
		publisher.setGroupCode("LARGE");
		publisher.setPublisherCode("AUS");
		return publisher;
	}

	@org.junit.Test
	public void testTables() throws SQLException, IOException,
			ClassNotFoundException {

		// Database.createNew();
		// now connect to the created database with jdbc
		Connection con = Database.getConnection();
		try {
			String schema = "BOOKSTORE";
			DatabaseUtil db = new DatabaseUtil(con);
			Assert.assertTrue(db.tableExists(schema, "BOOK"));
			Assert.assertTrue(db.tableHasColumn(schema, "BOOK", "BOOK_NUMBER",
					true));
			Assert.assertTrue(db.isPrimaryKey(schema, "BOOK", "BOOK_NUMBER"));
		} finally {
			con.close();
		}
		Database.shutdown();

	}
}
