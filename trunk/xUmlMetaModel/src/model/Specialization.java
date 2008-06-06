/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Specialization#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getSpecialization()
 * @model
 * @generated
 */
public interface Specialization extends model.Class {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.SpecializationGroup#getSpecialization <em>Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' reference.
	 * @see #setGroup(SpecializationGroup)
	 * @see model.ModelPackage#getSpecialization_Group()
	 * @see model.SpecializationGroup#getSpecialization
	 * @model opposite="specialization" required="true"
	 * @generated
	 */
	SpecializationGroup getGroup();

	/**
	 * Sets the value of the '{@link model.Specialization#getGroup <em>Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(SpecializationGroup value);

} // Specialization
