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
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.DataType#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link model.DataType#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends Named {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link model.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see model.ModelPackage#getDataType_Attribute()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<Type> getAttribute();

	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Package#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(model.Package)
	 * @see model.ModelPackage#getDataType_Package()
	 * @see model.Package#getDataType
	 * @model opposite="dataType" required="true" transient="false"
	 * @generated
	 */
	model.Package getPackage();

	/**
	 * Sets the value of the '{@link model.DataType#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(model.Package value);

} // DataType
