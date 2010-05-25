package moten.david.xuml.model.example.self.compiler;

import java.util.ArrayList;
import java.util.List;

import self.Event;
import self.FreeType;
import self.Pkg;
import self.PrimitiveType;

public class SubDomain {
	private List<Pkg> packages = new ArrayList<Pkg>();
	private List<Event> events = new ArrayList<Event>();
	private List<FreeType> freeTypes = new ArrayList<FreeType>();
	private List<PrimitiveType> primitiveTypes = new ArrayList<PrimitiveType>();

	public List<Pkg> getPackages() {
		return packages;
	}

	public List<Event> getEvents() {
		return events;
	}

	public List<FreeType> getFreeTypes() {
		return freeTypes;
	}

	public List<PrimitiveType> getPrimitiveTypes() {
		return primitiveTypes;
	}
}
