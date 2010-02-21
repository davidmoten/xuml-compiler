package moten.david.util.jdbc;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JdbcUtil {

	public static void printResultSet(ResultSet rs, PrintStream out)
			throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			out.print(rsmd.getColumnName(i) + "\t");
		}
		out.println();
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				Object o = rs.getObject(i);
				out.print(o + "\t");
			}
			out.println();
		}
	}
}
