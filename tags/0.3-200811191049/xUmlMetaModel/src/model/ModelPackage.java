/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://davidmoten.homeip.net/uml/executable/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.Named <em>Named</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Named
	 * @see model.impl.ModelPackageImpl#getNamed()
	 * @generated
	 */
	int NAMED = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Named</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link model.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.SystemImpl
	 * @see model.impl.ModelPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PACKAGE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ASSOCIATION = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CONSTRAINT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Collaborator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__COLLABORATOR = NAMED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Communication</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__COMMUNICATION = NAMED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DOMAIN = NAMED_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Bridge</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BRIDGE = NAMED_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__USE_CASE = NAMED_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Actor Use Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ACTOR_USE_CASE = NAMED_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Unit Test</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__UNIT_TEST = NAMED_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__EVENT = NAMED_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Free Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__FREE_TYPE = NAMED_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PRIMITIVE_TYPE = NAMED_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = NAMED_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link model.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.PackageImpl
	 * @see model.impl.ModelPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Class</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__CLASS = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__SUB_PACKAGE = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__PARENT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__DATA_TYPE = NAMED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link model.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ClassImpl
	 * @see model.impl.ModelPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__PACKAGE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTE = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attribute Referential</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTE_REFERENTIAL = NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OPERATION = NAMED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONSTRAINTS = NAMED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__STATE_MACHINE = NAMED_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Identifier Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IDENTIFIER_PRIMARY = NAMED_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Identifier Non Primary</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IDENTIFIER_NON_PRIMARY = NAMED_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Association End Primary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ASSOCIATION_END_PRIMARY = NAMED_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Association End Secondary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ASSOCIATION_END_SECONDARY = NAMED_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__PERSISTENCE = NAMED_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Specialization Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SPECIALIZATION_GROUP = NAMED_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link model.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AssociationImpl
	 * @see model.impl.ModelPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__PRIMARY = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Secondary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SECONDARY = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ASSOCIATION_CLASS = NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = NAMED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.impl.AssociationEndImpl <em>Association End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AssociationEndImpl
	 * @see model.impl.ModelPackageImpl#getAssociationEnd()
	 * @generated
	 */
	int ASSOCIATION_END = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__MANDATORY = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__MULTIPLE = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Verb Clause</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__VERB_CLAUSE = NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__ROLE = NAMED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Role Plural</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__ROLE_PLURAL = NAMED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Derived Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__DERIVED_ATTRIBUTE = NAMED_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END__PERSISTENCE = NAMED_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Association End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_FEATURE_COUNT = NAMED_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link model.impl.AssociationEndPrimaryImpl <em>Association End Primary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AssociationEndPrimaryImpl
	 * @see model.impl.ModelPackageImpl#getAssociationEndPrimary()
	 * @generated
	 */
	int ASSOCIATION_END_PRIMARY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__NAME = ASSOCIATION_END__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__DESCRIPTION = ASSOCIATION_END__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__MANDATORY = ASSOCIATION_END__MANDATORY;

	/**
	 * The feature id for the '<em><b>Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__MULTIPLE = ASSOCIATION_END__MULTIPLE;

	/**
	 * The feature id for the '<em><b>Verb Clause</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__VERB_CLAUSE = ASSOCIATION_END__VERB_CLAUSE;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__ROLE = ASSOCIATION_END__ROLE;

	/**
	 * The feature id for the '<em><b>Role Plural</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__ROLE_PLURAL = ASSOCIATION_END__ROLE_PLURAL;

	/**
	 * The feature id for the '<em><b>Derived Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__DERIVED_ATTRIBUTE = ASSOCIATION_END__DERIVED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__PERSISTENCE = ASSOCIATION_END__PERSISTENCE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__CLASS = ASSOCIATION_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Association</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY__ASSOCIATION = ASSOCIATION_END_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association End Primary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PRIMARY_FEATURE_COUNT = ASSOCIATION_END_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.impl.AssociationEndSecondaryImpl <em>Association End Secondary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AssociationEndSecondaryImpl
	 * @see model.impl.ModelPackageImpl#getAssociationEndSecondary()
	 * @generated
	 */
	int ASSOCIATION_END_SECONDARY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__NAME = ASSOCIATION_END__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__DESCRIPTION = ASSOCIATION_END__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__MANDATORY = ASSOCIATION_END__MANDATORY;

	/**
	 * The feature id for the '<em><b>Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__MULTIPLE = ASSOCIATION_END__MULTIPLE;

	/**
	 * The feature id for the '<em><b>Verb Clause</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__VERB_CLAUSE = ASSOCIATION_END__VERB_CLAUSE;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__ROLE = ASSOCIATION_END__ROLE;

	/**
	 * The feature id for the '<em><b>Role Plural</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__ROLE_PLURAL = ASSOCIATION_END__ROLE_PLURAL;

	/**
	 * The feature id for the '<em><b>Derived Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__DERIVED_ATTRIBUTE = ASSOCIATION_END__DERIVED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__PERSISTENCE = ASSOCIATION_END__PERSISTENCE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__CLASS = ASSOCIATION_END_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Association</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY__ASSOCIATION = ASSOCIATION_END_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association End Secondary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_SECONDARY_FEATURE_COUNT = ASSOCIATION_END_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.impl.AssociationClassImpl <em>Association Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AssociationClassImpl
	 * @see model.impl.ModelPackageImpl#getAssociationClass()
	 * @generated
	 */
	int ASSOCIATION_CLASS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__DESCRIPTION = CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__ATTRIBUTE = CLASS__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Attribute Referential</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__ATTRIBUTE_REFERENTIAL = CLASS__ATTRIBUTE_REFERENTIAL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__OPERATION = CLASS__OPERATION;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__CONSTRAINTS = CLASS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__STATE_MACHINE = CLASS__STATE_MACHINE;

	/**
	 * The feature id for the '<em><b>Identifier Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IDENTIFIER_PRIMARY = CLASS__IDENTIFIER_PRIMARY;

	/**
	 * The feature id for the '<em><b>Identifier Non Primary</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__IDENTIFIER_NON_PRIMARY = CLASS__IDENTIFIER_NON_PRIMARY;

	/**
	 * The feature id for the '<em><b>Association End Primary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__ASSOCIATION_END_PRIMARY = CLASS__ASSOCIATION_END_PRIMARY;

	/**
	 * The feature id for the '<em><b>Association End Secondary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__ASSOCIATION_END_SECONDARY = CLASS__ASSOCIATION_END_SECONDARY;

	/**
	 * The feature id for the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__PERSISTENCE = CLASS__PERSISTENCE;

	/**
	 * The feature id for the '<em><b>Specialization Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__SPECIALIZATION_GROUP = CLASS__SPECIALIZATION_GROUP;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS__ASSOCIATION = CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CLASS_FEATURE_COUNT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.IdentifierParticipant <em>Identifier Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.IdentifierParticipant
	 * @see model.impl.ModelPackageImpl#getIdentifierParticipant()
	 * @generated
	 */
	int IDENTIFIER_PARTICIPANT = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_PARTICIPANT__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_PARTICIPANT__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Identifier Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_PARTICIPANT_FEATURE_COUNT = NAMED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AttributeImpl
	 * @see model.impl.ModelPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = IDENTIFIER_PARTICIPANT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DESCRIPTION = IDENTIFIER_PARTICIPANT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__CLASS = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__CONSTRAINTS = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__UNIQUE = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Identifier Primary</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IDENTIFIER_PRIMARY = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Identifier Non Primary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IDENTIFIER_NON_PRIMARY = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MANDATORY = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PERSISTENCE = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUES = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link model.impl.AttributeReferentialImpl <em>Attribute Referential</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AttributeReferentialImpl
	 * @see model.impl.ModelPackageImpl#getAttributeReferential()
	 * @generated
	 */
	int ATTRIBUTE_REFERENTIAL = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENTIAL__NAME = IDENTIFIER_PARTICIPANT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENTIAL__DESCRIPTION = IDENTIFIER_PARTICIPANT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Association End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENTIAL__ASSOCIATION_END = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENTIAL__CLASS = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Identifier Primary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Identifier Non Primary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attribute Referential</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REFERENTIAL_FEATURE_COUNT = IDENTIFIER_PARTICIPANT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link model.impl.OperationSignatureImpl <em>Operation Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.OperationSignatureImpl
	 * @see model.impl.ModelPackageImpl#getOperationSignature()
	 * @generated
	 */
	int OPERATION_SIGNATURE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIGNATURE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIGNATURE__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIGNATURE__PARAMETER = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Returns</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIGNATURE__RETURNS = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Returns Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIGNATURE__RETURNS_MULTIPLE = NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SIGNATURE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.OperationImpl
	 * @see model.impl.ModelPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = OPERATION_SIGNATURE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__DESCRIPTION = OPERATION_SIGNATURE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PARAMETER = OPERATION_SIGNATURE__PARAMETER;

	/**
	 * The feature id for the '<em><b>Returns</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__RETURNS = OPERATION_SIGNATURE__RETURNS;

	/**
	 * The feature id for the '<em><b>Returns Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__RETURNS_MULTIPLE = OPERATION_SIGNATURE__RETURNS_MULTIPLE;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ACTION = OPERATION_SIGNATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = OPERATION_SIGNATURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.Type <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Type
	 * @see model.impl.ModelPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.FreeTypeImpl <em>Free Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.FreeTypeImpl
	 * @see model.impl.ModelPackageImpl#getFreeType()
	 * @generated
	 */
	int FREE_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_TYPE__TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_TYPE__MULTIPLE = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_TYPE__SYSTEM = TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Free Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ParameterImpl
	 * @see model.impl.ModelPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MULTIPLE = NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.impl.ActionLanguageImpl <em>Action Language</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ActionLanguageImpl
	 * @see model.impl.ModelPackageImpl#getActionLanguage()
	 * @generated
	 */
	int ACTION_LANGUAGE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LANGUAGE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LANGUAGE__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LANGUAGE__ACTION = NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Language</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_LANGUAGE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.ObjectConstraintLanguageImpl <em>Object Constraint Language</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ObjectConstraintLanguageImpl
	 * @see model.impl.ModelPackageImpl#getObjectConstraintLanguage()
	 * @generated
	 */
	int OBJECT_CONSTRAINT_LANGUAGE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONSTRAINT_LANGUAGE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONSTRAINT_LANGUAGE__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Ocl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONSTRAINT_LANGUAGE__OCL = NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Constraint Language</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CONSTRAINT_LANGUAGE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.Identifier <em>Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Identifier
	 * @see model.impl.ModelPackageImpl#getIdentifier()
	 * @generated
	 */
	int IDENTIFIER = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_FEATURE_COUNT = NAMED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.IdentifierPrimaryImpl <em>Identifier Primary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.IdentifierPrimaryImpl
	 * @see model.impl.ModelPackageImpl#getIdentifierPrimary()
	 * @generated
	 */
	int IDENTIFIER_PRIMARY = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_PRIMARY__NAME = IDENTIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_PRIMARY__DESCRIPTION = IDENTIFIER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_PRIMARY__ATTRIBUTE = IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute Referential</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL = IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Identifier Primary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_PRIMARY_FEATURE_COUNT = IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.impl.IdentifierNonPrimaryImpl <em>Identifier Non Primary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.IdentifierNonPrimaryImpl
	 * @see model.impl.ModelPackageImpl#getIdentifierNonPrimary()
	 * @generated
	 */
	int IDENTIFIER_NON_PRIMARY = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_NON_PRIMARY__NAME = IDENTIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_NON_PRIMARY__DESCRIPTION = IDENTIFIER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_NON_PRIMARY__ATTRIBUTE = IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute Referential</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_NON_PRIMARY__ATTRIBUTE_REFERENTIAL = IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Identifier Non Primary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_NON_PRIMARY_FEATURE_COUNT = IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.Event <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Event
	 * @see model.impl.ModelPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TRANSITION = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PARAMETER = NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.impl.SignalEventImpl <em>Signal Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.SignalEventImpl
	 * @see model.impl.ModelPackageImpl#getSignalEvent()
	 * @generated
	 */
	int SIGNAL_EVENT = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT__DESCRIPTION = EVENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT__TRANSITION = EVENT__TRANSITION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT__PARAMETER = EVENT__PARAMETER;

	/**
	 * The number of structural features of the '<em>Signal Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.TimerEventImpl <em>Timer Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.TimerEventImpl
	 * @see model.impl.ModelPackageImpl#getTimerEvent()
	 * @generated
	 */
	int TIMER_EVENT = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT__DESCRIPTION = EVENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT__TRANSITION = EVENT__TRANSITION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT__PARAMETER = EVENT__PARAMETER;

	/**
	 * The feature id for the '<em><b>Time Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT__TIME_MS = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Timer Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.ChangeEventImpl <em>Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ChangeEventImpl
	 * @see model.impl.ModelPackageImpl#getChangeEvent()
	 * @generated
	 */
	int CHANGE_EVENT = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_EVENT__DESCRIPTION = EVENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_EVENT__TRANSITION = EVENT__TRANSITION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_EVENT__PARAMETER = EVENT__PARAMETER;

	/**
	 * The number of structural features of the '<em>Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.CallEventImpl <em>Call Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.CallEventImpl
	 * @see model.impl.ModelPackageImpl#getCallEvent()
	 * @generated
	 */
	int CALL_EVENT = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EVENT__DESCRIPTION = EVENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EVENT__TRANSITION = EVENT__TRANSITION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EVENT__PARAMETER = EVENT__PARAMETER;

	/**
	 * The number of structural features of the '<em>Call Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.ExceptionEventImpl <em>Exception Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ExceptionEventImpl
	 * @see model.impl.ModelPackageImpl#getExceptionEvent()
	 * @generated
	 */
	int EXCEPTION_EVENT = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__DESCRIPTION = EVENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__TRANSITION = EVENT__TRANSITION;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT__PARAMETER = EVENT__PARAMETER;

	/**
	 * The number of structural features of the '<em>Exception Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.PrimitiveTypeImpl
	 * @see model.impl.ModelPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__DESCRIPTION = TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__PRIMITIVE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__SYSTEM = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__PRECISION = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__SCALE = TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Utc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__UTC = TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__LENGTH = TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Yes No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__YES_NO = TYPE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link model.Stately <em>Stately</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Stately
	 * @see model.impl.ModelPackageImpl#getStately()
	 * @generated
	 */
	int STATELY = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELY__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELY__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Stately</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATELY_FEATURE_COUNT = NAMED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.ToState <em>To State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.ToState
	 * @see model.impl.ModelPackageImpl#getToState()
	 * @generated
	 */
	int TO_STATE = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STATE__NAME = STATELY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STATE__DESCRIPTION = STATELY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STATE__TRANSITION_FROM = STATELY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STATE__EVENT = STATELY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>To State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_STATE_FEATURE_COUNT = STATELY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.StateImpl
	 * @see model.impl.ModelPackageImpl#getState()
	 * @generated
	 */
	int STATE = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = TO_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__DESCRIPTION = TO_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TRANSITION_FROM = TO_STATE__TRANSITION_FROM;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EVENT = TO_STATE__EVENT;

	/**
	 * The feature id for the '<em><b>Transition To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TRANSITION_TO = TO_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entry Procedure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ENTRY_PROCEDURE = TO_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__STATE_MACHINE = TO_STATE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = TO_STATE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.TransitionImpl
	 * @see model.impl.ModelPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Event</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EVENT = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FROM_STATE = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TO_STATE = NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = NAMED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.impl.ProcedureImpl <em>Procedure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ProcedureImpl
	 * @see model.impl.ModelPackageImpl#getProcedure()
	 * @generated
	 */
	int PROCEDURE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__ACTION = NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.FromState <em>From State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.FromState
	 * @see model.impl.ModelPackageImpl#getFromState()
	 * @generated
	 */
	int FROM_STATE = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_STATE__NAME = STATELY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_STATE__DESCRIPTION = STATELY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_STATE__TRANSITION_TO = STATELY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>From State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FROM_STATE_FEATURE_COUNT = STATELY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.InitialStateImpl <em>Initial State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.InitialStateImpl
	 * @see model.impl.ModelPackageImpl#getInitialState()
	 * @generated
	 */
	int INITIAL_STATE = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__NAME = FROM_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__DESCRIPTION = FROM_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__TRANSITION_TO = FROM_STATE__TRANSITION_TO;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__STATE_MACHINE = FROM_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE_FEATURE_COUNT = FROM_STATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.FinalStateImpl
	 * @see model.impl.ModelPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NAME = TO_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__DESCRIPTION = TO_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Transition From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__TRANSITION_FROM = TO_STATE__TRANSITION_FROM;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__EVENT = TO_STATE__EVENT;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__STATE_MACHINE = TO_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = TO_STATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.StateMachineImpl
	 * @see model.impl.ModelPackageImpl#getStateMachine()
	 * @generated
	 */
	int STATE_MACHINE = 35;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__CLASS = 0;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__INITIAL_STATE = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__STATE = 2;

	/**
	 * The feature id for the '<em><b>Final State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__FINAL_STATE = 3;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__EVENT = 4;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link model.impl.IndexImpl <em>Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.IndexImpl
	 * @see model.impl.ModelPackageImpl#getIndex()
	 * @generated
	 */
	int INDEX = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX__ATTRIBUTE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FEATURE_COUNT = NAMED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.impl.ClassPersistenceImpl <em>Class Persistence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.ClassPersistenceImpl
	 * @see model.impl.ModelPackageImpl#getClassPersistence()
	 * @generated
	 */
	int CLASS_PERSISTENCE = 39;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PERSISTENCE__SCHEMA = 0;

	/**
	 * The feature id for the '<em><b>Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PERSISTENCE__TABLE = 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PERSISTENCE__INDEX = 2;

	/**
	 * The number of structural features of the '<em>Class Persistence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PERSISTENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link model.impl.AttributePersistenceImpl <em>Attribute Persistence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AttributePersistenceImpl
	 * @see model.impl.ModelPackageImpl#getAttributePersistence()
	 * @generated
	 */
	int ATTRIBUTE_PERSISTENCE = 40;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PERSISTENCE__COLUMN = 0;

	/**
	 * The feature id for the '<em><b>Generated By Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PERSISTENCE__GENERATED_BY_SEQUENCE = 1;

	/**
	 * The feature id for the '<em><b>Generated Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PERSISTENCE__GENERATED_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PERSISTENCE__LENGTH = 3;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PERSISTENCE__SCALE = 4;

	/**
	 * The feature id for the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PERSISTENCE__PRECISION = 5;

	/**
	 * The number of structural features of the '<em>Attribute Persistence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PERSISTENCE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link model.impl.AssociationEndPersistenceImpl <em>Association End Persistence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.AssociationEndPersistenceImpl
	 * @see model.impl.ModelPackageImpl#getAssociationEndPersistence()
	 * @generated
	 */
	int ASSOCIATION_END_PERSISTENCE = 41;

	/**
	 * The feature id for the '<em><b>Lazy Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PERSISTENCE__LAZY_FETCH = 0;

	/**
	 * The feature id for the '<em><b>Order By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PERSISTENCE__ORDER_BY = 1;

	/**
	 * The number of structural features of the '<em>Association End Persistence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_END_PERSISTENCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link model.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.DataTypeImpl
	 * @see model.impl.ModelPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__ATTRIBUTE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PACKAGE = NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.impl.SpecializationGroupImpl <em>Specialization Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.SpecializationGroupImpl
	 * @see model.impl.ModelPackageImpl#getSpecializationGroup()
	 * @generated
	 */
	int SPECIALIZATION_GROUP = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_GROUP__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_GROUP__DESCRIPTION = NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Generalization</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_GROUP__GENERALIZATION = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specialization</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_GROUP__SPECIALIZATION = NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Specialization Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_GROUP_FEATURE_COUNT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.impl.SpecializationImpl <em>Specialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.impl.SpecializationImpl
	 * @see model.impl.ModelPackageImpl#getSpecialization()
	 * @generated
	 */
	int SPECIALIZATION = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__NAME = CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__DESCRIPTION = CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__PACKAGE = CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__ATTRIBUTE = CLASS__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Attribute Referential</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__ATTRIBUTE_REFERENTIAL = CLASS__ATTRIBUTE_REFERENTIAL;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__OPERATION = CLASS__OPERATION;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__CONSTRAINTS = CLASS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__STATE_MACHINE = CLASS__STATE_MACHINE;

	/**
	 * The feature id for the '<em><b>Identifier Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__IDENTIFIER_PRIMARY = CLASS__IDENTIFIER_PRIMARY;

	/**
	 * The feature id for the '<em><b>Identifier Non Primary</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__IDENTIFIER_NON_PRIMARY = CLASS__IDENTIFIER_NON_PRIMARY;

	/**
	 * The feature id for the '<em><b>Association End Primary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__ASSOCIATION_END_PRIMARY = CLASS__ASSOCIATION_END_PRIMARY;

	/**
	 * The feature id for the '<em><b>Association End Secondary</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__ASSOCIATION_END_SECONDARY = CLASS__ASSOCIATION_END_SECONDARY;

	/**
	 * The feature id for the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__PERSISTENCE = CLASS__PERSISTENCE;

	/**
	 * The feature id for the '<em><b>Specialization Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__SPECIALIZATION_GROUP = CLASS__SPECIALIZATION_GROUP;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION__GROUP = CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_FEATURE_COUNT = CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.Primitive <em>Primitive</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.Primitive
	 * @see model.impl.ModelPackageImpl#getPrimitive()
	 * @generated
	 */
	int PRIMITIVE = 45;


	/**
	 * Returns the meta object for class '{@link model.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see model.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package</em>'.
	 * @see model.System#getPackage()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Association</em>'.
	 * @see model.System#getAssociation()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Association();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see model.System#getConstraint()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Constraint();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getCollaborator <em>Collaborator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collaborator</em>'.
	 * @see model.System#getCollaborator()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Collaborator();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getCommunication <em>Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Communication</em>'.
	 * @see model.System#getCommunication()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Communication();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain</em>'.
	 * @see model.System#getDomain()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Domain();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getBridge <em>Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bridge</em>'.
	 * @see model.System#getBridge()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Bridge();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Case</em>'.
	 * @see model.System#getUseCase()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_UseCase();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getActorUseCase <em>Actor Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actor Use Case</em>'.
	 * @see model.System#getActorUseCase()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_ActorUseCase();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getUnitTest <em>Unit Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit Test</em>'.
	 * @see model.System#getUnitTest()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_UnitTest();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event</em>'.
	 * @see model.System#getEvent()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Event();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getFreeType <em>Free Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Free Type</em>'.
	 * @see model.System#getFreeType()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_FreeType();

	/**
	 * Returns the meta object for the containment reference list '{@link model.System#getPrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Primitive Type</em>'.
	 * @see model.System#getPrimitiveType()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_PrimitiveType();

	/**
	 * Returns the meta object for class '{@link model.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see model.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Package#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class</em>'.
	 * @see model.Package#getClass_()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Class();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Package#getSubPackage <em>Sub Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Package</em>'.
	 * @see model.Package#getSubPackage()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_SubPackage();

	/**
	 * Returns the meta object for the container reference '{@link model.Package#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see model.Package#getParent()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Package#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Type</em>'.
	 * @see model.Package#getDataType()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_DataType();

	/**
	 * Returns the meta object for class '{@link model.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see model.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the container reference '{@link model.Class#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see model.Class#getPackage()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Class#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute</em>'.
	 * @see model.Class#getAttribute()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attribute();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Class#getAttributeReferential <em>Attribute Referential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute Referential</em>'.
	 * @see model.Class#getAttributeReferential()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_AttributeReferential();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Class#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation</em>'.
	 * @see model.Class#getOperation()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Operation();

	/**
	 * Returns the meta object for the containment reference '{@link model.Class#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraints</em>'.
	 * @see model.Class#getConstraints()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Constraints();

	/**
	 * Returns the meta object for the containment reference '{@link model.Class#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Machine</em>'.
	 * @see model.Class#getStateMachine()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_StateMachine();

	/**
	 * Returns the meta object for the containment reference '{@link model.Class#getIdentifierPrimary <em>Identifier Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier Primary</em>'.
	 * @see model.Class#getIdentifierPrimary()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_IdentifierPrimary();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Class#getIdentifierNonPrimary <em>Identifier Non Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifier Non Primary</em>'.
	 * @see model.Class#getIdentifierNonPrimary()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_IdentifierNonPrimary();

	/**
	 * Returns the meta object for the reference list '{@link model.Class#getAssociationEndPrimary <em>Association End Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Association End Primary</em>'.
	 * @see model.Class#getAssociationEndPrimary()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_AssociationEndPrimary();

	/**
	 * Returns the meta object for the reference list '{@link model.Class#getAssociationEndSecondary <em>Association End Secondary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Association End Secondary</em>'.
	 * @see model.Class#getAssociationEndSecondary()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_AssociationEndSecondary();

	/**
	 * Returns the meta object for the containment reference '{@link model.Class#getPersistence <em>Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Persistence</em>'.
	 * @see model.Class#getPersistence()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Persistence();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Class#getSpecializationGroup <em>Specialization Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specialization Group</em>'.
	 * @see model.Class#getSpecializationGroup()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_SpecializationGroup();

	/**
	 * Returns the meta object for class '{@link model.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see model.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the containment reference '{@link model.Association#getPrimary <em>Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primary</em>'.
	 * @see model.Association#getPrimary()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Primary();

	/**
	 * Returns the meta object for the containment reference '{@link model.Association#getSecondary <em>Secondary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Secondary</em>'.
	 * @see model.Association#getSecondary()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Secondary();

	/**
	 * Returns the meta object for the reference '{@link model.Association#getAssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association Class</em>'.
	 * @see model.Association#getAssociationClass()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_AssociationClass();

	/**
	 * Returns the meta object for class '{@link model.AssociationEndPrimary <em>Association End Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association End Primary</em>'.
	 * @see model.AssociationEndPrimary
	 * @generated
	 */
	EClass getAssociationEndPrimary();

	/**
	 * Returns the meta object for the reference '{@link model.AssociationEndPrimary#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see model.AssociationEndPrimary#getClass_()
	 * @see #getAssociationEndPrimary()
	 * @generated
	 */
	EReference getAssociationEndPrimary_Class();

	/**
	 * Returns the meta object for the container reference '{@link model.AssociationEndPrimary#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Association</em>'.
	 * @see model.AssociationEndPrimary#getAssociation()
	 * @see #getAssociationEndPrimary()
	 * @generated
	 */
	EReference getAssociationEndPrimary_Association();

	/**
	 * Returns the meta object for class '{@link model.AssociationEndSecondary <em>Association End Secondary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association End Secondary</em>'.
	 * @see model.AssociationEndSecondary
	 * @generated
	 */
	EClass getAssociationEndSecondary();

	/**
	 * Returns the meta object for the reference '{@link model.AssociationEndSecondary#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see model.AssociationEndSecondary#getClass_()
	 * @see #getAssociationEndSecondary()
	 * @generated
	 */
	EReference getAssociationEndSecondary_Class();

	/**
	 * Returns the meta object for the container reference '{@link model.AssociationEndSecondary#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Association</em>'.
	 * @see model.AssociationEndSecondary#getAssociation()
	 * @see #getAssociationEndSecondary()
	 * @generated
	 */
	EReference getAssociationEndSecondary_Association();

	/**
	 * Returns the meta object for class '{@link model.AssociationEnd <em>Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association End</em>'.
	 * @see model.AssociationEnd
	 * @generated
	 */
	EClass getAssociationEnd();

	/**
	 * Returns the meta object for the attribute '{@link model.AssociationEnd#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see model.AssociationEnd#isMandatory()
	 * @see #getAssociationEnd()
	 * @generated
	 */
	EAttribute getAssociationEnd_Mandatory();

	/**
	 * Returns the meta object for the attribute '{@link model.AssociationEnd#isMultiple <em>Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiple</em>'.
	 * @see model.AssociationEnd#isMultiple()
	 * @see #getAssociationEnd()
	 * @generated
	 */
	EAttribute getAssociationEnd_Multiple();

	/**
	 * Returns the meta object for the attribute '{@link model.AssociationEnd#getVerbClause <em>Verb Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verb Clause</em>'.
	 * @see model.AssociationEnd#getVerbClause()
	 * @see #getAssociationEnd()
	 * @generated
	 */
	EAttribute getAssociationEnd_VerbClause();

	/**
	 * Returns the meta object for the attribute '{@link model.AssociationEnd#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see model.AssociationEnd#getRole()
	 * @see #getAssociationEnd()
	 * @generated
	 */
	EAttribute getAssociationEnd_Role();

	/**
	 * Returns the meta object for the attribute '{@link model.AssociationEnd#getRolePlural <em>Role Plural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role Plural</em>'.
	 * @see model.AssociationEnd#getRolePlural()
	 * @see #getAssociationEnd()
	 * @generated
	 */
	EAttribute getAssociationEnd_RolePlural();

	/**
	 * Returns the meta object for the reference list '{@link model.AssociationEnd#getDerivedAttribute <em>Derived Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derived Attribute</em>'.
	 * @see model.AssociationEnd#getDerivedAttribute()
	 * @see #getAssociationEnd()
	 * @generated
	 */
	EReference getAssociationEnd_DerivedAttribute();

	/**
	 * Returns the meta object for the containment reference '{@link model.AssociationEnd#getPersistence <em>Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Persistence</em>'.
	 * @see model.AssociationEnd#getPersistence()
	 * @see #getAssociationEnd()
	 * @generated
	 */
	EReference getAssociationEnd_Persistence();

	/**
	 * Returns the meta object for class '{@link model.AssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Class</em>'.
	 * @see model.AssociationClass
	 * @generated
	 */
	EClass getAssociationClass();

	/**
	 * Returns the meta object for the reference '{@link model.AssociationClass#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association</em>'.
	 * @see model.AssociationClass#getAssociation()
	 * @see #getAssociationClass()
	 * @generated
	 */
	EReference getAssociationClass_Association();

	/**
	 * Returns the meta object for class '{@link model.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see model.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the container reference '{@link model.Attribute#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class</em>'.
	 * @see model.Attribute#getClass_()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Class();

	/**
	 * Returns the meta object for the containment reference '{@link model.Attribute#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraints</em>'.
	 * @see model.Attribute#getConstraints()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Constraints();

	/**
	 * Returns the meta object for the reference '{@link model.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see model.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Type();

	/**
	 * Returns the meta object for the attribute '{@link model.Attribute#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see model.Attribute#isUnique()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Unique();

	/**
	 * Returns the meta object for the reference '{@link model.Attribute#getIdentifierPrimary <em>Identifier Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier Primary</em>'.
	 * @see model.Attribute#getIdentifierPrimary()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_IdentifierPrimary();

	/**
	 * Returns the meta object for the reference list '{@link model.Attribute#getIdentifierNonPrimary <em>Identifier Non Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Identifier Non Primary</em>'.
	 * @see model.Attribute#getIdentifierNonPrimary()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_IdentifierNonPrimary();

	/**
	 * Returns the meta object for the attribute '{@link model.Attribute#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see model.Attribute#isMandatory()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Mandatory();

	/**
	 * Returns the meta object for the containment reference '{@link model.Attribute#getPersistence <em>Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Persistence</em>'.
	 * @see model.Attribute#getPersistence()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Persistence();

	/**
	 * Returns the meta object for the attribute list '{@link model.Attribute#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see model.Attribute#getValues()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Values();

	/**
	 * Returns the meta object for class '{@link model.AttributeReferential <em>Attribute Referential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Referential</em>'.
	 * @see model.AttributeReferential
	 * @generated
	 */
	EClass getAttributeReferential();

	/**
	 * Returns the meta object for the reference '{@link model.AttributeReferential#getAssociationEnd <em>Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association End</em>'.
	 * @see model.AttributeReferential#getAssociationEnd()
	 * @see #getAttributeReferential()
	 * @generated
	 */
	EReference getAttributeReferential_AssociationEnd();

	/**
	 * Returns the meta object for the container reference '{@link model.AttributeReferential#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class</em>'.
	 * @see model.AttributeReferential#getClass_()
	 * @see #getAttributeReferential()
	 * @generated
	 */
	EReference getAttributeReferential_Class();

	/**
	 * Returns the meta object for the reference list '{@link model.AttributeReferential#getIdentifierPrimary <em>Identifier Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Identifier Primary</em>'.
	 * @see model.AttributeReferential#getIdentifierPrimary()
	 * @see #getAttributeReferential()
	 * @generated
	 */
	EReference getAttributeReferential_IdentifierPrimary();

	/**
	 * Returns the meta object for the reference list '{@link model.AttributeReferential#getIdentifierNonPrimary <em>Identifier Non Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Identifier Non Primary</em>'.
	 * @see model.AttributeReferential#getIdentifierNonPrimary()
	 * @see #getAttributeReferential()
	 * @generated
	 */
	EReference getAttributeReferential_IdentifierNonPrimary();

	/**
	 * Returns the meta object for class '{@link model.OperationSignature <em>Operation Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Signature</em>'.
	 * @see model.OperationSignature
	 * @generated
	 */
	EClass getOperationSignature();

	/**
	 * Returns the meta object for the containment reference list '{@link model.OperationSignature#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see model.OperationSignature#getParameter()
	 * @see #getOperationSignature()
	 * @generated
	 */
	EReference getOperationSignature_Parameter();

	/**
	 * Returns the meta object for the reference '{@link model.OperationSignature#getReturns <em>Returns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Returns</em>'.
	 * @see model.OperationSignature#getReturns()
	 * @see #getOperationSignature()
	 * @generated
	 */
	EReference getOperationSignature_Returns();

	/**
	 * Returns the meta object for the attribute '{@link model.OperationSignature#isReturnsMultiple <em>Returns Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Returns Multiple</em>'.
	 * @see model.OperationSignature#isReturnsMultiple()
	 * @see #getOperationSignature()
	 * @generated
	 */
	EAttribute getOperationSignature_ReturnsMultiple();

	/**
	 * Returns the meta object for class '{@link model.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see model.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference '{@link model.Operation#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see model.Operation#getAction()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Action();

	/**
	 * Returns the meta object for class '{@link model.FreeType <em>Free Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Type</em>'.
	 * @see model.FreeType
	 * @generated
	 */
	EClass getFreeType();

	/**
	 * Returns the meta object for the attribute '{@link model.FreeType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see model.FreeType#getType()
	 * @see #getFreeType()
	 * @generated
	 */
	EAttribute getFreeType_Type();

	/**
	 * Returns the meta object for the attribute '{@link model.FreeType#isMultiple <em>Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiple</em>'.
	 * @see model.FreeType#isMultiple()
	 * @see #getFreeType()
	 * @generated
	 */
	EAttribute getFreeType_Multiple();

	/**
	 * Returns the meta object for the container reference '{@link model.FreeType#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>System</em>'.
	 * @see model.FreeType#getSystem()
	 * @see #getFreeType()
	 * @generated
	 */
	EReference getFreeType_System();

	/**
	 * Returns the meta object for class '{@link model.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see model.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link model.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see model.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link model.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see model.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link model.Parameter#isMultiple <em>Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiple</em>'.
	 * @see model.Parameter#isMultiple()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Multiple();

	/**
	 * Returns the meta object for class '{@link model.ActionLanguage <em>Action Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Language</em>'.
	 * @see model.ActionLanguage
	 * @generated
	 */
	EClass getActionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link model.ActionLanguage#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see model.ActionLanguage#getAction()
	 * @see #getActionLanguage()
	 * @generated
	 */
	EAttribute getActionLanguage_Action();

	/**
	 * Returns the meta object for class '{@link model.ObjectConstraintLanguage <em>Object Constraint Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Constraint Language</em>'.
	 * @see model.ObjectConstraintLanguage
	 * @generated
	 */
	EClass getObjectConstraintLanguage();

	/**
	 * Returns the meta object for the attribute '{@link model.ObjectConstraintLanguage#getOcl <em>Ocl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ocl</em>'.
	 * @see model.ObjectConstraintLanguage#getOcl()
	 * @see #getObjectConstraintLanguage()
	 * @generated
	 */
	EAttribute getObjectConstraintLanguage_Ocl();

	/**
	 * Returns the meta object for class '{@link model.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named</em>'.
	 * @see model.Named
	 * @generated
	 */
	EClass getNamed();

	/**
	 * Returns the meta object for the attribute '{@link model.Named#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see model.Named#getName()
	 * @see #getNamed()
	 * @generated
	 */
	EAttribute getNamed_Name();

	/**
	 * Returns the meta object for the attribute '{@link model.Named#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see model.Named#getDescription()
	 * @see #getNamed()
	 * @generated
	 */
	EAttribute getNamed_Description();

	/**
	 * Returns the meta object for class '{@link model.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier</em>'.
	 * @see model.Identifier
	 * @generated
	 */
	EClass getIdentifier();

	/**
	 * Returns the meta object for class '{@link model.IdentifierPrimary <em>Identifier Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Primary</em>'.
	 * @see model.IdentifierPrimary
	 * @generated
	 */
	EClass getIdentifierPrimary();

	/**
	 * Returns the meta object for the reference list '{@link model.IdentifierPrimary#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute</em>'.
	 * @see model.IdentifierPrimary#getAttribute()
	 * @see #getIdentifierPrimary()
	 * @generated
	 */
	EReference getIdentifierPrimary_Attribute();

	/**
	 * Returns the meta object for the reference list '{@link model.IdentifierPrimary#getAttributeReferential <em>Attribute Referential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute Referential</em>'.
	 * @see model.IdentifierPrimary#getAttributeReferential()
	 * @see #getIdentifierPrimary()
	 * @generated
	 */
	EReference getIdentifierPrimary_AttributeReferential();

	/**
	 * Returns the meta object for class '{@link model.IdentifierNonPrimary <em>Identifier Non Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Non Primary</em>'.
	 * @see model.IdentifierNonPrimary
	 * @generated
	 */
	EClass getIdentifierNonPrimary();

	/**
	 * Returns the meta object for the reference list '{@link model.IdentifierNonPrimary#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute</em>'.
	 * @see model.IdentifierNonPrimary#getAttribute()
	 * @see #getIdentifierNonPrimary()
	 * @generated
	 */
	EReference getIdentifierNonPrimary_Attribute();

	/**
	 * Returns the meta object for the reference list '{@link model.IdentifierNonPrimary#getAttributeReferential <em>Attribute Referential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute Referential</em>'.
	 * @see model.IdentifierNonPrimary#getAttributeReferential()
	 * @see #getIdentifierNonPrimary()
	 * @generated
	 */
	EReference getIdentifierNonPrimary_AttributeReferential();

	/**
	 * Returns the meta object for class '{@link model.IdentifierParticipant <em>Identifier Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Participant</em>'.
	 * @see model.IdentifierParticipant
	 * @generated
	 */
	EClass getIdentifierParticipant();

	/**
	 * Returns the meta object for class '{@link model.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see model.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Event#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition</em>'.
	 * @see model.Event#getTransition()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Transition();

	/**
	 * Returns the meta object for the containment reference list '{@link model.Event#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see model.Event#getParameter()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Parameter();

	/**
	 * Returns the meta object for class '{@link model.SignalEvent <em>Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal Event</em>'.
	 * @see model.SignalEvent
	 * @generated
	 */
	EClass getSignalEvent();

	/**
	 * Returns the meta object for class '{@link model.TimerEvent <em>Timer Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timer Event</em>'.
	 * @see model.TimerEvent
	 * @generated
	 */
	EClass getTimerEvent();

	/**
	 * Returns the meta object for the attribute '{@link model.TimerEvent#getTimeMs <em>Time Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Ms</em>'.
	 * @see model.TimerEvent#getTimeMs()
	 * @see #getTimerEvent()
	 * @generated
	 */
	EAttribute getTimerEvent_TimeMs();

	/**
	 * Returns the meta object for class '{@link model.ChangeEvent <em>Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Event</em>'.
	 * @see model.ChangeEvent
	 * @generated
	 */
	EClass getChangeEvent();

	/**
	 * Returns the meta object for class '{@link model.CallEvent <em>Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Event</em>'.
	 * @see model.CallEvent
	 * @generated
	 */
	EClass getCallEvent();

	/**
	 * Returns the meta object for class '{@link model.ExceptionEvent <em>Exception Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception Event</em>'.
	 * @see model.ExceptionEvent
	 * @generated
	 */
	EClass getExceptionEvent();

	/**
	 * Returns the meta object for class '{@link model.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see model.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link model.PrimitiveType#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive</em>'.
	 * @see model.PrimitiveType#getPrimitive()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Primitive();

	/**
	 * Returns the meta object for the container reference '{@link model.PrimitiveType#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>System</em>'.
	 * @see model.PrimitiveType#getSystem()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EReference getPrimitiveType_System();

	/**
	 * Returns the meta object for the attribute '{@link model.PrimitiveType#getPrecision <em>Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precision</em>'.
	 * @see model.PrimitiveType#getPrecision()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Precision();

	/**
	 * Returns the meta object for the attribute '{@link model.PrimitiveType#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see model.PrimitiveType#getScale()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Scale();

	/**
	 * Returns the meta object for the attribute '{@link model.PrimitiveType#isUtc <em>Utc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utc</em>'.
	 * @see model.PrimitiveType#isUtc()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Utc();

	/**
	 * Returns the meta object for the attribute '{@link model.PrimitiveType#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see model.PrimitiveType#getLength()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Length();

	/**
	 * Returns the meta object for the attribute '{@link model.PrimitiveType#isYesNo <em>Yes No</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Yes No</em>'.
	 * @see model.PrimitiveType#isYesNo()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_YesNo();

	/**
	 * Returns the meta object for class '{@link model.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see model.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the containment reference '{@link model.State#getEntryProcedure <em>Entry Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entry Procedure</em>'.
	 * @see model.State#getEntryProcedure()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_EntryProcedure();

	/**
	 * Returns the meta object for the container reference '{@link model.State#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State Machine</em>'.
	 * @see model.State#getStateMachine()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_StateMachine();

	/**
	 * Returns the meta object for class '{@link model.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see model.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the container reference '{@link model.Transition#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Event</em>'.
	 * @see model.Transition#getEvent()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Event();

	/**
	 * Returns the meta object for the reference '{@link model.Transition#getFromState <em>From State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From State</em>'.
	 * @see model.Transition#getFromState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_FromState();

	/**
	 * Returns the meta object for the reference '{@link model.Transition#getToState <em>To State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To State</em>'.
	 * @see model.Transition#getToState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_ToState();

	/**
	 * Returns the meta object for class '{@link model.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure</em>'.
	 * @see model.Procedure
	 * @generated
	 */
	EClass getProcedure();

	/**
	 * Returns the meta object for the containment reference '{@link model.Procedure#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see model.Procedure#getAction()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Action();

	/**
	 * Returns the meta object for class '{@link model.InitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial State</em>'.
	 * @see model.InitialState
	 * @generated
	 */
	EClass getInitialState();

	/**
	 * Returns the meta object for the container reference '{@link model.InitialState#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State Machine</em>'.
	 * @see model.InitialState#getStateMachine()
	 * @see #getInitialState()
	 * @generated
	 */
	EReference getInitialState_StateMachine();

	/**
	 * Returns the meta object for class '{@link model.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see model.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for the container reference '{@link model.FinalState#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State Machine</em>'.
	 * @see model.FinalState#getStateMachine()
	 * @see #getFinalState()
	 * @generated
	 */
	EReference getFinalState_StateMachine();

	/**
	 * Returns the meta object for class '{@link model.Stately <em>Stately</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stately</em>'.
	 * @see model.Stately
	 * @generated
	 */
	EClass getStately();

	/**
	 * Returns the meta object for class '{@link model.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see model.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the container reference '{@link model.StateMachine#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class</em>'.
	 * @see model.StateMachine#getClass_()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_Class();

	/**
	 * Returns the meta object for the containment reference '{@link model.StateMachine#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial State</em>'.
	 * @see model.StateMachine#getInitialState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_InitialState();

	/**
	 * Returns the meta object for the containment reference list '{@link model.StateMachine#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State</em>'.
	 * @see model.StateMachine#getState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_State();

	/**
	 * Returns the meta object for the containment reference '{@link model.StateMachine#getFinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Final State</em>'.
	 * @see model.StateMachine#getFinalState()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_FinalState();

	/**
	 * Returns the meta object for the containment reference list '{@link model.StateMachine#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event</em>'.
	 * @see model.StateMachine#getEvent()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_Event();

	/**
	 * Returns the meta object for class '{@link model.FromState <em>From State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>From State</em>'.
	 * @see model.FromState
	 * @generated
	 */
	EClass getFromState();

	/**
	 * Returns the meta object for the reference list '{@link model.FromState#getTransitionTo <em>Transition To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transition To</em>'.
	 * @see model.FromState#getTransitionTo()
	 * @see #getFromState()
	 * @generated
	 */
	EReference getFromState_TransitionTo();

	/**
	 * Returns the meta object for class '{@link model.ToState <em>To State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To State</em>'.
	 * @see model.ToState
	 * @generated
	 */
	EClass getToState();

	/**
	 * Returns the meta object for the reference list '{@link model.ToState#getTransitionFrom <em>Transition From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transition From</em>'.
	 * @see model.ToState#getTransitionFrom()
	 * @see #getToState()
	 * @generated
	 */
	EReference getToState_TransitionFrom();

	/**
	 * Returns the meta object for the reference list '{@link model.ToState#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event</em>'.
	 * @see model.ToState#getEvent()
	 * @see #getToState()
	 * @generated
	 */
	EReference getToState_Event();

	/**
	 * Returns the meta object for class '{@link model.Index <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index</em>'.
	 * @see model.Index
	 * @generated
	 */
	EClass getIndex();

	/**
	 * Returns the meta object for the reference list '{@link model.Index#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute</em>'.
	 * @see model.Index#getAttribute()
	 * @see #getIndex()
	 * @generated
	 */
	EReference getIndex_Attribute();

	/**
	 * Returns the meta object for class '{@link model.ClassPersistence <em>Class Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Persistence</em>'.
	 * @see model.ClassPersistence
	 * @generated
	 */
	EClass getClassPersistence();

	/**
	 * Returns the meta object for the attribute '{@link model.ClassPersistence#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema</em>'.
	 * @see model.ClassPersistence#getSchema()
	 * @see #getClassPersistence()
	 * @generated
	 */
	EAttribute getClassPersistence_Schema();

	/**
	 * Returns the meta object for the attribute '{@link model.ClassPersistence#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Table</em>'.
	 * @see model.ClassPersistence#getTable()
	 * @see #getClassPersistence()
	 * @generated
	 */
	EAttribute getClassPersistence_Table();

	/**
	 * Returns the meta object for the containment reference list '{@link model.ClassPersistence#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Index</em>'.
	 * @see model.ClassPersistence#getIndex()
	 * @see #getClassPersistence()
	 * @generated
	 */
	EReference getClassPersistence_Index();

	/**
	 * Returns the meta object for class '{@link model.AttributePersistence <em>Attribute Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Persistence</em>'.
	 * @see model.AttributePersistence
	 * @generated
	 */
	EClass getAttributePersistence();

	/**
	 * Returns the meta object for the attribute '{@link model.AttributePersistence#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see model.AttributePersistence#getColumn()
	 * @see #getAttributePersistence()
	 * @generated
	 */
	EAttribute getAttributePersistence_Column();

	/**
	 * Returns the meta object for the attribute '{@link model.AttributePersistence#isGeneratedBySequence <em>Generated By Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generated By Sequence</em>'.
	 * @see model.AttributePersistence#isGeneratedBySequence()
	 * @see #getAttributePersistence()
	 * @generated
	 */
	EAttribute getAttributePersistence_GeneratedBySequence();

	/**
	 * Returns the meta object for the attribute '{@link model.AttributePersistence#isGeneratedValue <em>Generated Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generated Value</em>'.
	 * @see model.AttributePersistence#isGeneratedValue()
	 * @see #getAttributePersistence()
	 * @generated
	 */
	EAttribute getAttributePersistence_GeneratedValue();

	/**
	 * Returns the meta object for the attribute '{@link model.AttributePersistence#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see model.AttributePersistence#getLength()
	 * @see #getAttributePersistence()
	 * @generated
	 */
	EAttribute getAttributePersistence_Length();

	/**
	 * Returns the meta object for the attribute '{@link model.AttributePersistence#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see model.AttributePersistence#getScale()
	 * @see #getAttributePersistence()
	 * @generated
	 */
	EAttribute getAttributePersistence_Scale();

	/**
	 * Returns the meta object for the attribute '{@link model.AttributePersistence#getPrecision <em>Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precision</em>'.
	 * @see model.AttributePersistence#getPrecision()
	 * @see #getAttributePersistence()
	 * @generated
	 */
	EAttribute getAttributePersistence_Precision();

	/**
	 * Returns the meta object for class '{@link model.AssociationEndPersistence <em>Association End Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association End Persistence</em>'.
	 * @see model.AssociationEndPersistence
	 * @generated
	 */
	EClass getAssociationEndPersistence();

	/**
	 * Returns the meta object for the attribute '{@link model.AssociationEndPersistence#isLazyFetch <em>Lazy Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lazy Fetch</em>'.
	 * @see model.AssociationEndPersistence#isLazyFetch()
	 * @see #getAssociationEndPersistence()
	 * @generated
	 */
	EAttribute getAssociationEndPersistence_LazyFetch();

	/**
	 * Returns the meta object for the reference list '{@link model.AssociationEndPersistence#getOrderBy <em>Order By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Order By</em>'.
	 * @see model.AssociationEndPersistence#getOrderBy()
	 * @see #getAssociationEndPersistence()
	 * @generated
	 */
	EReference getAssociationEndPersistence_OrderBy();

	/**
	 * Returns the meta object for class '{@link model.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see model.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the containment reference list '{@link model.DataType#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute</em>'.
	 * @see model.DataType#getAttribute()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Attribute();

	/**
	 * Returns the meta object for the container reference '{@link model.DataType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see model.DataType#getPackage()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Package();

	/**
	 * Returns the meta object for class '{@link model.SpecializationGroup <em>Specialization Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialization Group</em>'.
	 * @see model.SpecializationGroup
	 * @generated
	 */
	EClass getSpecializationGroup();

	/**
	 * Returns the meta object for the container reference '{@link model.SpecializationGroup#getGeneralization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Generalization</em>'.
	 * @see model.SpecializationGroup#getGeneralization()
	 * @see #getSpecializationGroup()
	 * @generated
	 */
	EReference getSpecializationGroup_Generalization();

	/**
	 * Returns the meta object for the reference list '{@link model.SpecializationGroup#getSpecialization <em>Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specialization</em>'.
	 * @see model.SpecializationGroup#getSpecialization()
	 * @see #getSpecializationGroup()
	 * @generated
	 */
	EReference getSpecializationGroup_Specialization();

	/**
	 * Returns the meta object for class '{@link model.Specialization <em>Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialization</em>'.
	 * @see model.Specialization
	 * @generated
	 */
	EClass getSpecialization();

	/**
	 * Returns the meta object for the reference list '{@link model.Specialization#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Group</em>'.
	 * @see model.Specialization#getGroup()
	 * @see #getSpecialization()
	 * @generated
	 */
	EReference getSpecialization_Group();

	/**
	 * Returns the meta object for enum '{@link model.Primitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive</em>'.
	 * @see model.Primitive
	 * @generated
	 */
	EEnum getPrimitive();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link model.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.SystemImpl
		 * @see model.impl.ModelPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__PACKAGE = eINSTANCE.getSystem_Package();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__ASSOCIATION = eINSTANCE.getSystem_Association();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__CONSTRAINT = eINSTANCE.getSystem_Constraint();

		/**
		 * The meta object literal for the '<em><b>Collaborator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__COLLABORATOR = eINSTANCE.getSystem_Collaborator();

		/**
		 * The meta object literal for the '<em><b>Communication</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__COMMUNICATION = eINSTANCE.getSystem_Communication();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__DOMAIN = eINSTANCE.getSystem_Domain();

		/**
		 * The meta object literal for the '<em><b>Bridge</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__BRIDGE = eINSTANCE.getSystem_Bridge();

		/**
		 * The meta object literal for the '<em><b>Use Case</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__USE_CASE = eINSTANCE.getSystem_UseCase();

		/**
		 * The meta object literal for the '<em><b>Actor Use Case</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__ACTOR_USE_CASE = eINSTANCE.getSystem_ActorUseCase();

		/**
		 * The meta object literal for the '<em><b>Unit Test</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__UNIT_TEST = eINSTANCE.getSystem_UnitTest();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__EVENT = eINSTANCE.getSystem_Event();

		/**
		 * The meta object literal for the '<em><b>Free Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__FREE_TYPE = eINSTANCE.getSystem_FreeType();

		/**
		 * The meta object literal for the '<em><b>Primitive Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__PRIMITIVE_TYPE = eINSTANCE.getSystem_PrimitiveType();

		/**
		 * The meta object literal for the '{@link model.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.PackageImpl
		 * @see model.impl.ModelPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__CLASS = eINSTANCE.getPackage_Class();

		/**
		 * The meta object literal for the '<em><b>Sub Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__SUB_PACKAGE = eINSTANCE.getPackage_SubPackage();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__PARENT = eINSTANCE.getPackage_Parent();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__DATA_TYPE = eINSTANCE.getPackage_DataType();

		/**
		 * The meta object literal for the '{@link model.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ClassImpl
		 * @see model.impl.ModelPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__PACKAGE = eINSTANCE.getClass_Package();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTE = eINSTANCE.getClass_Attribute();

		/**
		 * The meta object literal for the '<em><b>Attribute Referential</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTE_REFERENTIAL = eINSTANCE.getClass_AttributeReferential();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OPERATION = eINSTANCE.getClass_Operation();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__CONSTRAINTS = eINSTANCE.getClass_Constraints();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__STATE_MACHINE = eINSTANCE.getClass_StateMachine();

		/**
		 * The meta object literal for the '<em><b>Identifier Primary</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__IDENTIFIER_PRIMARY = eINSTANCE.getClass_IdentifierPrimary();

		/**
		 * The meta object literal for the '<em><b>Identifier Non Primary</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__IDENTIFIER_NON_PRIMARY = eINSTANCE.getClass_IdentifierNonPrimary();

		/**
		 * The meta object literal for the '<em><b>Association End Primary</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ASSOCIATION_END_PRIMARY = eINSTANCE.getClass_AssociationEndPrimary();

		/**
		 * The meta object literal for the '<em><b>Association End Secondary</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ASSOCIATION_END_SECONDARY = eINSTANCE.getClass_AssociationEndSecondary();

		/**
		 * The meta object literal for the '<em><b>Persistence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__PERSISTENCE = eINSTANCE.getClass_Persistence();

		/**
		 * The meta object literal for the '<em><b>Specialization Group</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SPECIALIZATION_GROUP = eINSTANCE.getClass_SpecializationGroup();

		/**
		 * The meta object literal for the '{@link model.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AssociationImpl
		 * @see model.impl.ModelPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Primary</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__PRIMARY = eINSTANCE.getAssociation_Primary();

		/**
		 * The meta object literal for the '<em><b>Secondary</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SECONDARY = eINSTANCE.getAssociation_Secondary();

		/**
		 * The meta object literal for the '<em><b>Association Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__ASSOCIATION_CLASS = eINSTANCE.getAssociation_AssociationClass();

		/**
		 * The meta object literal for the '{@link model.impl.AssociationEndPrimaryImpl <em>Association End Primary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AssociationEndPrimaryImpl
		 * @see model.impl.ModelPackageImpl#getAssociationEndPrimary()
		 * @generated
		 */
		EClass ASSOCIATION_END_PRIMARY = eINSTANCE.getAssociationEndPrimary();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_END_PRIMARY__CLASS = eINSTANCE.getAssociationEndPrimary_Class();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_END_PRIMARY__ASSOCIATION = eINSTANCE.getAssociationEndPrimary_Association();

		/**
		 * The meta object literal for the '{@link model.impl.AssociationEndSecondaryImpl <em>Association End Secondary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AssociationEndSecondaryImpl
		 * @see model.impl.ModelPackageImpl#getAssociationEndSecondary()
		 * @generated
		 */
		EClass ASSOCIATION_END_SECONDARY = eINSTANCE.getAssociationEndSecondary();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_END_SECONDARY__CLASS = eINSTANCE.getAssociationEndSecondary_Class();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_END_SECONDARY__ASSOCIATION = eINSTANCE.getAssociationEndSecondary_Association();

		/**
		 * The meta object literal for the '{@link model.impl.AssociationEndImpl <em>Association End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AssociationEndImpl
		 * @see model.impl.ModelPackageImpl#getAssociationEnd()
		 * @generated
		 */
		EClass ASSOCIATION_END = eINSTANCE.getAssociationEnd();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_END__MANDATORY = eINSTANCE.getAssociationEnd_Mandatory();

		/**
		 * The meta object literal for the '<em><b>Multiple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_END__MULTIPLE = eINSTANCE.getAssociationEnd_Multiple();

		/**
		 * The meta object literal for the '<em><b>Verb Clause</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_END__VERB_CLAUSE = eINSTANCE.getAssociationEnd_VerbClause();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_END__ROLE = eINSTANCE.getAssociationEnd_Role();

		/**
		 * The meta object literal for the '<em><b>Role Plural</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_END__ROLE_PLURAL = eINSTANCE.getAssociationEnd_RolePlural();

		/**
		 * The meta object literal for the '<em><b>Derived Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_END__DERIVED_ATTRIBUTE = eINSTANCE.getAssociationEnd_DerivedAttribute();

		/**
		 * The meta object literal for the '<em><b>Persistence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_END__PERSISTENCE = eINSTANCE.getAssociationEnd_Persistence();

		/**
		 * The meta object literal for the '{@link model.impl.AssociationClassImpl <em>Association Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AssociationClassImpl
		 * @see model.impl.ModelPackageImpl#getAssociationClass()
		 * @generated
		 */
		EClass ASSOCIATION_CLASS = eINSTANCE.getAssociationClass();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_CLASS__ASSOCIATION = eINSTANCE.getAssociationClass_Association();

		/**
		 * The meta object literal for the '{@link model.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AttributeImpl
		 * @see model.impl.ModelPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__CLASS = eINSTANCE.getAttribute_Class();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__CONSTRAINTS = eINSTANCE.getAttribute_Constraints();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__UNIQUE = eINSTANCE.getAttribute_Unique();

		/**
		 * The meta object literal for the '<em><b>Identifier Primary</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__IDENTIFIER_PRIMARY = eINSTANCE.getAttribute_IdentifierPrimary();

		/**
		 * The meta object literal for the '<em><b>Identifier Non Primary</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__IDENTIFIER_NON_PRIMARY = eINSTANCE.getAttribute_IdentifierNonPrimary();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__MANDATORY = eINSTANCE.getAttribute_Mandatory();

		/**
		 * The meta object literal for the '<em><b>Persistence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__PERSISTENCE = eINSTANCE.getAttribute_Persistence();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUES = eINSTANCE.getAttribute_Values();

		/**
		 * The meta object literal for the '{@link model.impl.AttributeReferentialImpl <em>Attribute Referential</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AttributeReferentialImpl
		 * @see model.impl.ModelPackageImpl#getAttributeReferential()
		 * @generated
		 */
		EClass ATTRIBUTE_REFERENTIAL = eINSTANCE.getAttributeReferential();

		/**
		 * The meta object literal for the '<em><b>Association End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_REFERENTIAL__ASSOCIATION_END = eINSTANCE.getAttributeReferential_AssociationEnd();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_REFERENTIAL__CLASS = eINSTANCE.getAttributeReferential_Class();

		/**
		 * The meta object literal for the '<em><b>Identifier Primary</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY = eINSTANCE.getAttributeReferential_IdentifierPrimary();

		/**
		 * The meta object literal for the '<em><b>Identifier Non Primary</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY = eINSTANCE.getAttributeReferential_IdentifierNonPrimary();

		/**
		 * The meta object literal for the '{@link model.impl.OperationSignatureImpl <em>Operation Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.OperationSignatureImpl
		 * @see model.impl.ModelPackageImpl#getOperationSignature()
		 * @generated
		 */
		EClass OPERATION_SIGNATURE = eINSTANCE.getOperationSignature();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_SIGNATURE__PARAMETER = eINSTANCE.getOperationSignature_Parameter();

		/**
		 * The meta object literal for the '<em><b>Returns</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_SIGNATURE__RETURNS = eINSTANCE.getOperationSignature_Returns();

		/**
		 * The meta object literal for the '<em><b>Returns Multiple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_SIGNATURE__RETURNS_MULTIPLE = eINSTANCE.getOperationSignature_ReturnsMultiple();

		/**
		 * The meta object literal for the '{@link model.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.OperationImpl
		 * @see model.impl.ModelPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__ACTION = eINSTANCE.getOperation_Action();

		/**
		 * The meta object literal for the '{@link model.impl.FreeTypeImpl <em>Free Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.FreeTypeImpl
		 * @see model.impl.ModelPackageImpl#getFreeType()
		 * @generated
		 */
		EClass FREE_TYPE = eINSTANCE.getFreeType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREE_TYPE__TYPE = eINSTANCE.getFreeType_Type();

		/**
		 * The meta object literal for the '<em><b>Multiple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FREE_TYPE__MULTIPLE = eINSTANCE.getFreeType_Multiple();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREE_TYPE__SYSTEM = eINSTANCE.getFreeType_System();

		/**
		 * The meta object literal for the '{@link model.Type <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Type
		 * @see model.impl.ModelPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link model.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ParameterImpl
		 * @see model.impl.ModelPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Multiple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__MULTIPLE = eINSTANCE.getParameter_Multiple();

		/**
		 * The meta object literal for the '{@link model.impl.ActionLanguageImpl <em>Action Language</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ActionLanguageImpl
		 * @see model.impl.ModelPackageImpl#getActionLanguage()
		 * @generated
		 */
		EClass ACTION_LANGUAGE = eINSTANCE.getActionLanguage();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_LANGUAGE__ACTION = eINSTANCE.getActionLanguage_Action();

		/**
		 * The meta object literal for the '{@link model.impl.ObjectConstraintLanguageImpl <em>Object Constraint Language</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ObjectConstraintLanguageImpl
		 * @see model.impl.ModelPackageImpl#getObjectConstraintLanguage()
		 * @generated
		 */
		EClass OBJECT_CONSTRAINT_LANGUAGE = eINSTANCE.getObjectConstraintLanguage();

		/**
		 * The meta object literal for the '<em><b>Ocl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_CONSTRAINT_LANGUAGE__OCL = eINSTANCE.getObjectConstraintLanguage_Ocl();

		/**
		 * The meta object literal for the '{@link model.Named <em>Named</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Named
		 * @see model.impl.ModelPackageImpl#getNamed()
		 * @generated
		 */
		EClass NAMED = eINSTANCE.getNamed();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED__DESCRIPTION = eINSTANCE.getNamed_Description();

		/**
		 * The meta object literal for the '{@link model.Identifier <em>Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Identifier
		 * @see model.impl.ModelPackageImpl#getIdentifier()
		 * @generated
		 */
		EClass IDENTIFIER = eINSTANCE.getIdentifier();

		/**
		 * The meta object literal for the '{@link model.impl.IdentifierPrimaryImpl <em>Identifier Primary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.IdentifierPrimaryImpl
		 * @see model.impl.ModelPackageImpl#getIdentifierPrimary()
		 * @generated
		 */
		EClass IDENTIFIER_PRIMARY = eINSTANCE.getIdentifierPrimary();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_PRIMARY__ATTRIBUTE = eINSTANCE.getIdentifierPrimary_Attribute();

		/**
		 * The meta object literal for the '<em><b>Attribute Referential</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL = eINSTANCE.getIdentifierPrimary_AttributeReferential();

		/**
		 * The meta object literal for the '{@link model.impl.IdentifierNonPrimaryImpl <em>Identifier Non Primary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.IdentifierNonPrimaryImpl
		 * @see model.impl.ModelPackageImpl#getIdentifierNonPrimary()
		 * @generated
		 */
		EClass IDENTIFIER_NON_PRIMARY = eINSTANCE.getIdentifierNonPrimary();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_NON_PRIMARY__ATTRIBUTE = eINSTANCE.getIdentifierNonPrimary_Attribute();

		/**
		 * The meta object literal for the '<em><b>Attribute Referential</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_NON_PRIMARY__ATTRIBUTE_REFERENTIAL = eINSTANCE.getIdentifierNonPrimary_AttributeReferential();

		/**
		 * The meta object literal for the '{@link model.IdentifierParticipant <em>Identifier Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.IdentifierParticipant
		 * @see model.impl.ModelPackageImpl#getIdentifierParticipant()
		 * @generated
		 */
		EClass IDENTIFIER_PARTICIPANT = eINSTANCE.getIdentifierParticipant();

		/**
		 * The meta object literal for the '{@link model.Event <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Event
		 * @see model.impl.ModelPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__TRANSITION = eINSTANCE.getEvent_Transition();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__PARAMETER = eINSTANCE.getEvent_Parameter();

		/**
		 * The meta object literal for the '{@link model.impl.SignalEventImpl <em>Signal Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.SignalEventImpl
		 * @see model.impl.ModelPackageImpl#getSignalEvent()
		 * @generated
		 */
		EClass SIGNAL_EVENT = eINSTANCE.getSignalEvent();

		/**
		 * The meta object literal for the '{@link model.impl.TimerEventImpl <em>Timer Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.TimerEventImpl
		 * @see model.impl.ModelPackageImpl#getTimerEvent()
		 * @generated
		 */
		EClass TIMER_EVENT = eINSTANCE.getTimerEvent();

		/**
		 * The meta object literal for the '<em><b>Time Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER_EVENT__TIME_MS = eINSTANCE.getTimerEvent_TimeMs();

		/**
		 * The meta object literal for the '{@link model.impl.ChangeEventImpl <em>Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ChangeEventImpl
		 * @see model.impl.ModelPackageImpl#getChangeEvent()
		 * @generated
		 */
		EClass CHANGE_EVENT = eINSTANCE.getChangeEvent();

		/**
		 * The meta object literal for the '{@link model.impl.CallEventImpl <em>Call Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.CallEventImpl
		 * @see model.impl.ModelPackageImpl#getCallEvent()
		 * @generated
		 */
		EClass CALL_EVENT = eINSTANCE.getCallEvent();

		/**
		 * The meta object literal for the '{@link model.impl.ExceptionEventImpl <em>Exception Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ExceptionEventImpl
		 * @see model.impl.ModelPackageImpl#getExceptionEvent()
		 * @generated
		 */
		EClass EXCEPTION_EVENT = eINSTANCE.getExceptionEvent();

		/**
		 * The meta object literal for the '{@link model.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.PrimitiveTypeImpl
		 * @see model.impl.ModelPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__PRIMITIVE = eINSTANCE.getPrimitiveType_Primitive();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE__SYSTEM = eINSTANCE.getPrimitiveType_System();

		/**
		 * The meta object literal for the '<em><b>Precision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__PRECISION = eINSTANCE.getPrimitiveType_Precision();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__SCALE = eINSTANCE.getPrimitiveType_Scale();

		/**
		 * The meta object literal for the '<em><b>Utc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__UTC = eINSTANCE.getPrimitiveType_Utc();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__LENGTH = eINSTANCE.getPrimitiveType_Length();

		/**
		 * The meta object literal for the '<em><b>Yes No</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__YES_NO = eINSTANCE.getPrimitiveType_YesNo();

		/**
		 * The meta object literal for the '{@link model.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.StateImpl
		 * @see model.impl.ModelPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Entry Procedure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ENTRY_PROCEDURE = eINSTANCE.getState_EntryProcedure();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__STATE_MACHINE = eINSTANCE.getState_StateMachine();

		/**
		 * The meta object literal for the '{@link model.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.TransitionImpl
		 * @see model.impl.ModelPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__EVENT = eINSTANCE.getTransition_Event();

		/**
		 * The meta object literal for the '<em><b>From State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__FROM_STATE = eINSTANCE.getTransition_FromState();

		/**
		 * The meta object literal for the '<em><b>To State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TO_STATE = eINSTANCE.getTransition_ToState();

		/**
		 * The meta object literal for the '{@link model.impl.ProcedureImpl <em>Procedure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ProcedureImpl
		 * @see model.impl.ModelPackageImpl#getProcedure()
		 * @generated
		 */
		EClass PROCEDURE = eINSTANCE.getProcedure();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__ACTION = eINSTANCE.getProcedure_Action();

		/**
		 * The meta object literal for the '{@link model.impl.InitialStateImpl <em>Initial State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.InitialStateImpl
		 * @see model.impl.ModelPackageImpl#getInitialState()
		 * @generated
		 */
		EClass INITIAL_STATE = eINSTANCE.getInitialState();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIAL_STATE__STATE_MACHINE = eINSTANCE.getInitialState_StateMachine();

		/**
		 * The meta object literal for the '{@link model.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.FinalStateImpl
		 * @see model.impl.ModelPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINAL_STATE__STATE_MACHINE = eINSTANCE.getFinalState_StateMachine();

		/**
		 * The meta object literal for the '{@link model.Stately <em>Stately</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Stately
		 * @see model.impl.ModelPackageImpl#getStately()
		 * @generated
		 */
		EClass STATELY = eINSTANCE.getStately();

		/**
		 * The meta object literal for the '{@link model.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.StateMachineImpl
		 * @see model.impl.ModelPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__CLASS = eINSTANCE.getStateMachine_Class();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__INITIAL_STATE = eINSTANCE.getStateMachine_InitialState();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__STATE = eINSTANCE.getStateMachine_State();

		/**
		 * The meta object literal for the '<em><b>Final State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__FINAL_STATE = eINSTANCE.getStateMachine_FinalState();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__EVENT = eINSTANCE.getStateMachine_Event();

		/**
		 * The meta object literal for the '{@link model.FromState <em>From State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.FromState
		 * @see model.impl.ModelPackageImpl#getFromState()
		 * @generated
		 */
		EClass FROM_STATE = eINSTANCE.getFromState();

		/**
		 * The meta object literal for the '<em><b>Transition To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FROM_STATE__TRANSITION_TO = eINSTANCE.getFromState_TransitionTo();

		/**
		 * The meta object literal for the '{@link model.ToState <em>To State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.ToState
		 * @see model.impl.ModelPackageImpl#getToState()
		 * @generated
		 */
		EClass TO_STATE = eINSTANCE.getToState();

		/**
		 * The meta object literal for the '<em><b>Transition From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_STATE__TRANSITION_FROM = eINSTANCE.getToState_TransitionFrom();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TO_STATE__EVENT = eINSTANCE.getToState_Event();

		/**
		 * The meta object literal for the '{@link model.impl.IndexImpl <em>Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.IndexImpl
		 * @see model.impl.ModelPackageImpl#getIndex()
		 * @generated
		 */
		EClass INDEX = eINSTANCE.getIndex();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX__ATTRIBUTE = eINSTANCE.getIndex_Attribute();

		/**
		 * The meta object literal for the '{@link model.impl.ClassPersistenceImpl <em>Class Persistence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.ClassPersistenceImpl
		 * @see model.impl.ModelPackageImpl#getClassPersistence()
		 * @generated
		 */
		EClass CLASS_PERSISTENCE = eINSTANCE.getClassPersistence();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_PERSISTENCE__SCHEMA = eINSTANCE.getClassPersistence_Schema();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_PERSISTENCE__TABLE = eINSTANCE.getClassPersistence_Table();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_PERSISTENCE__INDEX = eINSTANCE.getClassPersistence_Index();

		/**
		 * The meta object literal for the '{@link model.impl.AttributePersistenceImpl <em>Attribute Persistence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AttributePersistenceImpl
		 * @see model.impl.ModelPackageImpl#getAttributePersistence()
		 * @generated
		 */
		EClass ATTRIBUTE_PERSISTENCE = eINSTANCE.getAttributePersistence();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PERSISTENCE__COLUMN = eINSTANCE.getAttributePersistence_Column();

		/**
		 * The meta object literal for the '<em><b>Generated By Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PERSISTENCE__GENERATED_BY_SEQUENCE = eINSTANCE.getAttributePersistence_GeneratedBySequence();

		/**
		 * The meta object literal for the '<em><b>Generated Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PERSISTENCE__GENERATED_VALUE = eINSTANCE.getAttributePersistence_GeneratedValue();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PERSISTENCE__LENGTH = eINSTANCE.getAttributePersistence_Length();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PERSISTENCE__SCALE = eINSTANCE.getAttributePersistence_Scale();

		/**
		 * The meta object literal for the '<em><b>Precision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PERSISTENCE__PRECISION = eINSTANCE.getAttributePersistence_Precision();

		/**
		 * The meta object literal for the '{@link model.impl.AssociationEndPersistenceImpl <em>Association End Persistence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.AssociationEndPersistenceImpl
		 * @see model.impl.ModelPackageImpl#getAssociationEndPersistence()
		 * @generated
		 */
		EClass ASSOCIATION_END_PERSISTENCE = eINSTANCE.getAssociationEndPersistence();

		/**
		 * The meta object literal for the '<em><b>Lazy Fetch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_END_PERSISTENCE__LAZY_FETCH = eINSTANCE.getAssociationEndPersistence_LazyFetch();

		/**
		 * The meta object literal for the '<em><b>Order By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_END_PERSISTENCE__ORDER_BY = eINSTANCE.getAssociationEndPersistence_OrderBy();

		/**
		 * The meta object literal for the '{@link model.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.DataTypeImpl
		 * @see model.impl.ModelPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__ATTRIBUTE = eINSTANCE.getDataType_Attribute();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__PACKAGE = eINSTANCE.getDataType_Package();

		/**
		 * The meta object literal for the '{@link model.impl.SpecializationGroupImpl <em>Specialization Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.SpecializationGroupImpl
		 * @see model.impl.ModelPackageImpl#getSpecializationGroup()
		 * @generated
		 */
		EClass SPECIALIZATION_GROUP = eINSTANCE.getSpecializationGroup();

		/**
		 * The meta object literal for the '<em><b>Generalization</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_GROUP__GENERALIZATION = eINSTANCE.getSpecializationGroup_Generalization();

		/**
		 * The meta object literal for the '<em><b>Specialization</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_GROUP__SPECIALIZATION = eINSTANCE.getSpecializationGroup_Specialization();

		/**
		 * The meta object literal for the '{@link model.impl.SpecializationImpl <em>Specialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.impl.SpecializationImpl
		 * @see model.impl.ModelPackageImpl#getSpecialization()
		 * @generated
		 */
		EClass SPECIALIZATION = eINSTANCE.getSpecialization();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION__GROUP = eINSTANCE.getSpecialization_Group();

		/**
		 * The meta object literal for the '{@link model.Primitive <em>Primitive</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.Primitive
		 * @see model.impl.ModelPackageImpl#getPrimitive()
		 * @generated
		 */
		EEnum PRIMITIVE = eINSTANCE.getPrimitive();

	}

} //ModelPackage
