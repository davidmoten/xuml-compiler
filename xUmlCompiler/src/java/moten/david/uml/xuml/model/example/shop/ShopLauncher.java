package moten.david.uml.xuml.model.example.shop;

import shop.ObjectInjector;

import com.google.inject.Guice;

public class ShopLauncher {

	public static void main(String[] args) {
		// enable injection of actions
		ObjectInjector.setInjector(Guice
				.createInjector(new ShopInjectorModule()));
	}

}
