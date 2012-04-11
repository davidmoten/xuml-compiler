package xuml.tools.jaxb.compiler;

public class SignalToOther<T> {

	private final T t;
	private final Class<T> cls;

	public SignalToOther(Class<T> cls, T t) {
		this.cls = cls;
		this.t = t;
	}

	public T getValue() {
		return t;
	}

	public Class<T> getClazz() {
		return cls;
	}

}