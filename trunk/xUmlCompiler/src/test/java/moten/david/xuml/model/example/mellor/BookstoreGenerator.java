package moten.david.xuml.model.example.mellor;

public class BookstoreGenerator {
	public static void main(String[] args) throws Exception {
		String outputDirectoryFilename = "temp/bookstore";
		Bookstore system = new Bookstore();
		system.generate(outputDirectoryFilename);
	}
}
