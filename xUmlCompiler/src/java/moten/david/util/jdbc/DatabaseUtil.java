package moten.david.util.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DatabaseUtil {

	private static final String ANY = "%";

	private static Logger log = Logger.getLogger(DatabaseUtil.class);

	private final DatabaseMetaData meta;

	public DatabaseUtil(Connection con) throws SQLException {
		meta = con.getMetaData();
	}

	public boolean tableExists(String schema, String table) throws SQLException {
		ResultSet rs = meta.getTables(null, schema.toUpperCase(), table
				.toUpperCase(), null);
		boolean exists = false;
		if (rs.next())
			exists = true;
		rs.close();
		return exists;
	}

	public boolean tableHasColumn(String schema, String table, String column,
			boolean mandatory) throws SQLException {
		ResultSet rs = meta.getColumns(null, schema.toUpperCase(), table
				.toUpperCase(), column.toUpperCase());
		boolean exists = false;
		if (rs.next())
			exists = mandatory == "NO".equals(rs.getString("IS_NULLABLE"));
		rs.close();
		return exists;
	}

	public int columnCount(String schema, String table) throws SQLException {
		ResultSet rs = meta.getColumns(null, schema.toUpperCase(), table
				.toUpperCase(), ANY);
		int count = 0;
		while (rs.next())
			count++;
		rs.close();
		return count;
	}

	public boolean isPrimaryKey(String schema, String table, String... columns)
			throws SQLException {
		ResultSet rs = meta.getPrimaryKeys(null, schema, table.toUpperCase());
		List<String> expectedColumns = new ArrayList<String>();
		for (String col : columns) {
			expectedColumns.add(col.toUpperCase());
		}
		List<String> actualColumns = new ArrayList<String>();
		while (rs.next()) {
			log.info("primary key for " + schema + "." + table + " = "
					+ rs.getString("COLUMN_NAME"));
			actualColumns.add(rs.getString("COLUMN_NAME"));
		}
		rs.close();
		return expectedColumns.equals(actualColumns);
	}

}
