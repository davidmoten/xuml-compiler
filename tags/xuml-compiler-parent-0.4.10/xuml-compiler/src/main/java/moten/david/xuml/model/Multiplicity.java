package moten.david.xuml.model;

/**
 * Indicates the multiplicity of a relationship end. Complies with the
 * Executable UML profile.
 * 
 * @author dave
 * 
 */
public enum Multiplicity {

	ONE(true, false), ZERO_ONE(false, false), ONE_MANY(true, true), MANY(false,
			true);

	private boolean mandatory;
	private boolean multiple;

	private Multiplicity(boolean mandatory, boolean multiple) {
		this.mandatory = mandatory;
		this.multiple = multiple;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public boolean isMultiple() {
		return multiple;
	}

	public static String getMultiplicity(boolean mandatory, boolean multiple) {
		if (!mandatory && !multiple) {
			return "0..1";
		} else if (!mandatory && multiple) {
			return "*";
		} else if (mandatory && !multiple) {
			return "1";
		} else {
			return "1..*";
		}
	}
}
