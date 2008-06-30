package moten.david.xuml.model.viewer;

import java.awt.Color;

import model.Stately;

public class StateComponent extends ContainerComponent {

	private static final long serialVersionUID = -5653976830392378975L;

	private Stately stately;

	public StateComponent(Stately stately, Color backgroundColor) {
		super(backgroundColor, true, new String[] {
				" ",
				stately.getName() + ContainerComponent.BOLD
						+ ContainerComponent.CENTRE, "" });
		this.stately = stately;
		Movable.makeMovable(this);
	}

	public Stately getStately() {
		return stately;
	}

}
