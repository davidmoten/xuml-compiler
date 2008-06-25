package moten.david.xuml.model.viewer;

import java.awt.Color;

import model.Stately;

public class StateComponent extends Container {

	private Stately stately;

	public StateComponent(Stately stately) {
		super(Color.white, true, new String[] { stately.getName()
				+ Container.BOLD + Container.CENTRE });
		this.stately = stately;
		Movable.makeMovable(this);
	}

	public Stately getStately() {
		return stately;
	}

}
