package moten.david.util.hibernate.utc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

/**
 * Like a Hibernate time, but using the UTC TimeZone (not the default TimeZone).
 */
public class TimeType extends HibernateUTC {

    private static Logger log = Logger.getLogger(TimeType.class);
    protected static int[] SQL_TYPES_TIME = { Types.TIME };

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES_TIME;
    }

    public Object deepCopy(Object value) {
        return (value == null) ? null : new java.sql.Time(((Date) value).getTime());
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        log.debug("returning '" + rs.getTime(names[0], sUTCCalendar) + "' from column:" + names[0]);
        return rs.getTime(names[0], sUTCCalendar);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (!(value instanceof java.sql.Time))
            value = deepCopy(value);
        log.debug("binding '" + value + "' to parameter:" + index);
        st.setTime(index, (java.sql.Time) value, sUTCCalendar);
    }
}
