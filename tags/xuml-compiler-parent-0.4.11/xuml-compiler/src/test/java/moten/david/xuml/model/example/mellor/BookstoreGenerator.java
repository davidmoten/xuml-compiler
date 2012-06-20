package moten.david.xuml.model.example.mellor;

public class BookstoreGenerator {
	public static void main(String[] args) throws Exception {
		String o = "temp/bookstore";
		Bookstore system = new Bookstore();
		system.generate(o, o, o, o);
	}
}
