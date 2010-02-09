/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.ToState#getTransitionFrom <em>Transition From</em>}</li>
 *   <li>{@link model.ToState#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getToState()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ToState extends Stately {
	/**
	 * Returns the value of the '<em><b>Transition From</b></em>' reference list.
	 * The list contents are of type {@link model.Transition}.
	 * It is bidirectional and its opposite is '{@link model.Transition#getToState <em>To State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition From</em>' reference list.
	 * @see model.ModelPackage#getToState_TransitionFrom()
	 * @see model.Transition#getToState
	 * @model opposite="toState" required="true"
	 * @generated
	 */
	EList<Transition> getTransitionFrom();

	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference list.
	 * The list contents are of type {@link model.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference list.
	 * @see model.ModelPackage#getToState_Event()
	 * @model
	 * @generated
	 */
	EList<Event> getEvent();

} // ToState
