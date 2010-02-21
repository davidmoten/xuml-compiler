/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.State#getEntryProcedure <em>Entry Procedure</em>}</li>
 *   <li>{@link model.State#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getState()
 * @model
 * @generated
 */
public interface State extends ToState, FromState {
	/**
	 * Returns the value of the '<em><b>Entry Procedure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Procedure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Procedure</em>' containment reference.
	 * @see #setEntryProcedure(Procedure)
	 * @see model.ModelPackage#getState_EntryProcedure()
	 * @model containment="true"
	 * @generated
	 */
	Procedure getEntryProcedure();

	/**
	 * Sets the value of the '{@link model.State#getEntryProcedure <em>Entry Procedure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Procedure</em>' containment reference.
	 * @see #getEntryProcedure()
	 * @generated
	 */
	void setEntryProcedure(Procedure value);

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.StateMachine#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Machine</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' container reference.
	 * @see #setStateMachine(StateMachine)
	 * @see model.ModelPackage#getState_StateMachine()
	 * @see model.StateMachine#getState
	 * @model opposite="state" required="true" transient="false"
	 * @generated
	 */
	StateMachine getStateMachine();

	/**
	 * Sets the value of the '{@link model.State#getStateMachine <em>State Machine</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' container reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachine value);

} // State
