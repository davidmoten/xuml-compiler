/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Operation#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends OperationSignature {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference.
	 * @see #setAction(ActionLanguage)
	 * @see model.ModelPackage#getOperation_Action()
	 * @model containment="true"
	 * @generated
	 */
	ActionLanguage getAction();

	/**
	 * Sets the value of the '{@link model.Operation#getAction <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' containment reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ActionLanguage value);

} // Operation
