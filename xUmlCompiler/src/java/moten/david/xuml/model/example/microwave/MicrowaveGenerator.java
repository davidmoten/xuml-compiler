package moten.david.xuml.model.example.microwave;


public class MicrowaveGenerator {
	public static void main(String[] args) throws Exception {
		String outputDirectoryFilename = "temp/microwave";
		if (args.length > 0)
			outputDirectoryFilename = args[0];
		Microwave system = new Microwave();
		system.generate(outputDirectoryFilename);
	}
}
