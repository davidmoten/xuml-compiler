/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Final State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.FinalState#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getFinalState()
 * @model
 * @generated
 */
public interface FinalState extends ToState {
	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.StateMachine#getFinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Machine</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' container reference.
	 * @see #setStateMachine(StateMachine)
	 * @see model.ModelPackage#getFinalState_StateMachine()
	 * @see model.StateMachine#getFinalState
	 * @model opposite="finalState" required="true" transient="false"
	 * @generated
	 */
	StateMachine getStateMachine();

	/**
	 * Sets the value of the '{@link model.FinalState#getStateMachine <em>State Machine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' container reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachine value);

} // FinalState
