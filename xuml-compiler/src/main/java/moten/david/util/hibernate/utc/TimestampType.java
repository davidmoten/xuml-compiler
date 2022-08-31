package moten.david.util.hibernate.utc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

/**
 * Like a Hibernate timestamp, but using the UTC TimeZone (not the default
 * TimeZone).
 */
public class TimestampType extends HibernateUTC {

	public static final String DATE_TIME_WITH_ERA = "yyyy MM dd HH:mm:ss.SSS G";
	private static Logger log = Logger.getLogger(TimestampType.class);

	public Object deepCopy(Object value) {
		return (value == null) ? null : new java.sql.Timestamp(((Date) value)
				.getTime());

	}

	private String format(Timestamp t) {
		String s = null;
		if (t != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_WITH_ERA);
			s = sdf.format(t);
		}
		return s;
	}

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        log.debug("returning '"
                + format(rs.getTimestamp(names[0], sUTCCalendar))
                + "' as column:" + names[0]);
        return rs.getTimestamp(names[0], sUTCCalendar);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (!(value instanceof java.sql.Timestamp)) {
            value = deepCopy(value);
        }
        log.debug("binding '" + format((Timestamp) value) + "' to parameter:"
                + index);
        st.setTimestamp(index, (java.sql.Timestamp) value, sUTCCalendar);        
    }

}
