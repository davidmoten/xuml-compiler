package moten.david.util.hibernate.utc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;

/**
 * Like a Hibernate time, but using the UTC TimeZone (not the default TimeZone).
 */
public class TimeType extends HibernateUTC {

	private static Logger log = Logger.getLogger(TimeType.class);
	protected static int[] SQL_TYPES_TIME = { Types.TIME };

	/**
	 * @see net.sf.hibernate.UserType#sqlTypes()
	 */
	@Override
	public int[] sqlTypes() {
		return SQL_TYPES_TIME;
	}

	/**
	 * @see net.sf.hibernate.UserType#deepCopy(java.lang.Object)
	 */
	public Object deepCopy(Object value) {
		return (value == null) ? null : new java.sql.Time(((Date) value)
				.getTime());
	}

	/**
	 * @see net.sf.hibernate.UserType#nullSafeGet(java.sql.ResultSet,
	 *      java.lang.String[], java.lang.Object)
	 */
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws SQLException {
		log.debug("returning '" + rs.getTime(names[0], sUTCCalendar)
				+ "' from column:" + names[0]);
		return rs.getTime(names[0], sUTCCalendar);
	}

	/**
	 * @see net.sf.hibernate.UserType#nullSafeSet(java.sql.PreparedStatement,
	 *      java.lang.Object, int)
	 */
	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws SQLException {
		if (!(value instanceof java.sql.Time))
			value = deepCopy(value);
		log.debug("binding '" + value + "' to parameter:" + index);
		st.setTime(index, (java.sql.Time) value, sUTCCalendar);
	}
}
