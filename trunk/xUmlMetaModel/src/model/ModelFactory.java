/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	model.System createSystem();

	/**
	 * Returns a new object of class '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package</em>'.
	 * @generated
	 */
	model.Package createPackage();

	/**
	 * Returns a new object of class '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class</em>'.
	 * @generated
	 */
	model.Class createClass();

	/**
	 * Returns a new object of class '<em>Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association</em>'.
	 * @generated
	 */
	Association createAssociation();

	/**
	 * Returns a new object of class '<em>Association End Primary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association End Primary</em>'.
	 * @generated
	 */
	AssociationEndPrimary createAssociationEndPrimary();

	/**
	 * Returns a new object of class '<em>Association End Secondary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association End Secondary</em>'.
	 * @generated
	 */
	AssociationEndSecondary createAssociationEndSecondary();

	/**
	 * Returns a new object of class '<em>Association Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Class</em>'.
	 * @generated
	 */
	AssociationClass createAssociationClass();

	/**
	 * Returns a new object of class '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute</em>'.
	 * @generated
	 */
	Attribute createAttribute();

	/**
	 * Returns a new object of class '<em>Attribute Referential</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Referential</em>'.
	 * @generated
	 */
	AttributeReferential createAttributeReferential();

	/**
	 * Returns a new object of class '<em>Operation Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Signature</em>'.
	 * @generated
	 */
	OperationSignature createOperationSignature();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>Free Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Free Type</em>'.
	 * @generated
	 */
	FreeType createFreeType();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Action Language</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Language</em>'.
	 * @generated
	 */
	ActionLanguage createActionLanguage();

	/**
	 * Returns a new object of class '<em>Object Constraint Language</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Constraint Language</em>'.
	 * @generated
	 */
	ObjectConstraintLanguage createObjectConstraintLanguage();

	/**
	 * Returns a new object of class '<em>Identifier Primary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier Primary</em>'.
	 * @generated
	 */
	IdentifierPrimary createIdentifierPrimary();

	/**
	 * Returns a new object of class '<em>Identifier Non Primary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier Non Primary</em>'.
	 * @generated
	 */
	IdentifierNonPrimary createIdentifierNonPrimary();

	/**
	 * Returns a new object of class '<em>Signal Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signal Event</em>'.
	 * @generated
	 */
	SignalEvent createSignalEvent();

	/**
	 * Returns a new object of class '<em>Timer Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timer Event</em>'.
	 * @generated
	 */
	TimerEvent createTimerEvent();

	/**
	 * Returns a new object of class '<em>Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change Event</em>'.
	 * @generated
	 */
	ChangeEvent createChangeEvent();

	/**
	 * Returns a new object of class '<em>Call Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Event</em>'.
	 * @generated
	 */
	CallEvent createCallEvent();

	/**
	 * Returns a new object of class '<em>Exception Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exception Event</em>'.
	 * @generated
	 */
	ExceptionEvent createExceptionEvent();

	/**
	 * Returns a new object of class '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type</em>'.
	 * @generated
	 */
	PrimitiveType createPrimitiveType();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedure</em>'.
	 * @generated
	 */
	Procedure createProcedure();

	/**
	 * Returns a new object of class '<em>Initial State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial State</em>'.
	 * @generated
	 */
	InitialState createInitialState();

	/**
	 * Returns a new object of class '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Final State</em>'.
	 * @generated
	 */
	FinalState createFinalState();

	/**
	 * Returns a new object of class '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Machine</em>'.
	 * @generated
	 */
	StateMachine createStateMachine();

	/**
	 * Returns a new object of class '<em>Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index</em>'.
	 * @generated
	 */
	Index createIndex();

	/**
	 * Returns a new object of class '<em>Class Persistence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Persistence</em>'.
	 * @generated
	 */
	ClassPersistence createClassPersistence();

	/**
	 * Returns a new object of class '<em>Attribute Persistence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Persistence</em>'.
	 * @generated
	 */
	AttributePersistence createAttributePersistence();

	/**
	 * Returns a new object of class '<em>Association End Persistence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association End Persistence</em>'.
	 * @generated
	 */
	AssociationEndPersistence createAssociationEndPersistence();

	/**
	 * Returns a new object of class '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type</em>'.
	 * @generated
	 */
	DataType createDataType();

	/**
	 * Returns a new object of class '<em>Specialization Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specialization Group</em>'.
	 * @generated
	 */
	SpecializationGroup createSpecializationGroup();

	/**
	 * Returns a new object of class '<em>Specialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specialization</em>'.
	 * @generated
	 */
	Specialization createSpecialization();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
