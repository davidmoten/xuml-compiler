package xuml.tools.jaxb.compiler;

import akka.actor.ActorSystem;
import akka.actor.Actors;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedPriorityMailbox;

import com.typesafe.config.Config;

public class EntityMailbox extends UnboundedPriorityMailbox {
	public EntityMailbox(ActorSystem.Settings settings, Config config) { // needed
																			// for
																			// reflective
																			// instantiation
		// Create a new PriorityGenerator, lower prio means more important
		super(new PriorityGenerator() {
			@Override
			public int gen(Object message) {
				if (message.equals("highpriority"))
					return 0; // 'highpriority messages should be treated first
								// if possible
				else if (message.equals("lowpriority"))
					return 2; // 'lowpriority messages should be treated last if
								// possible
				else if (message.equals(Actors.poisonPill()))
					return 3; // PoisonPill when no other left
				else
					return 1; // By default they go between high and low prio
			}
		});
	}
}