package ${package};

import com.google.inject.Injector;
import com.google.inject.Guice;
import com.google.inject.Module;
import org.apache.log4j.Logger;

public class ObjectInjector{

	/**
	* static logger
	**/
	private static Logger log = Logger.getLogger(ObjectInjector.class);

	/*
	* singleton injector
	*/
	private static Injector injector;

	/**
	* returns a singleton Injector
	*/
	public static synchronized Injector getInjector() {
		return injector;
	}
	
	/**
	* sets the singleton Injector
	*/
	public static synchronized void setInjector(Injector pInjector) {
		injector = pInjector;
	}
	
	/*
	* uses the singleton injector to inject all bound members
	* bindings are defined in an InjectorModule.
	*/
	public static void injectMembers(Object o) {
		try {
			if (injector!=null) 
				injector.injectMembers(o);
		}
		catch (Exception e){
			log.info(e.getMessage());
		}
	}
	
}