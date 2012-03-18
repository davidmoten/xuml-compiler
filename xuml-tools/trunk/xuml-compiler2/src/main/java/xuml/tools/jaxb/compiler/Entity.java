package xuml.tools.jaxb.compiler;

public interface Entity<T, R> {
	R getId();

	void event(Event<T> event);
}
