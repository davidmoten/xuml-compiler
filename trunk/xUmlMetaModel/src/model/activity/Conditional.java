/**
 * <copyright>
 * </copyright>
 *
 * $Id: Conditional.java,v 1.2 2008/05/23 05:15:14 dxm Exp $
 */
package model.activity;

import model.use.Condition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.activity.Conditional#getCondition <em>Condition</em>}</li>
 *   <li>{@link model.activity.Conditional#getNextNodeOnTrue <em>Next Node On True</em>}</li>
 *   <li>{@link model.activity.Conditional#getNextNodeOnFalse <em>Next Node On False</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.activity.ActivityPackage#getConditional()
 * @model
 * @generated
 */
public interface Conditional extends ActivityNode {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(Condition)
	 * @see model.activity.ActivityPackage#getConditional_Condition()
	 * @model required="true"
	 * @generated
	 */
	Condition getCondition();

	/**
	 * Sets the value of the '{@link model.activity.Conditional#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Condition value);

	/**
	 * Returns the value of the '<em><b>Next Node On True</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Node On True</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Node On True</em>' reference.
	 * @see #setNextNodeOnTrue(ActivityNode)
	 * @see model.activity.ActivityPackage#getConditional_NextNodeOnTrue()
	 * @model required="true"
	 * @generated
	 */
	ActivityNode getNextNodeOnTrue();

	/**
	 * Sets the value of the '{@link model.activity.Conditional#getNextNodeOnTrue <em>Next Node On True</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Node On True</em>' reference.
	 * @see #getNextNodeOnTrue()
	 * @generated
	 */
	void setNextNodeOnTrue(ActivityNode value);

	/**
	 * Returns the value of the '<em><b>Next Node On False</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Node On False</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Node On False</em>' reference.
	 * @see #setNextNodeOnFalse(ActivityNode)
	 * @see model.activity.ActivityPackage#getConditional_NextNodeOnFalse()
	 * @model required="true"
	 * @generated
	 */
	ActivityNode getNextNodeOnFalse();

	/**
	 * Sets the value of the '{@link model.activity.Conditional#getNextNodeOnFalse <em>Next Node On False</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Node On False</em>' reference.
	 * @see #getNextNodeOnFalse()
	 * @generated
	 */
	void setNextNodeOnFalse(ActivityNode value);

} // Conditional
