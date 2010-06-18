package moten.david.util.jdbc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaDataReporter {

	private final DatabaseMetaData meta;

	public MetaDataReporter(DatabaseMetaData meta) {
		this.meta = meta;
	}

	public String getReport(String schema) throws SQLException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(bytes);
		ResultSet rs = meta.getColumns(null, (schema == null ? null : schema
				.toUpperCase()), "%", "%");
		JdbcUtil.printResultSet(rs, out);
		return bytes.toString();
	}

}
