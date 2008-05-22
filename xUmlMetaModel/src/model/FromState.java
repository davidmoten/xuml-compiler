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
 * A representation of the model object '<em><b>From State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.FromState#getTransitionTo <em>Transition To</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getFromState()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface FromState extends Stately {
	/**
	 * Returns the value of the '<em><b>Transition To</b></em>' reference list.
	 * The list contents are of type {@link model.Transition}.
	 * It is bidirectional and its opposite is '{@link model.Transition#getFromState <em>From State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition To</em>' reference list.
	 * @see model.ModelPackage#getFromState_TransitionTo()
	 * @see model.Transition#getFromState
	 * @model opposite="fromState" required="true"
	 * @generated
	 */
	EList<Transition> getTransitionTo();

} // FromState
