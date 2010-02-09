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
 * A representation of the model object '<em><b>Operation Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.OperationSignature#getParameter <em>Parameter</em>}</li>
 *   <li>{@link model.OperationSignature#getReturns <em>Returns</em>}</li>
 *   <li>{@link model.OperationSignature#isReturnsMultiple <em>Returns Multiple</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getOperationSignature()
 * @model
 * @generated
 */
public interface OperationSignature extends Named {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link model.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see model.ModelPackage#getOperationSignature_Parameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameter();

	/**
	 * Returns the value of the '<em><b>Returns</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returns</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Returns</em>' reference.
	 * @see #setReturns(Type)
	 * @see model.ModelPackage#getOperationSignature_Returns()
	 * @model
	 * @generated
	 */
	Type getReturns();

	/**
	 * Sets the value of the '{@link model.OperationSignature#getReturns <em>Returns</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returns</em>' reference.
	 * @see #getReturns()
	 * @generated
	 */
	void setReturns(Type value);

	/**
	 * Returns the value of the '<em><b>Returns Multiple</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returns Multiple</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Returns Multiple</em>' attribute.
	 * @see #setReturnsMultiple(boolean)
	 * @see model.ModelPackage#getOperationSignature_ReturnsMultiple()
	 * @model default="false"
	 * @generated
	 */
	boolean isReturnsMultiple();

	/**
	 * Sets the value of the '{@link model.OperationSignature#isReturnsMultiple <em>Returns Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returns Multiple</em>' attribute.
	 * @see #isReturnsMultiple()
	 * @generated
	 */
	void setReturnsMultiple(boolean value);

} // OperationSignature
