package xuml.tools.jaxb.compiler;

import java.util.List;

import com.google.common.collect.Lists;

public class Type {
	private final String base;
	private final List<Type> generics;
	private final boolean isArray;

	public Type(String base, List<Type> generics, boolean isArray) {
		super();
		this.base = base;
		if (generics != null)
			this.generics = generics;
		else
			this.generics = Lists.newArrayList();
		this.isArray = isArray;
	}

	public String getBase() {
		return base;
	}

	public List<Type> getGenerics() {
		return generics;
	}

	public boolean isArray() {
		return isArray;
	}
}
