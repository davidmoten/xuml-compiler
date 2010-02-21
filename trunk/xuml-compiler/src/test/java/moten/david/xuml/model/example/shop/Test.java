package moten.david.xuml.model.example.shop;

import javax.persistence.EntityManagerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

	private static Injector injector = Guice
			.createInjector(new ShopInjectorModule());
	private EntityManagerFactory emf;

	@org.junit.Before
	public void prepare() {
		this.emf = injector.getInstance(EntityManagerFactory.class);
	}

	@org.junit.Test
	public void test() {

	}

}
