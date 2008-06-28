package moten.david.xuml.model.viewer.state;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import model.State;
import moten.david.xuml.model.viewer.ContainerComponent;
import moten.david.xuml.model.viewer.Movable;

public class StateComponent extends ContainerComponent {

	private static final long serialVersionUID = -1185107452366560789L;
	private final State state;

	public StateComponent(State state) {
		super(Color.white, true, getLines(state).toArray(new String[] {}));
		Movable.makeMovable(this);
		setDoubleBuffered(false);
		this.state = state;
	}

	public static List<String> getLines(model.State state) {
		List<String> lines = new ArrayList<String>();
		lines.add(state.getName() + "<centre/>");
		return lines;
	}

}
