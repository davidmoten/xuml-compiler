package xuml.tools.jaxb.compiler;

import java.util.Map;

import javax.persistence.EntityManagerFactory;

import akka.actor.ActorSystem;

import com.google.common.collect.Maps;

public class Signaller<T extends Entity<T, R>, R> {

	private final static ActorSystem actorSystem = ActorSystem.create();
	private final Class<T> cls;
	private final Map<R, EntityActor<T, R>> actors = Maps.newHashMap();
	private final EntityManagerFactory emf;

	public Signaller(EntityManagerFactory emf, Class<T> cls) {
		this.emf = emf;
		this.cls = cls;
	}

	/**
	 * Asynchronously signals an object (defined by the cls and id pair) with
	 * the given event. If signalling self from onEntry method use signalSelf
	 * instead. As per Mellow & Balcer 11.2.
	 * 
	 * @param cls
	 * @param id
	 * @param event
	 */
	public synchronized void signal(R id, Event<T> event) {
		if (actors.get(id) == null)
			actors.put(id, new EntityActor<T, R>(emf, cls, id));
		actors.get(id).self().tell(event);
	}

	/**
	 * Asynchronously signals self (from onEnty procedure in self). As per
	 * Mellow & Balcer 11.2.
	 * 
	 * @param self
	 * @param event
	 */
	public <T extends Entity<?, ?>> void signalSelf(Entity<T, ?> self,
			Event<T> event) {

	}

}
