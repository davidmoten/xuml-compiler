package moten.david.xuml.model.example.tv;

import java.io.IOException;

import moten.david.xuml.model.util.SystemBase.ValidationException;

public class TvViewer {

	public static void main(String[] args) throws ValidationException,
			NumberFormatException, IOException {
		Tv tv = new Tv();
		tv.validate();
		tv.view("src/viewer/Tv.ecore");
	}

}
