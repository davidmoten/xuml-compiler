package moten.david.util.hibernate.utc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Like a Hibernate timestamp, but using the UTC TimeZone (not the default
 * TimeZone).
 */
public class TimestampType extends HibernateUTC {

	public static final String DATE_TIME_WITH_ERA = "yyyy MM dd HH:mm:ss.SSS G";
	private static Logger log = Logger.getLogger(TimestampType.class);

	/**
	 * @see net.sf.hibernate.UserType#deepCopy(java.lang.Object)
	 */
	public Object deepCopy(Object value) {
		return (value == null) ? null : new java.sql.Timestamp(((Date) value)
				.getTime());

	}

	/**
	 * @see net.sf.hibernate.UserType#nullSafeGet(java.sql.ResultSet,
	 *      java.lang.String[], java.lang.Object)
	 */
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws SQLException {

		log.debug("returning '"
				+ format(rs.getTimestamp(names[0], sUTCCalendar))
				+ "' as column:" + names[0]);
		return rs.getTimestamp(names[0], sUTCCalendar);
	}

	private String format(Timestamp t) {
		String s = null;
		if (t != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_WITH_ERA);
			s = sdf.format(t);
		}
		return s;
	}

	/**
	 * @see net.sf.hibernate.UserType#nullSafeSet(java.sql.PreparedStatement,
	 *      java.lang.Object, int)
	 */

	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws SQLException {
		if (!(value instanceof java.sql.Timestamp)) {
			value = deepCopy(value);
		}
		log.debug("binding '" + format((Timestamp) value) + "' to parameter:"
				+ index);
		st.setTimestamp(index, (java.sql.Timestamp) value, sUTCCalendar);
	}

}
