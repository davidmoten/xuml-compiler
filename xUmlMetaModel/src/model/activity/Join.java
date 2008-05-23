/**
 * <copyright>
 * </copyright>
 *
 * $Id: Join.java,v 1.2 2008/05/23 05:15:15 dxm Exp $
 */
package model.activity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.activity.Join#getNextNode <em>Next Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.activity.ActivityPackage#getJoin()
 * @model
 * @generated
 */
public interface Join extends ActivityNode {
	/**
	 * Returns the value of the '<em><b>Next Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Node</em>' reference.
	 * @see #setNextNode(ActivityNode)
	 * @see model.activity.ActivityPackage#getJoin_NextNode()
	 * @model required="true"
	 * @generated
	 */
	ActivityNode getNextNode();

	/**
	 * Sets the value of the '{@link model.activity.Join#getNextNode <em>Next Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Node</em>' reference.
	 * @see #getNextNode()
	 * @generated
	 */
	void setNextNode(ActivityNode value);

} // Join
