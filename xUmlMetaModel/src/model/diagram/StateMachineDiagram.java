/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.diagram;

import model.StateMachine;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.diagram.StateMachineDiagram#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.diagram.DiagramPackage#getStateMachineDiagram()
 * @model
 * @generated
 */
public interface StateMachineDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' reference.
	 * @see #setStateMachine(StateMachine)
	 * @see model.diagram.DiagramPackage#getStateMachineDiagram_StateMachine()
	 * @model required="true"
	 * @generated
	 */
	StateMachine getStateMachine();

	/**
	 * Sets the value of the '{@link model.diagram.StateMachineDiagram#getStateMachine <em>State Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachine value);

} // StateMachineDiagram
