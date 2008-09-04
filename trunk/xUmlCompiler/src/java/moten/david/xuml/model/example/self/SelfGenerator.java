package moten.david.xuml.model.example.self;

public class SelfGenerator {

	public static void main(String[] args) throws Exception {
		Self system = new Self();
		system.generate("temp/self");
	}
}
