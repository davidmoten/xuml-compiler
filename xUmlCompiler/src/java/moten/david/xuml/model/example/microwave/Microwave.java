package moten.david.xuml.model.example.microwave;

import model.Class;
import model.Event;
import model.Primitive;
import model.State;
import moten.david.xuml.model.Generator;
import moten.david.xuml.model.util.SystemBase;

public class Microwave extends SystemBase {

	public Microwave() {
		super("microwave", "Microwave");
		initialize();
	}

	public void initialize() {
		model.Package pkg = createRootPackage("microwave", "a microwave oven");
		Class m = createClass(pkg, "Microwave", "a microwave oven");
		createPrimaryKey(createAttribute(m, "serialNo"),
				Generator.NOT_GENERATED);
		createAttribute(m, "lightOn", Primitive.BOOLEAN);
		createAttribute(m, "powerTubeOn", Primitive.BOOLEAN);
		createOperation(m, "turnLightOn", "turns the light on/off", null,
				false, createParameter("on", "light is on", "boolean"));
		createOperation(m, "energizePowerTube",
				"energizes/deenergizes the power tube", null, false,
				createParameter("energize", "energize the power tube",
						"boolean"));
		State readyToCook = createState(m, "ReadyToCook");
		State doorOpen = createState(m, "DoorOpen");
		State cooking = createState(m, "Cooking");
		State cookingInterrupted = createState(m, "CookingInterrupted");
		State cookingComplete = createState(m, "CookingComplete");
		State cookingExtended = createState(m, "CookingExtended");
		Event buttonPressed = createSignalEvent(m, "buttonPressed");
		Event doorOpened = createSignalEvent(m, "doorOpened");
		Event doorClosed = createSignalEvent(m, "doorClosed");
		Event timerTimesOut = createTimerEvent(m, "timerTimesOut");
		Event pluggedIn = createCallEvent(m, "pluggedIn");
		createTransition(m.getStateMachine().getInitialState(), readyToCook,
				pluggedIn);
		createTransition(readyToCook, cooking, buttonPressed);
		createTransition(readyToCook, doorOpen, doorOpened);
		createTransition(doorOpen, readyToCook, doorClosed);
		createTransition(cooking, cookingInterrupted, doorOpened);
		createTransition(cooking, cookingExtended, buttonPressed);
		createTransition(cooking, cookingComplete, timerTimesOut);
		createTransition(cookingInterrupted, readyToCook, doorClosed);
		createTransition(cookingComplete, cooking, buttonPressed);
		createTransition(cookingComplete, doorOpen, doorOpened);
		createTransition(cookingExtended, cookingExtended, buttonPressed);
		createTransition(cookingExtended, cookingComplete, timerTimesOut);
		createTransition(cookingExtended, cookingInterrupted, doorOpened);
	}

	public static void main(String[] args) throws Exception {
		String outputDirectoryFilename = "temp/microwave";
		if (args.length > 0)
			outputDirectoryFilename = args[0];
		Microwave system = new Microwave();
		system.view("src/viewer/Microwave.ecore");
		// system.generate(outputDirectoryFilename);
	}

}
