package xuml.tools.jaxb.compiler;

public interface Entity<T, R> {
	R getId();

	/**
	 * All events go through here.
	 * 
	 * @param event
	 */
	void event(Event<T> event);
}
