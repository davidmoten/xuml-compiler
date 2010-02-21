package moten.david.util.hibernate.utc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/**
 * Like a Hibernate date, but using the UTC TimeZone (not the default TimeZone).
 */
public class DateType extends HibernateUTC {
	private static Logger log = Logger.getLogger(DateType.class);
	protected static int[] SQL_TYPES_DATE = { Types.DATE };

	/**
	 * @see net.sf.hibernate.UserType#sqlTypes()
	 */
	@Override
	public int[] sqlTypes() {
		return SQL_TYPES_DATE;
	}

	/**
	 * @see net.sf.hibernate.UserType#deepCopy(java.lang.Object)
	 */
	public Object deepCopy(Object value) {
		return (value == null) ? null : new java.sql.Date(((Date) value)
				.getTime());

	}

	/**
	 * @see net.sf.hibernate.UserType#nullSafeGet(java.sql.ResultSet,
	 *      java.lang.String[], java.lang.Object)
	 */
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws SQLException {
		log.debug("returning '" + format(rs.getDate(names[0], sUTCCalendar))
				+ "' as column:" + names[0]);
		return rs.getDate(names[0], sUTCCalendar);
	}

	private String format(java.sql.Date d) {
		String s = null;
		if (d != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(
					TimestampType.DATE_TIME_WITH_ERA);
			s = sdf.format(d);
		}
		return s;
	}

	/**
	 * @see net.sf.hibernate.UserType#nullSafeSet(java.sql.PreparedStatement,
	 *      java.lang.Object, int)
	 */
	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws SQLException {
		if (!(value instanceof java.sql.Date))
			value = deepCopy(value);
		log.debug("binding '" + value + "' to parameter:" + index);
		st.setDate(index, (java.sql.Date) value, sUTCCalendar);
	}

}
