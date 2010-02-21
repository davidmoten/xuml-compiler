package moten.david.xuml.model.compiler;

import java.util.ArrayList;
import java.util.List;

import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.Class;
import model.Package;
import model.System;
import moten.david.xuml.model.compiler.util.KeyMap;

import org.eclipse.emf.common.util.EList;

/**
 * Provides a KeyMap for use by templater across whole system (all classes).
 * 
 * @author dave
 * 
 */
public class SystemMap {

	private final KeyMap map = new KeyMap();

	public SystemMap(System system) {
		map.put("name", system.getName());
		map.put("description", system.getDescription());
		map.put("packages", getPackagesList(system.getPackage(), ""));
	}

	private List<KeyMap> getPackagesList(EList<Package> packages, String prefix) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (Package pkg : packages) {
			KeyMap map = new KeyMap();
			if (pkg.getClass_().size() > 0) {
				map.put("name", (prefix.length() == 0 ? "" : prefix + ".")
						+ pkg.getName());
				map.put("classes", getClassesList(pkg));
				list.add(map);
			}
			list
					.addAll(getPackagesList(pkg.getSubPackage(), (prefix
							.length() == 0 ? "" : prefix + ".")
							+ pkg.getName()));
		}
		return list;
	}

	private List<KeyMap> getClassesList(Package pkg) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (model.Class cls : pkg.getClass_()) {
			KeyMap map = new KeyMap();
			map.put("name", cls.getName());
			map.put("description", cls.getDescription());
			map.put("attributes", getAttributeList(cls.getAttribute()));
			map.put("assEnds", getAssociationEndList(cls));
			list.add(map);
		}
		return list;
	}

	private Object getAssociationEndList(Class cls) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		list
				.addAll(getAssociationEndPrimaryList(cls
						.getAssociationEndPrimary()));
		list.addAll(getAssociationEndSecondaryList(cls
				.getAssociationEndSecondary()));
		return list;
	}

	private List<KeyMap> getAssociationEndSecondaryList(
			EList<AssociationEndSecondary> associationEndsSecondary) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (AssociationEndSecondary ae : associationEndsSecondary) {
			KeyMap map = new KeyMap();
			map.put("name", ae.getName());
			map.put("description", ae.getDescription());
			map.put("associationName", ae.getAssociation().getName());
			map.put("associationDescription", ae.getAssociation()
					.getDescription());
			map.put("verbClause", ae.getVerbClause());
			map.put("mandatory", ae.isMandatory());
			map.put("multiple", ae.isMultiple());
			map.put("otherVerbClause", ae.getAssociation().getPrimary()
					.getVerbClause());
			map.put("otherMandatory", ae.getAssociation().getPrimary()
					.isMandatory());
			map.put("otherMultiple", ae.getAssociation().getPrimary()
					.isMultiple());
			map.put("other", ae.getAssociation().getPrimary().getClass_()
					.getName());
			list.add(map);
		}
		return list;
	}

	private List<KeyMap> getAssociationEndPrimaryList(
			EList<AssociationEndPrimary> associationEndsPrimary) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (AssociationEndPrimary ae : associationEndsPrimary) {
			KeyMap map = new KeyMap();
			map.put("name", ae.getName());
			map.put("description", ae.getDescription());
			map.put("associationName", ae.getAssociation().getName());
			map.put("associationDescription", ae.getAssociation()
					.getDescription());
			map.put("verbClause", ae.getVerbClause());
			map.put("mandatory", ae.isMandatory());
			map.put("multiple", ae.isMultiple());
			map.put("otherVerbClause", ae.getAssociation().getSecondary()
					.getVerbClause());
			map.put("otherMandatory", ae.getAssociation().getSecondary()
					.isMandatory());
			map.put("otherMultiple", ae.getAssociation().getSecondary()
					.isMultiple());
			map.put("other", ae.getAssociation().getSecondary().getClass_()
					.getName());
			list.add(map);
		}
		return list;
	}

	private List<KeyMap> getAttributeList(EList<Attribute> attributes) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (Attribute attribute : attributes) {
			KeyMap map = new KeyMap();
			map.put("name", attribute.getName());
			map.put("description", attribute.getDescription());
			map.put("type", attribute.getType().getPrimitive().toString());
			list.add(map);
		}
		return list;
	}

	public KeyMap getMap() {
		return map;
	}

}
