/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import model.ActionLanguage;
import model.Association;
import model.AssociationClass;
import model.AssociationEndPersistence;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributePersistence;
import model.AttributeReferential;
import model.CallEvent;
import model.ChangeEvent;
import model.ClassPersistence;
import model.DataType;
import model.ExceptionEvent;
import model.FinalState;
import model.FreeType;
import model.IdentifierNonPrimary;
import model.IdentifierPrimary;
import model.Index;
import model.InitialState;
import model.ModelFactory;
import model.ModelPackage;
import model.ObjectConstraintLanguage;
import model.Operation;
import model.OperationSignature;
import model.Parameter;
import model.Primitive;
import model.PrimitiveType;
import model.Procedure;
import model.SignalEvent;
import model.Specialization;
import model.SpecializationGroup;
import model.State;
import model.StateMachine;
import model.TimerEvent;
import model.Transition;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://davidmoten.homeip.net/uml/executable/model"); 
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.SYSTEM: return createSystem();
			case ModelPackage.PACKAGE: return createPackage();
			case ModelPackage.CLASS: return createClass();
			case ModelPackage.ASSOCIATION: return createAssociation();
			case ModelPackage.ASSOCIATION_END_PRIMARY: return createAssociationEndPrimary();
			case ModelPackage.ASSOCIATION_END_SECONDARY: return createAssociationEndSecondary();
			case ModelPackage.ASSOCIATION_CLASS: return createAssociationClass();
			case ModelPackage.ATTRIBUTE: return createAttribute();
			case ModelPackage.ATTRIBUTE_REFERENTIAL: return createAttributeReferential();
			case ModelPackage.OPERATION_SIGNATURE: return createOperationSignature();
			case ModelPackage.OPERATION: return createOperation();
			case ModelPackage.FREE_TYPE: return createFreeType();
			case ModelPackage.PARAMETER: return createParameter();
			case ModelPackage.ACTION_LANGUAGE: return createActionLanguage();
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE: return createObjectConstraintLanguage();
			case ModelPackage.IDENTIFIER_PRIMARY: return createIdentifierPrimary();
			case ModelPackage.IDENTIFIER_NON_PRIMARY: return createIdentifierNonPrimary();
			case ModelPackage.SIGNAL_EVENT: return createSignalEvent();
			case ModelPackage.TIMER_EVENT: return createTimerEvent();
			case ModelPackage.CHANGE_EVENT: return createChangeEvent();
			case ModelPackage.CALL_EVENT: return createCallEvent();
			case ModelPackage.EXCEPTION_EVENT: return createExceptionEvent();
			case ModelPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case ModelPackage.STATE: return createState();
			case ModelPackage.TRANSITION: return createTransition();
			case ModelPackage.PROCEDURE: return createProcedure();
			case ModelPackage.INITIAL_STATE: return createInitialState();
			case ModelPackage.FINAL_STATE: return createFinalState();
			case ModelPackage.STATE_MACHINE: return createStateMachine();
			case ModelPackage.INDEX: return createIndex();
			case ModelPackage.CLASS_PERSISTENCE: return createClassPersistence();
			case ModelPackage.ATTRIBUTE_PERSISTENCE: return createAttributePersistence();
			case ModelPackage.ASSOCIATION_END_PERSISTENCE: return createAssociationEndPersistence();
			case ModelPackage.DATA_TYPE: return createDataType();
			case ModelPackage.SPECIALIZATION_GROUP: return createSpecializationGroup();
			case ModelPackage.SPECIALIZATION: return createSpecialization();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.PRIMITIVE:
				return createPrimitiveFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.PRIMITIVE:
				return convertPrimitiveToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEndPrimary createAssociationEndPrimary() {
		AssociationEndPrimaryImpl associationEndPrimary = new AssociationEndPrimaryImpl();
		return associationEndPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEndSecondary createAssociationEndSecondary() {
		AssociationEndSecondaryImpl associationEndSecondary = new AssociationEndSecondaryImpl();
		return associationEndSecondary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass createAssociationClass() {
		AssociationClassImpl associationClass = new AssociationClassImpl();
		return associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeReferential createAttributeReferential() {
		AttributeReferentialImpl attributeReferential = new AttributeReferentialImpl();
		return attributeReferential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSignature createOperationSignature() {
		OperationSignatureImpl operationSignature = new OperationSignatureImpl();
		return operationSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FreeType createFreeType() {
		FreeTypeImpl freeType = new FreeTypeImpl();
		return freeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionLanguage createActionLanguage() {
		ActionLanguageImpl actionLanguage = new ActionLanguageImpl();
		return actionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectConstraintLanguage createObjectConstraintLanguage() {
		ObjectConstraintLanguageImpl objectConstraintLanguage = new ObjectConstraintLanguageImpl();
		return objectConstraintLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierPrimary createIdentifierPrimary() {
		IdentifierPrimaryImpl identifierPrimary = new IdentifierPrimaryImpl();
		return identifierPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierNonPrimary createIdentifierNonPrimary() {
		IdentifierNonPrimaryImpl identifierNonPrimary = new IdentifierNonPrimaryImpl();
		return identifierNonPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalEvent createSignalEvent() {
		SignalEventImpl signalEvent = new SignalEventImpl();
		return signalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimerEvent createTimerEvent() {
		TimerEventImpl timerEvent = new TimerEventImpl();
		return timerEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeEvent createChangeEvent() {
		ChangeEventImpl changeEvent = new ChangeEventImpl();
		return changeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallEvent createCallEvent() {
		CallEventImpl callEvent = new CallEventImpl();
		return callEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionEvent createExceptionEvent() {
		ExceptionEventImpl exceptionEvent = new ExceptionEventImpl();
		return exceptionEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Procedure createProcedure() {
		ProcedureImpl procedure = new ProcedureImpl();
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialState createInitialState() {
		InitialStateImpl initialState = new InitialStateImpl();
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalState createFinalState() {
		FinalStateImpl finalState = new FinalStateImpl();
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine createStateMachine() {
		StateMachineImpl stateMachine = new StateMachineImpl();
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Index createIndex() {
		IndexImpl index = new IndexImpl();
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPersistence createClassPersistence() {
		ClassPersistenceImpl classPersistence = new ClassPersistenceImpl();
		return classPersistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributePersistence createAttributePersistence() {
		AttributePersistenceImpl attributePersistence = new AttributePersistenceImpl();
		return attributePersistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEndPersistence createAssociationEndPersistence() {
		AssociationEndPersistenceImpl associationEndPersistence = new AssociationEndPersistenceImpl();
		return associationEndPersistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationGroup createSpecializationGroup() {
		SpecializationGroupImpl specializationGroup = new SpecializationGroupImpl();
		return specializationGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specialization createSpecialization() {
		SpecializationImpl specialization = new SpecializationImpl();
		return specialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Primitive createPrimitiveFromString(EDataType eDataType, String initialValue) {
		Primitive result = Primitive.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
