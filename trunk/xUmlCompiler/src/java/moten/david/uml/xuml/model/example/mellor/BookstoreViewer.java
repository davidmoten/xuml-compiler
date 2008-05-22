package moten.david.uml.xuml.model.example.mellor;

import java.io.IOException;

public class BookstoreViewer {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Bookstore bookstore = new Bookstore();
		bookstore.view("src/viewer/Bookstore.ini");
	}
}
