package moten.david.xuml.model.example.simple;

public class SimpleGenerator {
	public static void main(String[] args) throws Exception {
		Simple simple = new Simple();
		String o = "target/simple";
		simple.generate(o, o, o, o);
	}
}
