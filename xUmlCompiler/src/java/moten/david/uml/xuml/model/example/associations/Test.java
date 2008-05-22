package moten.david.uml.xuml.model.example.associations;

import java.sql.Connection;
import java.sql.SQLException;

import moten.david.uml.xuml.model.Multiplicity;
import moten.david.uml.xuml.model.compiler.util.Database;
import moten.david.util.jdbc.DatabaseUtil;
import moten.david.util.jdbc.MetaDataReporter;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class Test {

	private static Logger log = Logger.getLogger(Test.class);

	@org.junit.Test
	public void test() throws Exception {
		Database.createNew();
		Connection con = Database.getConnection();
		MetaDataReporter reporter = new MetaDataReporter(con.getMetaData());
		log.info("metadata:\n" + reporter.getReport("CTS"));
		log.info("metadata:\n" + reporter.getReport("BOOKSTORE"));
		for (Multiplicity m1 : Multiplicity.values()) {
			for (Multiplicity m2 : Multiplicity.values()) {
				String schema = m1 + "_TO_" + m2;
				log.info(schema);
				log.info("metadata:\n" + reporter.getReport(schema));
			}
		}

		DatabaseUtil db = new DatabaseUtil(con);
		int counter = 0;
		String schema;

		// need validation checks on this
		schema = "ONE_TO_ONE";
		checkTables(db, schema, ++counter, 1, 2, true, false);
		// need validation checks on this
		schema = "ONE_TO_ZERO_ONE";
		checkTables(db, schema, ++counter, 1, 2, true, false);
		// need validation checks on this
		schema = "ONE_TO_ONE_MANY";
		checkTables(db, schema, ++counter, 1, 2, true, false);
		// need validation checks on this
		schema = "ONE_TO_MANY";
		checkTables(db, schema, ++counter, 1, 2, true, false);
		// need validation checks on this
		schema = "ZERO_ONE_TO_ONE";
		checkTables(db, schema, ++counter, 2, 1, false, true);
		// need validation checks on this
		schema = "ZERO_ONE_TO_ZERO_ONE";
		checkTables(db, schema, ++counter, 1, 2, false, false);

		con.close();
		Database.shutdown();
	}

	private void checkTables(DatabaseUtil db, String schema, int counter,
			int aColumnCount, int bColumnCount, boolean aRoleMandatory,
			boolean bRoleMandatory) throws SQLException {
		String tableA = "A" + counter;
		String tableB = "B" + counter;
		String roleA = "athing";
		String roleB = "bthing";
		String id = "_id";
		Assert.assertTrue(db.tableExists(schema, tableA));
		Assert.assertTrue(db.tableExists(schema, tableB));
		Assert.assertTrue(db.isPrimaryKey(schema, tableA, tableA + id));
		Assert.assertTrue(db.isPrimaryKey(schema, tableB, tableB + id));
		Assert.assertEquals(aColumnCount, db.columnCount(schema, tableA));
		Assert.assertEquals(bColumnCount, db.columnCount(schema, tableB));
		if (bColumnCount > 1)
			Assert.assertTrue(db.tableHasColumn(schema, tableB, roleA + id,
					aRoleMandatory));
		if (aColumnCount > 1)
			Assert.assertTrue(db.tableHasColumn(schema, tableA, roleB + id,
					bRoleMandatory));

	}

}
