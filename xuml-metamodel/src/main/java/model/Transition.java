/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Transition#getEvent <em>Event</em>}</li>
 *   <li>{@link model.Transition#getFromState <em>From State</em>}</li>
 *   <li>{@link model.Transition#getToState <em>To State</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends Named {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Event#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' container reference.
	 * @see #setEvent(Event)
	 * @see model.ModelPackage#getTransition_Event()
	 * @see model.Event#getTransition
	 * @model opposite="transition" required="true" transient="false"
	 * @generated
	 */
	Event getEvent();

	/**
	 * Sets the value of the '{@link model.Transition#getEvent <em>Event</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' container reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Event value);

	/**
	 * Returns the value of the '<em><b>From State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.FromState#getTransitionTo <em>Transition To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From State</em>' reference.
	 * @see #setFromState(FromState)
	 * @see model.ModelPackage#getTransition_FromState()
	 * @see model.FromState#getTransitionTo
	 * @model opposite="transitionTo" required="true"
	 * @generated
	 */
	FromState getFromState();

	/**
	 * Sets the value of the '{@link model.Transition#getFromState <em>From State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From State</em>' reference.
	 * @see #getFromState()
	 * @generated
	 */
	void setFromState(FromState value);

	/**
	 * Returns the value of the '<em><b>To State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.ToState#getTransitionFrom <em>Transition From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To State</em>' reference.
	 * @see #setToState(ToState)
	 * @see model.ModelPackage#getTransition_ToState()
	 * @see model.ToState#getTransitionFrom
	 * @model opposite="transitionFrom" required="true"
	 * @generated
	 */
	ToState getToState();

	/**
	 * Sets the value of the '{@link model.Transition#getToState <em>To State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To State</em>' reference.
	 * @see #getToState()
	 * @generated
	 */
	void setToState(ToState value);

} // Transition
