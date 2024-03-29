package moten.david.xuml.model.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ActionLanguage;
import model.Association;
import model.AssociationEnd;
import model.AssociationEndPersistence;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributeReferential;
import model.CallEvent;
import model.Class;
import model.ClassPersistence;
import model.Event;
import model.IdentifierNonPrimary;
import model.IdentifierPrimary;
import model.Index;
import model.ModelFactory;
import model.Named;
import model.Operation;
import model.OperationSignature;
import model.Parameter;
import model.SignalEvent;
import model.Specialization;
import model.SpecializationGroup;
import model.TimerEvent;
import model.Transition;
import moten.david.xuml.model.compiler.util.ImportContext;
import moten.david.xuml.model.compiler.util.ImportContextImpl;
import moten.david.xuml.model.compiler.util.KeyMap;
import moten.david.xuml.model.compiler.util.StringUtil;
import moten.david.xuml.model.compiler.util.Util;
import moten.david.xuml.model.util.ModelUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.emf.common.util.EList;

/**
 * Provides a KeyMap which is consumed by a templater (e.g. freemarker) to
 * generate .java class files.
 * 
 * @author dave
 * 
 */
public class ClassMap {

	private static Logger log = LoggerFactory.getLogger(ClassMap.class);

	private final Map<Object, Object> cache = new HashMap<Object, Object>();
	private final model.Class cls;
	private final ClassRegister register = new ClassRegister();
	private KeyMap map;

	public ClassMap(model.Class cls) {
		this.cls = cls;
	}

	public KeyMap getMap() {
		this.map = new KeyMap();

		ImportContext interfaceImportContext = new ImportContextImpl(
				Util.getFullPath(cls.getPackage(), "."));
		ImportContext classImportContext = new ImportContextImpl(
				Util.getFullPath(cls.getPackage(), ".") + ".impl");
		ImportContext actionsImportContext = new ImportContextImpl(
				Util.getFullPath(cls.getPackage(), ".actions"));
		map.put("interface", interfaceImportContext);
		map.put("class", classImportContext);
		map.put("actions", actionsImportContext);
		map.put("imports", new ArrayList<KeyMap>());
		map.putAll(getNamedMap(cls));
		map.putAll(getPackageMap(cls.getPackage()));
		map.putAll(getGeneralisationsMap(cls));
		map.putAll(getPersistenceMap(cls.getPersistence()));
		map.put("operations", getOperationsList(cls.getOperation()));
		map.put("attributes", getAttributesList(cls));
		map.put("associations", getAssociationsList(cls));
		map.put("states", getStatesList(cls));
		map.putAll(getEventsMap(cls));
		map.put("identifiers",
				getIdentifiersNonPrimaryList(cls.getIdentifierNonPrimary()));
		map.put("identifierPrimary", getIdentifierPrimary(cls));

		String cascade = System.getProperty("xuml.compiler.cascade");
		if (cascade == null)
			cascade = "CascadeType.ALL";
		map.put("cascade", cascade);
		return this.map;
	}

	private KeyMap getIdentifierPrimary(Class cls) {
		KeyMap map = new KeyMap();
		IdentifierPrimary id = cls.getIdentifierPrimary();
		if (id == null)
			return null;
		map.put("name", id.getName());
		map.put("description", id.getDescription());
		map.put("attributes",
				getAttributesList(id.getAttribute(),
						id.getAttributeReferential()));
		return map;
	}

	private KeyMap getEventsMap(model.Class cls) {
		KeyMap map = new KeyMap();
		if (cls.getStateMachine() == null)
			return map;
		map.put("initialState", cls.getStateMachine().getInitialState()
				.getName());
		List<KeyMap> list = new ArrayList<KeyMap>();
		map.put("events", list);
		for (Event event : cls.getStateMachine().getEvent()) {
			KeyMap map2 = new KeyMap();
			map2.put("name", event.getName());
			map2.put("transitions", getTransitionsMap(event.getTransition()));
			map2.put("type", getType(event));
			map2.put("parameters", getParametersList(event));
			map2.put("toStates", getToStatesMap(event));
			list.add(map2);
		}
		return map;
	}

	private List<KeyMap> getToStatesMap(Event event) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		Set<KeyMap> maps = new HashSet<KeyMap>();
		for (Transition transition : event.getTransition()) {
			KeyMap map = new KeyMap();
			map.put("name", transition.getToState().getName());
			map.put("description", transition.getToState().getDescription());
			maps.add(map);
		}
		list.addAll(maps);
		return list;
	}

	private List<KeyMap> getParametersList(Event event) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (Parameter p : event.getParameter()) {
			KeyMap map = new KeyMap();
			map.put("name", p.getName());
			map.put("description", p.getDescription());
			map.put("type", registerClass(ModelUtil.getTypeName(p.getType())));
			list.add(map);
		}
		return list;
	}

	private String getType(Event event) {
		if (event instanceof SignalEvent)
			return "signal";
		else if (event instanceof CallEvent)
			return "call";
		else if (event instanceof TimerEvent)
			return "timer";
		else
			throw new Error("this event type not implemented yet");
	}

	private List<KeyMap> getTransitionsMap(EList<Transition> transitions) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (Transition t : transitions) {
			KeyMap map2 = new KeyMap();
			map2.put("name", t.getName());
			map2.put("description", t.getDescription());
			map2.put("fromState", t.getFromState().getName());
			map2.put("toState", t.getToState().getName());
			list.add(map2);
		}
		return list;
	}

	private List<KeyMap> getStatesList(model.Class cls) {
		if (cls.getStateMachine() == null)
			return null;
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (model.State state : cls.getStateMachine().getState()) {
			KeyMap map = new KeyMap();
			map.put("name", state.getName());
			list.add(map);
		}
		if (cls.getStateMachine().getFinalState() != null) {
			KeyMap map = new KeyMap();
			map.put("name", cls.getStateMachine().getFinalState().getName());
			list.add(map);
		}
		return list;
	}

	private List<KeyMap> getIdentifiersNonPrimaryList(
			EList<IdentifierNonPrimary> identifierNonPrimary) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (IdentifierNonPrimary identifier : identifierNonPrimary)
			list.add(getIdentifierNonPrimaryMap(identifier));
		return list;
	}

	private KeyMap getIdentifierNonPrimaryMap(IdentifierNonPrimary identifier) {
		KeyMap map = new KeyMap();
		map.putAll(getNamedMap(identifier));
		map.put("attributes",
				getAttributesList(identifier.getAttribute(),
						identifier.getAttributeReferential()));
		return map;
	}

	private List<KeyMap> getAttributesList(EList<Attribute> attributes,
			EList<AttributeReferential> derivedAttributes) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (Attribute a : attributes)
			list.add(getAttributeMap(a));
		for (AttributeReferential a : derivedAttributes)
			list.add(getAttributeReferentialMap(a));
		return list;
	}

	private KeyMap getAttributeReferentialMap(AttributeReferential attribute) {
		KeyMap map = new KeyMap();
		map.put("name", attribute.getAssociationEnd().getRole());
		map.put("type", registerClass(ModelUtil
				.getCanonicalName(getClass(attribute.getAssociationEnd()))));
		String idProperty = getIdProperty(getClass(attribute
				.getAssociationEnd()));
		map.put("derived", true);
		map.put("idProperty", idProperty);
		return map;
	}

	private String getIdProperty(Class cls) {
		for (Attribute a : cls.getAttribute())
			if (cls.getIdentifierPrimary().getAttribute().contains(a))
				return a.getName();
		return null;
	}

	private Class getClass(AssociationEnd ae) {
		Class cls;
		if (ae instanceof AssociationEndPrimary)
			cls = ((AssociationEndPrimary) ae).getClass_();
		else
			cls = ((AssociationEndSecondary) ae).getClass_();
		return cls;
	}

	private KeyMap getNamedMap(Named named) {
		KeyMap map = new KeyMap();
		map.put("name", named.getName());
		map.put("description", named.getDescription());
		return map;
	}

	private KeyMap getPackageMap(model.Package p) {
		if (cache.get(p) != null)
			return (KeyMap) cache.get(p);
		String pkg = Util.getFullPath(p, ".");
		KeyMap map = new KeyMap();
		map.put("package", pkg);
		map.put("packageLast", p.getName());
		cache.put(p, map);
		return map;
	}

	private KeyMap getGeneralisationsMap(model.Class cls) {

		KeyMap map = new KeyMap();
		map.put("isGeneralization", cls.getSpecializationGroup().size() > 0);
		{
			List<KeyMap> list = new ArrayList<KeyMap>();
			map.put("specializationGroups", list);
			for (SpecializationGroup group : cls.getSpecializationGroup()) {
				KeyMap map2 = new KeyMap();
				map2.put("name", group.getName());
				List<KeyMap> list2 = new ArrayList<KeyMap>();
				map2.put("specializations", list2);
				for (Specialization sp : group.getSpecialization()) {
					KeyMap map3 = new KeyMap();
					map3.put("class", sp.getName());
					list2.add(map3);
				}
				list.add(map2);
			}
		}
		if (cls instanceof Specialization) {
			Specialization sp = (Specialization) cls;
			List<KeyMap> list = new ArrayList<KeyMap>();
			map.put("generalizations", list);
			for (SpecializationGroup group : sp.getGroup()) {
				KeyMap map2 = new KeyMap();
				map2.put("name", group.getName());
				map2.put("class", group.getGeneralization().getName());
				list.add(map2);
			}
		}
		cache.put(cls, map);
		return map;
	}

	private boolean includeAssociation(Association a) {
		return a.getAssociationClass() == null;
	}

	private List<KeyMap> getAssociationsList(model.Class cls) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (AssociationEndPrimary ae : cls.getAssociationEndPrimary())
			if (includeAssociation(ae.getAssociation()))
				list.add(getAssociationEndsMap(ae.getAssociation(), "this",
						"other"));
		for (AssociationEndSecondary ae : cls.getAssociationEndSecondary())
			if (includeAssociation(ae.getAssociation()))
				list.add(getAssociationEndsMap(ae.getAssociation(), "other",
						"this"));
		// handle generalization
		for (SpecializationGroup group : cls.getSpecializationGroup())
			for (Specialization sp : group.getSpecialization()) {
				Association a = ModelFactory.eINSTANCE.createAssociation();
				a.setName(group.getName() + " generalization of "
						+ sp.getName());
				a.setDescription("generalization-specialization relationship to "
						+ sp.getName());
				AssociationEndPrimary ae1 = ModelFactory.eINSTANCE
						.createAssociationEndPrimary();
				ae1.setClass(cls);
				ae1.setMandatory(true);
				ae1.setMultiple(false);
				ae1.setRole(cls.getName());
				ae1.setVerbClause("is generalized by");
				ae1.setDescription("generated by generalization instance");
				ae1.setAssociation(a);

				AssociationEndSecondary ae2 = ModelFactory.eINSTANCE
						.createAssociationEndSecondary();
				ae2.setClass(sp);
				ae2.setMandatory(false);
				ae2.setMultiple(false);
				ae2.setRole(sp.getName());
				ae2.setVerbClause("is specialized by");
				ae2.setDescription("generated by generalization instance");
				ae2.setAssociation(a);
				list.add(getAssociationEndsMap(a, "this", "other"));
			}
		return list;
	}

	private KeyMap getAssociationEndsMap(Association ass, String primaryEndKey,
			String secondaryEndKey) {
		KeyMap map = new KeyMap();
		map.put("name", ass.getName());
		map.put(secondaryEndKey,
				getAssociationEndMap(ass.getSecondary(), ass.getSecondary()
						.getClass_(), ass.getSecondary().getAssociation(),
						false));
		map.put(primaryEndKey,
				getAssociationEndMap(ass.getPrimary(), ass.getPrimary()
						.getClass_(), ass.getPrimary().getAssociation(), true));
		if (ass.getAssociationClass() != null) {
			map.put("associationClass", ass.getAssociationClass().getName());
			if (ass.getAssociationClass().getPersistence() != null) {
				map.put("associationClassSchema", ass.getAssociationClass()
						.getPersistence().getSchema());
				map.put("associationClassTable", ass.getAssociationClass()
						.getPersistence().getTable());
				if (ass.getName().equals("R9")
						&& ass.getAssociationClass().getPersistence()
								.getTable() == null)
					throw new Error("null!");
			}
		}
		return map;
	}

	private KeyMap getAssociationEndMap(AssociationEnd assEnd, model.Class cls,
			Association ass, boolean isPrimary) {
		KeyMap map = new KeyMap();
		map.put("role", assEnd.getRole());
		String rolePlural = assEnd.getRolePlural();
		if (rolePlural == null)
			rolePlural = pluralise(assEnd.getRole());
		map.put("rolePlural", rolePlural);
		map.put("verbClause", assEnd.getVerbClause());
		map.put("mandatory", assEnd.isMandatory());
		map.put("multiple", assEnd.isMultiple());
		map.put("name", ass.getName());
		map.put("class", registerClass(getFullyQualified(cls)));
		map.put("classImpl", registerClass(getFullyQualified(cls.getPackage())
				+ ".impl." + cls.getName() + "Impl"));
		map.put("primary", isPrimary);
		map.put("type", registerClass(ModelUtil.getCanonicalName(cls)));
		map.put("orderBy", null);
		map.put("persistence",
				getAssociationEndPersistenceMap(assEnd.getPersistence()));
		return map;
	}

	private KeyMap getAssociationEndPersistenceMap(AssociationEndPersistence p) {
		if (p == null)
			return null;
		KeyMap map = new KeyMap();
		List<KeyMap> list = new ArrayList<KeyMap>();
		map.put("orderBy", list);
		for (Attribute a : p.getOrderBy()) {
			KeyMap map2 = new KeyMap();
			list.add(map2);
			map2.put("name", a.getName());
		}
		return map;
	}

	private boolean endsWith(String s, String... suffixes) {
		for (String suffix : suffixes)
			if (s.toUpperCase().endsWith(suffix.toUpperCase()))
				return true;
		return false;
	}

	private String pluralise(String s) {
		if (s == null)
			return null;
		if (endsWith(s, "ss", "ch", "sh", "x"))
			return s + "es";
		else if (endsWith(s, "ay", "ey", "iy", "oy", "uy"))
			return s + "s";
		else if (endsWith(s, "y"))
			return s.substring(0, s.length() - 1) + "ies";
		else if (endsWith(s, "ft"))
			return s;
		else
			return s + "s";
	}

	private String getFullyQualified(model.Package pkg) {
		if (pkg == null)
			return "";
		else if (pkg.getParent() == null)
			return pkg.getName();
		else
			return getFullyQualified(pkg.getParent()) + "." + pkg.getName();
	}

	private String getFullyQualified(model.Class cls) {
		return getFullyQualified(cls.getPackage()) + "." + cls.getName();
	}

	private List<KeyMap> getAttributesList(model.Class cls) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (Attribute a : cls.getAttribute())
			list.add(getAttributeMap(a));

		Set<String> derivedAttributeNames = new HashSet<String>();
		for (IdentifierNonPrimary identifier : cls.getIdentifierNonPrimary())
			for (AttributeReferential da : identifier.getAttributeReferential())
				derivedAttributeNames.add(da.getAssociationEnd().getRole());
		for (String name : derivedAttributeNames) {
			KeyMap map = new KeyMap();
			map.put("name", name);
			map.put("derived", true);
			list.add(map);
		}
		return list;
	}

	private List<KeyMap> getOperationsList(EList<Operation> operations) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (OperationSignature o : operations)
			list.add(getOperationSignatureMap(o));
		return list;
	}

	private KeyMap getPersistenceMap(ClassPersistence persistence) {
		KeyMap map = new KeyMap();
		if (persistence != null) {
			KeyMap map2 = new KeyMap();
			map.put("persistence", map2);
			map2.put("table", persistence.getTable());
			map2.put("schema", persistence.getSchema());
			map2.put("indexes", getIndexesList(persistence.getIndex()));
		}
		return map;
	}

	private List<KeyMap> getIndexesList(EList<Index> indexes) {
		if (indexes.size() == 0)
			return null;
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (Index index : indexes)
			list.add(getIndexMap(index));
		return list;
	}

	private KeyMap getIndexMap(Index index) {
		KeyMap map = new KeyMap();
		map.put("name", index.getName());
		map.put("description", index.getDescription());
		List<KeyMap> list = new ArrayList<KeyMap>();
		map.put("attributes", list);
		for (Attribute attribute : index.getAttribute()) {
			KeyMap map2 = new KeyMap();
			map2.put("name", attribute.getName());
			map2.put("type",
					registerClass(ModelUtil.getJavaType(attribute.getType())));
			map2.put("derived", false);
			list.add(map2);
		}
		return map;
	}

	private KeyMap getAttributeMap(Attribute attribute) {
		KeyMap map = new KeyMap();
		map.put("name", attribute.getName());
		map.put("type",
				registerClass(ModelUtil.getJavaType(attribute.getType())));
		map.put("scale", attribute.getType().getScale());
		map.put("precision", attribute.getType().getPrecision());
		map.put("utc", attribute.getType().isUtc());
		map.put("primitive", attribute.getType().getPrimitive().getName());
		map.put("yesNo", attribute.getType().isYesNo());
		map.put("description", attribute.getDescription());
		map.put("unique", attribute.isUnique());
		map.put("nullable", !attribute.isMandatory());
		map.put("values", getValuesMap(attribute.getValues()));
		map.put("derived", false);
		if (attribute.getPersistence() != null) {
			KeyMap map2 = new KeyMap();
			map.put("persistence", map2);
			map2.put("id", attribute.getIdentifierPrimary() != null);
			map2.put("composite",
					attribute.getIdentifierPrimary() != null
							&& attribute.getIdentifierPrimary().getAttribute()
									.size() > 1);
			map2.put("column", attribute.getPersistence().getColumn());
			map2.put("generatedBySequence", attribute.getPersistence()
					.isGeneratedBySequence());
			map2.put("generatedValue", attribute.getPersistence()
					.isGeneratedValue());
			map2.put("generatedByIdentity", attribute.getPersistence()
					.isGeneratedByIdentity());
		}
		return map;
	}

	private List<KeyMap> getValuesMap(EList<String> values) {
		List<KeyMap> list = new ArrayList<KeyMap>();
		for (String value : values) {
			KeyMap map = new KeyMap();
			map.put("value", value);
			map.put("valueIdentifier", StringUtil.getJavaIdentifier(value));
			list.add(map);
		}
		return list;
	}

	private KeyMap getOperationSignatureMap(OperationSignature o) {
		KeyMap map = new KeyMap();
		log.info("operation " + o.getName());
		map.put("name", o.getName());
		map.put("description", o.getDescription());
		if (o.getReturns() != null)
			map.put("returns",
					registerClass(ModelUtil.getTypeName(o.getReturns())));
		map.put("returnsMultiple", o.isReturnsMultiple());
		List<KeyMap> list = new ArrayList<KeyMap>();
		map.put("parameters", list);
		for (Parameter parameter : o.getParameter()) {
			KeyMap map2 = new KeyMap();
			map2.put("name", parameter.getName());
			map2.put("type",
					registerClass(ModelUtil.getTypeName(parameter.getType())));
			map2.put("multiple", parameter.isMultiple());
			map2.put("description", parameter.getDescription());
			if (o instanceof Operation) {
				ActionLanguage action = ((Operation) o).getAction();
				if (action != null)
					map.put("code", action.getAction());
			}
			list.add(map2);
		}
		return map;
	}

	private String registerClass(String className) {
		return registerClass(map, className);
	}

	public String registerClass(KeyMap map, String className) {

		String abbreviation = register.registerClass(className);
		if (abbreviation.equals(className))
			return className;
		KeyMap map2 = new KeyMap();
		map2.put("name", className);
		map2.put("abbreviatedName", abbreviation);
		List<KeyMap> list = (List<KeyMap>) map.get("imports");
		if (!list.contains(map2))
			list.add(map2);
		return abbreviation;
	}
}
