/**
 * <copyright>
 * </copyright>
 *
 * $Id: FreeType.java,v 1.2 2008/05/23 05:15:12 dxm Exp $
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Free Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.FreeType#getType <em>Type</em>}</li>
 *   <li>{@link model.FreeType#isMultiple <em>Multiple</em>}</li>
 *   <li>{@link model.FreeType#getSystem <em>System</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getFreeType()
 * @model
 * @generated
 */
public interface FreeType extends Type {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see model.ModelPackage#getFreeType_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link model.FreeType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple</em>' attribute.
	 * @see #setMultiple(boolean)
	 * @see model.ModelPackage#getFreeType_Multiple()
	 * @model required="true"
	 * @generated
	 */
	boolean isMultiple();

	/**
	 * Sets the value of the '{@link model.FreeType#isMultiple <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiple</em>' attribute.
	 * @see #isMultiple()
	 * @generated
	 */
	void setMultiple(boolean value);

	/**
	 * Returns the value of the '<em><b>System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.System#getFreeType <em>Free Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' container reference.
	 * @see #setSystem(model.System)
	 * @see model.ModelPackage#getFreeType_System()
	 * @see model.System#getFreeType
	 * @model opposite="freeType" required="true" transient="false"
	 * @generated
	 */
	model.System getSystem();

	/**
	 * Sets the value of the '{@link model.FreeType#getSystem <em>System</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' container reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(model.System value);

} // FreeType
