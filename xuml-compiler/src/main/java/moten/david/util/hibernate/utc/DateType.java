package moten.david.util.hibernate.utc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Like a Hibernate date, but using the UTC TimeZone (not the default TimeZone).
 */
public class DateType extends HibernateUTC {
	private static Logger log = LoggerFactory.getLogger(DateType.class);
	protected static int[] SQL_TYPES_DATE = { Types.DATE };

	@Override
	public int[] sqlTypes() {
		return SQL_TYPES_DATE;
	}

	@Override
    public Object deepCopy(Object value) {
		return (value == null) ? null : new java.sql.Date(((Date) value)
				.getTime());

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

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        log.debug("returning '" + format(rs.getDate(names[0], sUTCCalendar))
        + "' as column:" + names[0]);
        return rs.getDate(names[0], sUTCCalendar);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (!(value instanceof java.sql.Date))
            value = deepCopy(value);
        log.debug("binding '" + value + "' to parameter:" + index);
        st.setDate(index, (java.sql.Date) value, sUTCCalendar);
    }

}
