package xuml.tools.jaxb.compiler;

public class Member {
	private final String name;
	private final Type type;
	private final boolean addSetter;
	private final boolean addGetter;
	private final String comment;

	public Member(String name, Type type, boolean addSetter, boolean addGetter,
			String comment) {
		super();
		this.name = name;
		this.type = type;
		this.addSetter = addSetter;
		this.addGetter = addGetter;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public boolean isAddSetter() {
		return addSetter;
	}

	public boolean isAddGetter() {
		return addGetter;
	}

	public String getComment() {
		return comment;
	}
}