package xuml.tools.jaxb.compiler;

import java.util.HashSet;
import java.util.Set;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Signaller {

	private static final ActorSystem actorSystem = ActorSystem.create();
	private static Set<String> actorPaths = new HashSet<String>();

	/**
	 * Asynchronously signals an object (defined by the cls and id pair) with
	 * the given event. If signalling self from onEntry method use signalSelf
	 * instead. As per Mellow & Balcer 11.2.
	 * 
	 * @param cls
	 * @param id
	 * @param event
	 */
	public <T extends Entity<?>> void signal(
			Class<? extends ReceivesSignal<T>> cls, Object id, Event<T> event) {

		String path = "akka://xuml-compiler/" + cls.getName() + "/" + id;
		actorSystem.actorOf(null, path);
		ActorRef ref = actorSystem.actorFor(path);
		ref.tell(event);
	}

	/**
	 * Asynchronously signals self (from onEnty procedure in self). As per
	 * Mellow & Balcer 11.2.
	 * 
	 * @param self
	 * @param event
	 */
	public <T extends Entity<?>> void signalSelf(ReceivesSignal<T> self,
			Event<T> event) {

	}

}
