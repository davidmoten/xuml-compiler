package moten.david.xuml.model.example.specialize;

public class SpecializeGenerator {
	public static void main(String[] args) throws Exception {
		Specialize simple = new Specialize();
		String o = "target/specialize";
		simple.generate(o, o, o, o);
	}
}
