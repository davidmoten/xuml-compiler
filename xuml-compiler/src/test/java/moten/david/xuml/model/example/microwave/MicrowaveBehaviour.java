package moten.david.xuml.model.example.microwave;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import microwave.Microwave;
import microwave.ObjectFactory;
import microwave.ObjectInjector;
import microwave.Microwave.EventButtonPressed;
import microwave.Microwave.EventDoorClosed;
import microwave.Microwave.EventDoorOpened;
import microwave.Microwave.EventPluggedIn;
import microwave.Microwave.EventTimerTimesOut;
import microwave.actions.MicrowaveActions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;

public class MicrowaveBehaviour implements MicrowaveActions {

	private static Logger log = LoggerFactory.getLogger(MicrowaveBehaviour.class);

	private Microwave microwave;

	private final Microwave.EventTimerTimesOut timer = new Microwave.EventTimerTimesOut();

	public static long timeIncrementMs = 5000;

	@Override
	public void performOnEntryCooking(EventButtonPressed event) {
		// turn on light
		microwave.turnLightOn(true);
		// energize power tube
		microwave.energizePowerTube(true);

		// start timer
		timer.setTimeMs(timeIncrementMs);
		timer.setCheckIntervalMs(1000);
		microwave.processEvent(timer);
	}

	@Override
	public void performOnEntryCookingComplete(EventTimerTimesOut event) {
		turnOff();
	}

	@Override
	public void performOnEntryCookingExtended(EventButtonPressed event) {
		// add 1 minute to timer
		timer.setTimeMs(timeIncrementMs + timer.getTimeMs());
	}

	@Override
	public void performOnEntryCookingInterrupted(EventDoorOpened event) {
		turnOff();
	}

	@Override
	public void performOnEntryDoorOpen(EventDoorOpened event) {
		// turn on light
		microwave.turnLightOn(true);
	}

	@Override
	public void performOnEntryReadyToCook(EventDoorClosed event) {
		// turn off light
		microwave.turnLightOn(false);

	}

	@Override
	public void setMicrowave(Microwave microwave) {
		this.microwave = microwave;
	}

	@Override
	public void performOnEntryReadyToCook(EventPluggedIn event) {
		// turn off light
		turnOff();
	}

	@Override
	public void energizePowerTube(boolean on) {
		log.info("power tube " + (on ? "on" : "off"));
		microwave.setPowerTubeOn(on);
	}

	@Override
	public void turnLightOn(boolean on) {
		log.info("light " + (on ? "on" : "off"));
		microwave.setLightOn(on);
	}

	private void turnOff() {
		// turn off light
		microwave.turnLightOn(false);
		// de-energize power tube
		microwave.energizePowerTube(false);
		// clear timer
		timer.setTimeMs(0);
	}

	public static void main(String[] args) throws InterruptedException {
		ObjectInjector.setInjector(Guice
				.createInjector(new MicrowaveInjectorModule()));
		final Microwave microwave = ObjectFactory.instance.createMicrowave();
		microwave.setSerialNo("A12345678");
		JFrame frame = new JFrame();
		frame.setTitle("Microwave");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new GridLayout(1, 1));
		frame.getContentPane().add(panel);
		for (Class<Object> cls : new Class[] {
				Microwave.EventButtonPressed.class,
				Microwave.EventDoorOpened.class,
				Microwave.EventDoorClosed.class, Microwave.EventPluggedIn.class }) {
			JButton button = new JButton(cls.getName().replace(
					"microwave.Microwave$Event", ""));
			panel.add(button);
			final Class<Object> c = cls;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Method method = Microwave.class.getMethod(
								"processEvent", c);
						method.invoke(microwave, c.newInstance());
					} catch (Exception e1) {
						throw new Error(e1);
					}
				}
			});
		}
		frame.setSize(200, 180);
		frame.setLocation(500, 500);
		frame.setVisible(true);
	}

}
