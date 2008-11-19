/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.StateMachine#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.StateMachine#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link model.StateMachine#getState <em>State</em>}</li>
 *   <li>{@link model.StateMachine#getFinalState <em>Final State</em>}</li>
 *   <li>{@link model.StateMachine#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Class#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass(model.Class)
	 * @see model.ModelPackage#getStateMachine_Class()
	 * @see model.Class#getStateMachine
	 * @model opposite="stateMachine" required="true" transient="false"
	 * @generated
	 */
	model.Class getClass_();

	/**
	 * Sets the value of the '{@link model.StateMachine#getClass_ <em>Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(model.Class value);

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link model.InitialState#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' containment reference.
	 * @see #setInitialState(InitialState)
	 * @see model.ModelPackage#getStateMachine_InitialState()
	 * @see model.InitialState#getStateMachine
	 * @model opposite="stateMachine" containment="true" required="true"
	 * @generated
	 */
	InitialState getInitialState();

	/**
	 * Sets the value of the '{@link model.StateMachine#getInitialState <em>Initial State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' containment reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(InitialState value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference list.
	 * The list contents are of type {@link model.State}.
	 * It is bidirectional and its opposite is '{@link model.State#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference list.
	 * @see model.ModelPackage#getStateMachine_State()
	 * @see model.State#getStateMachine
	 * @model opposite="stateMachine" containment="true"
	 * @generated
	 */
	EList<State> getState();

	/**
	 * Returns the value of the '<em><b>Final State</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link model.FinalState#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final State</em>' containment reference.
	 * @see #setFinalState(FinalState)
	 * @see model.ModelPackage#getStateMachine_FinalState()
	 * @see model.FinalState#getStateMachine
	 * @model opposite="stateMachine" containment="true"
	 * @generated
	 */
	FinalState getFinalState();

	/**
	 * Sets the value of the '{@link model.StateMachine#getFinalState <em>Final State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final State</em>' containment reference.
	 * @see #getFinalState()
	 * @generated
	 */
	void setFinalState(FinalState value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference list.
	 * The list contents are of type {@link model.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' containment reference list.
	 * @see model.ModelPackage#getStateMachine_Event()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvent();

} // StateMachine
