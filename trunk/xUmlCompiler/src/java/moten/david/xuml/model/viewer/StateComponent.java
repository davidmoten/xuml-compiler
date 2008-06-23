package moten.david.xuml.model.viewer;

import java.awt.Color;

import model.Stately;

public class StateComponent extends Container {

	public StateComponent(Stately stately) {
		super(Color.white, true, new String[] { stately.getName()
				+ Container.BOLD + Container.CENTRE });
		Movable.makeMovable(this);
	}

}
