package moten.david.util.hibernate.utc;

import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public abstract class HibernateUTC implements UserType {

    private static Logger log = LoggerFactory.getLogger(HibernateUTC.class);

    /** the SQL type this type manages */
    protected static int[] SQL_TYPES_UTC = { Types.TIMESTAMP };

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES_UTC;
    }

    @Override
    public boolean equals(Object x, Object y) {
        return (x == null) ? (y == null) : x.equals(y);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Class returnedClass() {
        return objectClass;
    }

    /**
     * The class of objects returned by <code>nullSafeGet</code>. Currently,
     * returned objects are derived from this class, not exactly this class.
     */
    protected Class objectClass = Date.class;

    /**
     * Get a hashcode for the instance, consistent with persistence "equality"
     */
    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    /**
     * Transform the object into its cacheable representation. At the very least
     * this method should perform a deep copy if the type is mutable. That may not
     * be enough for some implementations, however; for example, associations must
     * be cached as identifier values. (optional operation)
     *
     * @param value the object to be cached
     * @return a cachable representation of the object
     * @throws HibernateException
     */
    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    /**
     * Reconstruct an object from the cacheable representation. At the very least
     * this method should perform a deep copy if the type is mutable. (optional
     * operation)
     *
     * @param cached the object to be cached
     * @param owner  the owner of the cached object
     * @return a reconstructed object from the cachable representation
     * @throws HibernateException
     */
    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    /**
     * During merge, replace the existing (target) value in the entity we are
     * merging to with a new (original) value from the detached entity we are
     * merging. For immutable objects, or null values, it is safe to simply return
     * the first parameter. For mutable objects, it is safe to return a copy of the
     * first parameter. For objects with component values, it might make sense to
     * recursively replace component values.
     *
     * @param original the value from the detached entity being merged
     * @param target   the value in the managed entity
     * @return the value to be merged
     */
    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }

    public static class CalendarType extends HibernateUTC {

        public Class getReturnedClass() {
            return Calendar.class;
        }

        /**
         * @see net.sf.hibernate.UserType#deepCopy(java.lang.Object)
         */
        @Override
        public Object deepCopy(Object value) {
            if (value == null) {
                return null;
            }
            Calendar c = (Calendar) sUTCCalendar.clone();
            c.setTimeInMillis(((Calendar) value).getTimeInMillis());
            return c;
        }

        @Override
        public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
                throws HibernateException, SQLException {
            Timestamp ts = rs.getTimestamp(names[0], sUTCCalendar);
            if (ts == null || rs.wasNull()) {
                return null;
            }
            Calendar cal = (Calendar) sUTCCalendar.clone();
            cal.setTime(ts);
            return cal;
        }

        @Override
        public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
                throws HibernateException, SQLException {
            if (value == null) {
                log.debug("binding null to parameter:" + index);
                st.setNull(index, Types.TIMESTAMP);
            } else {
                Timestamp t = new Timestamp(((Calendar) value).getTimeInMillis());
                log.debug("binding '" + value + "' to parameter:" + index);
                st.setTimestamp(index, t, sUTCCalendar);
            }
        }

        /*
         * (non-Javadoc)
         *
         * @see org.hibernate.usertype.UserType#equals(java.lang.Object,
         * java.lang.Object)
         */
        @Override
        public boolean equals(Object x, Object y) {
            if (x == y)
                return true;
            if (x == null || y == null)
                return false;

            Calendar calendar1 = (Calendar) x;
            Calendar calendar2 = (Calendar) y;

            return calendar1.getTimeInMillis() == calendar2.getTimeInMillis();
        }

        /*
         * (non-Javadoc)
         *
         * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
         */
        @Override
        public int hashCode(Object x) throws HibernateException {
            return new Long(((Calendar) x).getTimeInMillis()).hashCode();
        }
    }

    /**
     * Note 071107: passing the static sUTCCalendar instance to the setTimestamp(),
     * getTimestamp() calls above has concurrency issues, as some JDBC drivers do
     * modify the supplied calendar instance. More defensive code should create a
     * new Calendar instance in UTC and pass it to each getTimestamp() /
     * setTimestamp() call.
     *
     */

    /** the Calendar to hold the UTC timezone */
    public static Calendar sUTCCalendar = Calendar.getInstance();

    static {
        // set the timezone for the calendar to UTC (= GMT)
        sUTCCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
