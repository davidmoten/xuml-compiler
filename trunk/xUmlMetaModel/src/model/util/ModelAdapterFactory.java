/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.util;

import model.ActionLanguage;
import model.Association;
import model.AssociationClass;
import model.AssociationEnd;
import model.AssociationEndPersistence;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributeDerived;
import model.AttributePersistence;
import model.CallEvent;
import model.ChangeEvent;
import model.ClassPersistence;
import model.DataType;
import model.Event;
import model.ExceptionEvent;
import model.FinalState;
import model.FreeType;
import model.FromState;
import model.Identifier;
import model.IdentifierNonPrimary;
import model.IdentifierParticipant;
import model.IdentifierPrimary;
import model.Index;
import model.InitialState;
import model.ModelPackage;
import model.Named;
import model.ObjectConstraintLanguage;
import model.Operation;
import model.OperationSignature;
import model.Parameter;
import model.PrimitiveType;
import model.Procedure;
import model.SignalEvent;
import model.Specialization;
import model.SpecializationGroup;
import model.State;
import model.StateMachine;
import model.Stately;
import model.TimerEvent;
import model.ToState;
import model.Transition;
import model.Type;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseSystem(model.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter casePackage(model.Package object) {
				return createPackageAdapter();
			}
			@Override
			public Adapter caseClass(model.Class object) {
				return createClassAdapter();
			}
			@Override
			public Adapter caseAssociation(Association object) {
				return createAssociationAdapter();
			}
			@Override
			public Adapter caseAssociationEndPrimary(AssociationEndPrimary object) {
				return createAssociationEndPrimaryAdapter();
			}
			@Override
			public Adapter caseAssociationEndSecondary(AssociationEndSecondary object) {
				return createAssociationEndSecondaryAdapter();
			}
			@Override
			public Adapter caseAssociationEnd(AssociationEnd object) {
				return createAssociationEndAdapter();
			}
			@Override
			public Adapter caseAssociationClass(AssociationClass object) {
				return createAssociationClassAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseAttributeDerived(AttributeDerived object) {
				return createAttributeDerivedAdapter();
			}
			@Override
			public Adapter caseOperationSignature(OperationSignature object) {
				return createOperationSignatureAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseFreeType(FreeType object) {
				return createFreeTypeAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseActionLanguage(ActionLanguage object) {
				return createActionLanguageAdapter();
			}
			@Override
			public Adapter caseObjectConstraintLanguage(ObjectConstraintLanguage object) {
				return createObjectConstraintLanguageAdapter();
			}
			@Override
			public Adapter caseNamed(Named object) {
				return createNamedAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseIdentifierPrimary(IdentifierPrimary object) {
				return createIdentifierPrimaryAdapter();
			}
			@Override
			public Adapter caseIdentifierNonPrimary(IdentifierNonPrimary object) {
				return createIdentifierNonPrimaryAdapter();
			}
			@Override
			public Adapter caseIdentifierParticipant(IdentifierParticipant object) {
				return createIdentifierParticipantAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseSignalEvent(SignalEvent object) {
				return createSignalEventAdapter();
			}
			@Override
			public Adapter caseTimerEvent(TimerEvent object) {
				return createTimerEventAdapter();
			}
			@Override
			public Adapter caseChangeEvent(ChangeEvent object) {
				return createChangeEventAdapter();
			}
			@Override
			public Adapter caseCallEvent(CallEvent object) {
				return createCallEventAdapter();
			}
			@Override
			public Adapter caseExceptionEvent(ExceptionEvent object) {
				return createExceptionEventAdapter();
			}
			@Override
			public Adapter casePrimitiveType(PrimitiveType object) {
				return createPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseProcedure(Procedure object) {
				return createProcedureAdapter();
			}
			@Override
			public Adapter caseInitialState(InitialState object) {
				return createInitialStateAdapter();
			}
			@Override
			public Adapter caseFinalState(FinalState object) {
				return createFinalStateAdapter();
			}
			@Override
			public Adapter caseStately(Stately object) {
				return createStatelyAdapter();
			}
			@Override
			public Adapter caseStateMachine(StateMachine object) {
				return createStateMachineAdapter();
			}
			@Override
			public Adapter caseFromState(FromState object) {
				return createFromStateAdapter();
			}
			@Override
			public Adapter caseToState(ToState object) {
				return createToStateAdapter();
			}
			@Override
			public Adapter caseIndex(Index object) {
				return createIndexAdapter();
			}
			@Override
			public Adapter caseClassPersistence(ClassPersistence object) {
				return createClassPersistenceAdapter();
			}
			@Override
			public Adapter caseAttributePersistence(AttributePersistence object) {
				return createAttributePersistenceAdapter();
			}
			@Override
			public Adapter caseAssociationEndPersistence(AssociationEndPersistence object) {
				return createAssociationEndPersistenceAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseSpecializationGroup(SpecializationGroup object) {
				return createSpecializationGroupAdapter();
			}
			@Override
			public Adapter caseSpecialization(Specialization object) {
				return createSpecializationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link model.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Package
	 * @generated
	 */
	public Adapter createPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Association
	 * @generated
	 */
	public Adapter createAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.AssociationEndPrimary <em>Association End Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.AssociationEndPrimary
	 * @generated
	 */
	public Adapter createAssociationEndPrimaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.AssociationEndSecondary <em>Association End Secondary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.AssociationEndSecondary
	 * @generated
	 */
	public Adapter createAssociationEndSecondaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.AssociationEnd <em>Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.AssociationEnd
	 * @generated
	 */
	public Adapter createAssociationEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.AssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.AssociationClass
	 * @generated
	 */
	public Adapter createAssociationClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.AttributeDerived <em>Attribute Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.AttributeDerived
	 * @generated
	 */
	public Adapter createAttributeDerivedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.OperationSignature <em>Operation Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.OperationSignature
	 * @generated
	 */
	public Adapter createOperationSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.FreeType <em>Free Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.FreeType
	 * @generated
	 */
	public Adapter createFreeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.ActionLanguage <em>Action Language</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.ActionLanguage
	 * @generated
	 */
	public Adapter createActionLanguageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.ObjectConstraintLanguage <em>Object Constraint Language</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.ObjectConstraintLanguage
	 * @generated
	 */
	public Adapter createObjectConstraintLanguageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Named
	 * @generated
	 */
	public Adapter createNamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.IdentifierPrimary <em>Identifier Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.IdentifierPrimary
	 * @generated
	 */
	public Adapter createIdentifierPrimaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.IdentifierNonPrimary <em>Identifier Non Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.IdentifierNonPrimary
	 * @generated
	 */
	public Adapter createIdentifierNonPrimaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.IdentifierParticipant <em>Identifier Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.IdentifierParticipant
	 * @generated
	 */
	public Adapter createIdentifierParticipantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.SignalEvent <em>Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.SignalEvent
	 * @generated
	 */
	public Adapter createSignalEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.TimerEvent <em>Timer Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.TimerEvent
	 * @generated
	 */
	public Adapter createTimerEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.ChangeEvent <em>Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.ChangeEvent
	 * @generated
	 */
	public Adapter createChangeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.CallEvent <em>Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.CallEvent
	 * @generated
	 */
	public Adapter createCallEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.ExceptionEvent <em>Exception Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.ExceptionEvent
	 * @generated
	 */
	public Adapter createExceptionEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Procedure
	 * @generated
	 */
	public Adapter createProcedureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.InitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.InitialState
	 * @generated
	 */
	public Adapter createInitialStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.FinalState
	 * @generated
	 */
	public Adapter createFinalStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Stately <em>Stately</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Stately
	 * @generated
	 */
	public Adapter createStatelyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.StateMachine
	 * @generated
	 */
	public Adapter createStateMachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.FromState <em>From State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.FromState
	 * @generated
	 */
	public Adapter createFromStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.ToState <em>To State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.ToState
	 * @generated
	 */
	public Adapter createToStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Index <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Index
	 * @generated
	 */
	public Adapter createIndexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.ClassPersistence <em>Class Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.ClassPersistence
	 * @generated
	 */
	public Adapter createClassPersistenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.AttributePersistence <em>Attribute Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.AttributePersistence
	 * @generated
	 */
	public Adapter createAttributePersistenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.AssociationEndPersistence <em>Association End Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.AssociationEndPersistence
	 * @generated
	 */
	public Adapter createAssociationEndPersistenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.SpecializationGroup <em>Specialization Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.SpecializationGroup
	 * @generated
	 */
	public Adapter createSpecializationGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Specialization <em>Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Specialization
	 * @generated
	 */
	public Adapter createSpecializationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
