package moten.david.xuml.model.example.mellor;

import moten.david.xuml.model.viewer.ViewerUtil;

public class BookstoreViewer {
	public static void main(String[] args) throws Exception {
		ViewerUtil.view("src/viewer", Bookstore.class);
	}
}
