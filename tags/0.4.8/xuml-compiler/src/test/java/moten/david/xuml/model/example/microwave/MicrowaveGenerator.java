package moten.david.xuml.model.example.microwave;

public class MicrowaveGenerator {
	public static void main(String[] args) throws Exception {
		String o = "temp/microwave";
		if (args.length > 0)
			o = args[0];
		Microwave system = new Microwave();
		system.generate(o, o, o, o);
	}
}
