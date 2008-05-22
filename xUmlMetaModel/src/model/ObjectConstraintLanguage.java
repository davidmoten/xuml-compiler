/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Constraint Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.ObjectConstraintLanguage#getOcl <em>Ocl</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getObjectConstraintLanguage()
 * @model
 * @generated
 */
public interface ObjectConstraintLanguage extends Named {
	/**
	 * Returns the value of the '<em><b>Ocl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl</em>' attribute.
	 * @see #setOcl(String)
	 * @see model.ModelPackage#getObjectConstraintLanguage_Ocl()
	 * @model required="true"
	 * @generated
	 */
	String getOcl();

	/**
	 * Sets the value of the '{@link model.ObjectConstraintLanguage#getOcl <em>Ocl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl</em>' attribute.
	 * @see #getOcl()
	 * @generated
	 */
	void setOcl(String value);

} // ObjectConstraintLanguage
