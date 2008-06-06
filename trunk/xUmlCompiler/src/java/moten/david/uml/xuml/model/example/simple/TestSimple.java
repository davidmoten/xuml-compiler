package moten.david.uml.xuml.model.example.simple;

import simple.ObjectInjector;

import com.google.inject.Guice;

public class TestSimple {

	public void run() {
		ObjectInjector.setInjector(Guice
				.createInjector(new SimpleInjectorModule()));
	}

	public static void main(String[] args) {

	}

}
