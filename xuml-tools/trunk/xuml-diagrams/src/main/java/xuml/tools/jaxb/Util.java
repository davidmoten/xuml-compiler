package xuml.tools.jaxb;

import xuml.metamodel.jaxb.Multiplicity;

public class Util {
	public static String getAbbreviation(Multiplicity m) {
		if (Multiplicity.MANY.equals(m))
			return "*";
		else if (Multiplicity.ONE.equals(m))
			return "1";
		else if (Multiplicity.ZERO_ONE.equals(m))
			return "0..1";
		else if (Multiplicity.ONE_MANY.equals(m))
			return "1..*";
		else if (Multiplicity.ONE.equals(m))
			return "1";
		else
			throw new RuntimeException("unexpected");
	}
}
