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
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Package#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.Package#getSubPackage <em>Sub Package</em>}</li>
 *   <li>{@link model.Package#getParent <em>Parent</em>}</li>
 *   <li>{@link model.Package#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends Named {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' containment reference list.
	 * The list contents are of type {@link model.Class}.
	 * It is bidirectional and its opposite is '{@link model.Class#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' containment reference list.
	 * @see model.ModelPackage#getPackage_Class()
	 * @see model.Class#getPackage
	 * @model opposite="package" containment="true"
	 * @generated
	 */
	EList<model.Class> getClass_();

	/**
	 * Returns the value of the '<em><b>Sub Package</b></em>' containment reference list.
	 * The list contents are of type {@link model.Package}.
	 * It is bidirectional and its opposite is '{@link model.Package#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Package</em>' containment reference list.
	 * @see model.ModelPackage#getPackage_SubPackage()
	 * @see model.Package#getParent
	 * @model opposite="parent" containment="true" keys="name"
	 * @generated
	 */
	EList<Package> getSubPackage();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Package#getSubPackage <em>Sub Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Package)
	 * @see model.ModelPackage#getPackage_Parent()
	 * @see model.Package#getSubPackage
	 * @model opposite="subPackage" transient="false"
	 * @generated
	 */
	Package getParent();

	/**
	 * Sets the value of the '{@link model.Package#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Package value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' containment reference list.
	 * The list contents are of type {@link model.DataType}.
	 * It is bidirectional and its opposite is '{@link model.DataType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' containment reference list.
	 * @see model.ModelPackage#getPackage_DataType()
	 * @see model.DataType#getPackage
	 * @model opposite="package" containment="true"
	 * @generated
	 */
	EList<DataType> getDataType();

} // Package
