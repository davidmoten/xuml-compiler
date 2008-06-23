/**
 * <copyright>
 * </copyright>
 *
 * $Id: SpecializationGroup.java,v 1.3 2008/06/11 07:28:38 dxm Exp $
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialization Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.SpecializationGroup#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link model.SpecializationGroup#getSpecialization <em>Specialization</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getSpecializationGroup()
 * @model
 * @generated
 */
public interface SpecializationGroup extends Named {
	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Class#getSpecializationGroup <em>Specialization Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' container reference.
	 * @see #setSuperClass(model.Class)
	 * @see model.ModelPackage#getSpecializationGroup_SuperClass()
	 * @see model.Class#getSpecializationGroup
	 * @model opposite="specializationGroup" required="true" transient="false"
	 * @generated
	 */
	model.Class getSuperClass();

	/**
	 * Sets the value of the '{@link model.SpecializationGroup#getSuperClass <em>Super Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' container reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(model.Class value);

	/**
	 * Returns the value of the '<em><b>Specialization</b></em>' reference list.
	 * The list contents are of type {@link model.Specialization}.
	 * It is bidirectional and its opposite is '{@link model.Specialization#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialization</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialization</em>' reference list.
	 * @see model.ModelPackage#getSpecializationGroup_Specialization()
	 * @see model.Specialization#getGroup
	 * @model opposite="group" required="true"
	 * @generated
	 */
	EList<Specialization> getSpecialization();

} // SpecializationGroup
